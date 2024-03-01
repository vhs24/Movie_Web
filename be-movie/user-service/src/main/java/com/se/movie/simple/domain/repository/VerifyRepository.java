package com.se.movie.simple.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.se.movie.simple.domain.entity.UserVerify;

public interface VerifyRepository extends JpaRepository<UserVerify, String>{

}
