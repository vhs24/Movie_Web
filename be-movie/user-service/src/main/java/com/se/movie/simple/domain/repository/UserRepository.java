package com.se.movie.simple.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.se.movie.simple.domain.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

}
