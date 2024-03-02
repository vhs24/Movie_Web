package com.se.movie.simple.domain.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.se.movie.simple.domain.db.read.RMovieBannerMapper;
import com.se.movie.simple.domain.entity.MovieBanner;
import com.se.movie.simple.domain.payload.request.GetInternalApiRequest;
import com.se.movie.simple.domain.repository.MovieBannerRepository;
import com.se.movie.simple.domain.service.MovieBannerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieBannerServiceImpl implements MovieBannerService {
	
	private final MovieBannerRepository movieBannerRepository;
	private final RMovieBannerMapper rMovieBannerMapper;
	private final ObjectMapper objectMapper;
	
	@Override
	public List<String> save(List<MovieBanner> records) throws Exception {
		try {
			List<MovieBanner> movieBanners = movieBannerRepository.saveAll(records);
			return movieBanners.stream()
					.map(MovieBanner::getId)
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@Override
	public List<MovieBanner> getMovieBanner(GetInternalApiRequest request) throws Exception {
		try {
			List<Map<String, Object>> results = rMovieBannerMapper.selectWhere(request.getConditionStr());
			List<MovieBanner> movieBanners = objectMapper.convertValue(results, new TypeReference<List<MovieBanner>>() {});
			return movieBanners;
		} catch (Exception e) {
			throw new Exception();
		}
	}

}
