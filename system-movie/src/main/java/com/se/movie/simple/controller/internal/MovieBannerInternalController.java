package com.se.movie.simple.controller.internal;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.se.movie.simple.domain.common.GeneratorCommonUtil;
import com.se.movie.simple.domain.entity.MovieBanner;
import com.se.movie.simple.domain.payload.request.CreateInternalApiRequest;
import com.se.movie.simple.domain.payload.request.GetInternalApiRequest;
import com.se.movie.simple.domain.service.MovieBannerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/internal/movie-banner")
public class MovieBannerInternalController {

	private final MovieBannerService movieBannerService;

	@PostMapping("/insertMovieBanner")
	@ResponseBody
	public String insertMovieTrailer(@RequestBody CreateInternalApiRequest<MovieBanner> request) {
		try {

			List<String> results = movieBannerService.save(request.getRecords());
			return GeneratorCommonUtil.getResponseBodySuccess(results);
		} catch (Exception e) {
			return GeneratorCommonUtil.getResponseBodyError(List.of(e.getMessage()));
		}
	}

	@PostMapping("/getMovieBanner")
	@ResponseBody
	public String getMovieBanner(@RequestBody GetInternalApiRequest request) {
		try {
			List<MovieBanner> results = movieBannerService.getMovieBanner(request);
			return GeneratorCommonUtil.getResponseBodySuccess(results);
		} catch (Exception e) {
			return GeneratorCommonUtil.getResponseBodyError(List.of(e.getMessage()));
		}
	}
}
