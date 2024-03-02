package com.se.movie.simple.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.se.movie.simple.domain.entity.MovieGenre;

@Repository
public interface MovieGenreRepository extends JpaRepository<MovieGenre, String>{

}
