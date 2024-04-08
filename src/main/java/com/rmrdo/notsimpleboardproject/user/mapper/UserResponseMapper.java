package com.rmrdo.notsimpleboardproject.user.mapper;

import com.rmrdo.notsimpleboardproject.common.mapper.GenericMapper;
import com.rmrdo.notsimpleboardproject.user.dto.UserResponse;
import com.rmrdo.notsimpleboardproject.user.dto.UserUnregisterRequest;
import com.rmrdo.notsimpleboardproject.user.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserResponseMapper extends GenericMapper<UserResponse, UserEntity> {

	UserResponseMapper INSTANCE = Mappers.getMapper(UserResponseMapper.class);

	UserEntity userUnregisterRequestToEntity(UserUnregisterRequest userUnregisterRequest);
}
