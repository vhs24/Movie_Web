package com.se.movie.simple.domain.payload.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

	private String userName;
	private String password;
}
