package com.se.movie.simple.domain.service.impl;

import org.springframework.stereotype.Service;

import com.se.movie.simple.domain.entity.UserToken;
import com.se.movie.simple.domain.repository.UserTokenRepository;
import com.se.movie.simple.domain.service.UserTokenService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserTokenServiceImpl implements UserTokenService {

	private final UserTokenRepository userTokenRepository;
	
	@Override
	public String save(UserToken userToken) {
		try {			
			UserToken token = userTokenRepository.save(userToken);
			return token.getRefeshToken();
		} catch (Exception e) {
			return null;
		}
	}
}
