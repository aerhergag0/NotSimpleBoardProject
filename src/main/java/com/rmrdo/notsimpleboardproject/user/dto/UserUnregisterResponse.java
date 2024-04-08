package com.rmrdo.notsimpleboardproject.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUnregisterResponse {

	private UUID   id;
	private String userId;
	private String userName;
}
