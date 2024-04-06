package com.rmrdo.notsimpleboardproject.user.entity.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserRole {

	NORMAL("일반 사용자"),
	ADMIN("관리자"),
	;

	private final String description;
}
