package com.se.movie.simple.domain.service;

import com.se.movie.simple.domain.payload.dto.LoginFaiedLogDto;

import java.time.LocalDateTime;

public interface LoginFaiedLogService {
    LoginFaiedLogDto getLoginFaiedLog(String email, LocalDateTime nowStamp);
}
