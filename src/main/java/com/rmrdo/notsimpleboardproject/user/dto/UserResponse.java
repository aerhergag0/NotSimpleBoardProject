package com.rmrdo.notsimpleboardproject.user.dto;

import com.rmrdo.notsimpleboardproject.user.entity.enums.UserRole;
import com.rmrdo.notsimpleboardproject.user.entity.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

	private UUID          id;
	private String        userId;
	private String        userName;
	private String        email;
	private String        phoneNumber;
	private UserRole      role;
	private String        profileImg;
	private UserStatus    status;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private LocalDateTime lastLoginAt;

}
