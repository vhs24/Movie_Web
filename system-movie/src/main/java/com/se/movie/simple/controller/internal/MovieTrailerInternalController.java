package com.se.movie.simple.controller.internal;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.se.movie.simple.domain.common.GeneratorCommonUtil;
import com.se.movie.simple.domain.entity.MovieTrailer;
import com.se.movie.simple.domain.payload.request.CreateInternalApiRequest;
import com.se.movie.simple.domain.payload.request.GetInternalApiRequest;
import com.se.movie.simple.domain.service.MovieTrailerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/internal/movie-trailer")
public class MovieTrailerInternalController {

	private final MovieTrailerService movieTrailerService;

	@PostMapping("/insertMovieTrailer")
	@ResponseBody
	public String insertMovieTrailer(@RequestBody CreateInternalApiRequest<MovieTrailer> request) {
		try {

			List<String> results = movieTrailerService.save(request.getRecords());
			return GeneratorCommonUtil.getResponseBodySuccess(results);
		} catch (Exception e) {
			return GeneratorCommonUtil.getResponseBodyError(List.of(e.getMessage()));
		}
	}

	@PostMapping("/getMovieTrailer")
	@ResponseBody
	public String getMovieTrailer(@RequestBody GetInternalApiRequest request) {
		try {
			List<MovieTrailer> results = movieTrailerService.getMovieTrailer(request);
			return GeneratorCommonUtil.getResponseBodySuccess(results);
		} catch (Exception e) {
			return GeneratorCommonUtil.getResponseBodyError(List.of(e.getMessage()));
		}
	}
}
