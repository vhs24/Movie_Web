package com.se.movie.simple.controller.internal;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.se.movie.simple.domain.common.GeneratorCommonUtil;
import com.se.movie.simple.domain.entity.GenreType;
import com.se.movie.simple.domain.payload.request.GetInternalApiRequest;
import com.se.movie.simple.domain.service.GenreTypeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/internal/genre")
public class GenreTypeInternalController {

	private final GenreTypeService genreTypeService;

	@PostMapping("/insertGenreType")
	@ResponseBody
	public String insertMovie(@RequestBody List<GenreType> records) {
		try {
			List<String> results = genreTypeService.save(records);
			return GeneratorCommonUtil.getResponseBodySuccess(results);
		} catch (Exception e) {
			return GeneratorCommonUtil.getResponseBodyError(List.of(e.getMessage()));
		}
	}

	@PostMapping("/getGenreType")
	@ResponseBody
	public String getGenreType(@RequestBody GetInternalApiRequest request) {
		try {
			List<GenreType> results = genreTypeService.getGenreType(request);
			return GeneratorCommonUtil.getResponseBodySuccess(results);
		} catch (Exception e) {
			return GeneratorCommonUtil.getResponseBodyError(List.of(e.getMessage()));
		}
	}
}
 49 changes: 49 additions & 0 deletions49  
