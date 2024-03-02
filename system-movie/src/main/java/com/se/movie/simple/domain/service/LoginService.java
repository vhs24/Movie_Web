package com.se.movie.simple.domain.service;

import com.se.movie.simple.controller.LoginController.LoginRequest;

public interface LoginService {

	String doLogin(LoginRequest loginRequest);

}