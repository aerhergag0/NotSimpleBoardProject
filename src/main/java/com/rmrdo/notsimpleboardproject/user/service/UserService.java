package com.rmrdo.notsimpleboardproject.user.service;

import com.rmrdo.notsimpleboardproject.user.dto.UserRegisterRequest;
import com.rmrdo.notsimpleboardproject.user.dto.UserResponse;
import com.rmrdo.notsimpleboardproject.user.dto.UserUnregisterRequest;
import com.rmrdo.notsimpleboardproject.user.dto.UserUnregisterResponse;
import com.rmrdo.notsimpleboardproject.user.mapper.UserMapper;
import com.rmrdo.notsimpleboardproject.user.mapper.UserRequestMapper;
import com.rmrdo.notsimpleboardproject.user.mapper.UserResponseMapper;
import com.rmrdo.notsimpleboardproject.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository      userRepository;
	private final StringRedisTemplate stringRedisTemplate;

	private static final UserResponseMapper userResponseMapper = UserResponseMapper.INSTANCE;
	private static final UserRequestMapper  userRequestMapper  = UserRequestMapper.INSTANCE;
	private static final UserMapper         userMapper         = UserMapper.INSTANCE;

	public UserResponse register(UserRegisterRequest userRegisterRequest) {

		var userEntity = userRequestMapper.toEntity(userRegisterRequest);
		var newEntity = userRepository.save(userEntity);

		var newResponse = userResponseMapper.toDto(newEntity);
		return newResponse;
	}

	public UserUnregisterResponse unregister(UserUnregisterRequest userUnregisterRequest) {

		var userEntity = userResponseMapper.userUnregisterRequestToEntity(userUnregisterRequest);

		var getEntity = userRepository.findByUserId(userEntity.getUserId())
				.orElseThrow(() -> new RuntimeException("Not Found"));
		UUID userUUID = getEntity.getId();

		userRepository.deleteById(userUUID);

		return userMapper.userUnregisterRequestToUserUnregisterResponse(getEntity);
	}

	public String loginAndGetToken(UserUnregisterRequest userUnregisterRequest) {

		String cashedToken = getCachedToken(userUnregisterRequest.getUserId());

		if (cashedToken != null) {
			return cashedToken;
		}

		var userEntity = userRepository.findByUserId(userUnregisterRequest.getUserId())
				.orElseThrow(() -> new RuntimeException("Not Found"));

		if (userEntity != null && userEntity.getPassword().equals(userUnregisterRequest.getPassword())) {
			String token = generateRandomToken();
			cacheToken(userEntity.getUserId(), token);
			return token;
		}

		return null;
	}

	private String getCachedToken(String userId) {
		return stringRedisTemplate.opsForValue().get("token:" + userId);
	}

	private void cacheToken(String userId, String token) {
		stringRedisTemplate.opsForValue().set("token:" + userId, token, Duration.ofMinutes(30));
	}

	private String generateRandomToken() {
		return UUID.randomUUID().toString();
	}
}
