package com.rmrdo.notsimpleboardproject.user.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRole {

	ROLE_USER("ROLE_USER", "일반 사용자"),
	ROLE_ADMIN("ROLE_ADMIN", "관리자"),
	;

	private final String key;
	private final String description;
}
