package com.se.movie.simple.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.se.movie.simple.domain.entity.GenreType;

@Repository
public interface GenreTypeRepository extends JpaRepository<GenreType, String>{

}
