package com.se.movie.simple.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.se.movie.simple.domain.entity.MovieTrailer;

public interface MovieTrailerRepository extends JpaRepository<MovieTrailer, String>{

}
