package com.rmrdo.notsimpleboardproject.user.dto;

import com.rmrdo.notsimpleboardproject.user.entity.enums.UserRole;
import com.rmrdo.notsimpleboardproject.user.entity.enums.UserStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRegisterRequest {

	private static final String DEFAULT_PROFILE_IMG =
			"https://notsimpleboardproject.s3.ap-northeast-2.amazonaws.com/default_profile_img.png";

	@NotBlank
	private String userId;

	@NotBlank
	private String password;

	@NotBlank
	private String userName;

	@NotBlank
	@Email
	private String email;

	private String phoneNumber;

	@Builder.Default
	private String profileImg = DEFAULT_PROFILE_IMG;

	@Builder.Default
	private UserStatus status = UserStatus.ACTIVE;

	@Builder.Default
	private UserRole role = UserRole.ROLE_USER;
}
