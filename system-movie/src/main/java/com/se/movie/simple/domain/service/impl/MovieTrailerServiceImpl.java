package com.se.movie.simple.domain.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.se.movie.simple.domain.db.read.RMovieTrailerMapper;
import com.se.movie.simple.domain.entity.MovieTrailer;
import com.se.movie.simple.domain.payload.request.GetInternalApiRequest;
import com.se.movie.simple.domain.repository.MovieTrailerRepository;
import com.se.movie.simple.domain.service.MovieTrailerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieTrailerServiceImpl implements MovieTrailerService{

	private final MovieTrailerRepository movieTrailerRepository;
	private final RMovieTrailerMapper movieTrailerMapper;
	private final ObjectMapper objectMapper;
	
	@Override
	public List<String> save(List<MovieTrailer> records) throws Exception {
		try {
			List<MovieTrailer> movieTrailers = movieTrailerRepository.saveAll(records);
			return movieTrailers.stream()
					.map(MovieTrailer::getId)
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@Override
	public List<MovieTrailer> getMovieTrailer(GetInternalApiRequest request) throws Exception {
		try {
			List<Map<String, Object>> results = movieTrailerMapper.selectWhere(request.getConditionStr());
			List<MovieTrailer> movieTrailers = objectMapper.convertValue(results, new TypeReference<List<MovieTrailer>>() {});
			return movieTrailers;
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	
}
