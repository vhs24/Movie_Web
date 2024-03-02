package com.se.movie.simple.domain.service.impl;

import org.springframework.stereotype.Service;

import com.se.movie.simple.controller.LoginController.LoginRequest;
import com.se.movie.simple.domain.service.LoginService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
	@Override
	public String doLogin(LoginRequest loginRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
