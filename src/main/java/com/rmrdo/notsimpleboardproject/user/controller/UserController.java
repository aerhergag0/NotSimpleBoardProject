package com.rmrdo.notsimpleboardproject.user.controller;

import com.rmrdo.notsimpleboardproject.common.utils.ApiUtils.ApiResult;
import com.rmrdo.notsimpleboardproject.user.dto.UserRegisterRequest;
import com.rmrdo.notsimpleboardproject.user.dto.UserResponse;
import com.rmrdo.notsimpleboardproject.user.dto.UserUnregisterRequest;
import com.rmrdo.notsimpleboardproject.user.dto.UserUnregisterResponse;
import com.rmrdo.notsimpleboardproject.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.rmrdo.notsimpleboardproject.common.utils.ApiUtils.success;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/user")
public class UserController {

	private final UserService userService;

	@PostMapping("/register")
	public ApiResult<UserResponse> userRegister(@RequestBody UserRegisterRequest userRegisterRequest) {
		var response = userService.register(userRegisterRequest);
		return success(response);
	}

	@DeleteMapping("/unregister")
	public ApiResult<UserUnregisterResponse> userUnregister(@RequestBody UserUnregisterRequest userUnregisterRequest) {
		var response = userService.unregister(userUnregisterRequest);
		return success("User " + response.getUserId() + " has been deleted", response);
	}
}
