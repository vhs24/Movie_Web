package com.se.movie.simple.domain.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.se.movie.simple.domain.db.read.RMovieInfoMapper;
import com.se.movie.simple.domain.entity.MovieInfo;
import com.se.movie.simple.domain.payload.request.GetInternalApiRequest;
import com.se.movie.simple.domain.repository.MovieInfoRepository;
import com.se.movie.simple.domain.service.MovieInfoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieInfoServiceImpl implements MovieInfoService {

	private final MovieInfoRepository repository;
	private final RMovieInfoMapper movieInfoMapper;
	private final ObjectMapper objectMapper;
	
	@Override
	public List<String> save(List<MovieInfo> records) throws Exception {
		try {
			List<MovieInfo> movieInfos = repository.saveAll(records);
			return movieInfos.stream()
					.map(MovieInfo::getId)
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@Override
	public List<MovieInfo> getMovieInfo(GetInternalApiRequest request) throws Exception {
		try {
			List<Map<String, Object>> results = movieInfoMapper.selectWhere(request.getConditionStr());
			List<MovieInfo> movieInfos = objectMapper.convertValue(results, new TypeReference<List<MovieInfo>>() {});
			return movieInfos;
		} catch (Exception e) {
			throw new Exception();
		}
	}

}
