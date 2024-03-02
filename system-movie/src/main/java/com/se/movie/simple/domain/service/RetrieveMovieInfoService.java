package com.se.movie.simple.domain.service;

import org.springframework.stereotype.Service;

import com.se.movie.simple.controller.RetrieveMovieInfoController.RetrieveMovieInfoRequest;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RetrieveMovieInfoService {

	@Data
	public static class RetrieveMovieInfoResponse{
		
	}
	
	public String execute(RetrieveMovieInfoRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
