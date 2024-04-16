package com.rmrdo.notsimpleboardproject.user.controller;

import com.rmrdo.notsimpleboardproject.common.utils.ApiUtils.ApiResult;
import com.rmrdo.notsimpleboardproject.user.dto.UserUnregisterRequest;
import com.rmrdo.notsimpleboardproject.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.rmrdo.notsimpleboardproject.common.utils.ApiUtils.success;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class LoginController {

	private final UserService userService;

	@PostMapping("/login")
	public ApiResult<?> login(@RequestBody UserUnregisterRequest userUnregisterRequest) {
		return success(userService.loginAndGetToken(userUnregisterRequest));
	}

}
