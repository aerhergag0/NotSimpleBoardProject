package com.rmrdo.notsimpleboardproject.user.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SessionUser implements Serializable {

	private String name;
	private String email;
	private String picture;
}
