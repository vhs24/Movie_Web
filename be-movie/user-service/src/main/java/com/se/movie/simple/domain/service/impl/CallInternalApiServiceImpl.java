package com.se.movie.simple.domain.service.impl;

import com.se.movie.simple.domain.service.CallInternalApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class CallInternalApiServiceImpl implements CallInternalApiService {
    @Override
    public <T> T callInternalApiWithParam(Map<String, Object> requestParam, TypeReference<T> typeReference) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> T callInternalApiWithObject(Object requestObject, TypeReference<T> typeReference) {
        // TODO Auto-generated method stub
        return null;
    }

}
