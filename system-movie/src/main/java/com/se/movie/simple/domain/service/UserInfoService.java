package com.se.movie.simple.domain.service;

import java.util.List;

import com.se.movie.simple.domain.entity.UserInfo;

public interface UserInfoService {

	UserInfo getUserByUserName(String userName);
	
	List<String> save(List<UserInfo> records);

}
