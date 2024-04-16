package com.rmrdo.notsimpleboardproject;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/test")
public class TestController {

	@GetMapping
	public Object securityTest(Authentication authentication) {
		return authentication.getPrincipal();
	}
}
