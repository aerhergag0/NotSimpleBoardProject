package com.rmrdo.notsimpleboardproject.user.entity.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserStatus {

	ACTIVE("활성된 사용자"),
	INACTIVE("비활성된 사용자"),
	DELETED("삭제된 사용자"),
	LOCKED("잠긴 사용자");

	private final String description;
}
