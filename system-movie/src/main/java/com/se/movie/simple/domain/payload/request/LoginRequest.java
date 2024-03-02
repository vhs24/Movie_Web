package com.se.movie.simple.domain.payload.request;

import lombok.Data;

@Data
public class LoginRequest {
	private String username;
	private String password;
}
