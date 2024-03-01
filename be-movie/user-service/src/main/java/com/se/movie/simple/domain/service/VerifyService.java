package com.se.movie.simple.domain.service;

import com.se.movie.simple.domain.payload.dto.VerifyDto;

public interface VerifyService {
    VerifyDto getVerify(String id);
}
