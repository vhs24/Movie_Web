package com.se.movie.simple.controller.internal;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.se.movie.simple.domain.common.GeneratorCommonUtil;
import com.se.movie.simple.domain.entity.MovieInfo;
import com.se.movie.simple.domain.payload.request.CreateInternalApiRequest;
import com.se.movie.simple.domain.payload.request.GetInternalApiRequest;
import com.se.movie.simple.domain.service.MovieInfoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/internal/movie")
public class MovieInfoInternalController {

	private final MovieInfoService movieService;

	@PostMapping("/insertMovieInfo")
	@ResponseBody
	public String insertMovie(@RequestBody CreateInternalApiRequest<MovieInfo> request) {
		try {

			List<String> results = movieService.save(request.getRecords());
			return GeneratorCommonUtil.getResponseBodySuccess(results);
		} catch (Exception e) {
			return GeneratorCommonUtil.getResponseBodyError(List.of(e.getMessage()));
		}
	}

	@PostMapping("/getMovieInfo")
	@ResponseBody
	public String getMovie(@RequestBody GetInternalApiRequest request) {
		try {
			List<MovieInfo> results = movieService.getMovieInfo(request);
			return GeneratorCommonUtil.getResponseBodySuccess(results);
		} catch (Exception e) {
			return GeneratorCommonUtil.getResponseBodyError(List.of(e.getMessage()));
		}
	}
}
