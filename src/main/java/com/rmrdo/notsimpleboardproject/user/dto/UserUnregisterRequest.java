package com.rmrdo.notsimpleboardproject.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUnregisterRequest {

	private String userId;
	private String password;
}
