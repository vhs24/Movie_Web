package com.se.movie.simple.domain.entity;

import java.time.LocalDate;

import org.hibernate.annotations.UuidGenerator;
import org.hibernate.annotations.UuidGenerator.Style;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="movie_info")
public class MovieInfo {

	@Id
    @GeneratedValue
    @UuidGenerator(style = Style.TIME)
    @Column(name = "id", updatable = false, nullable = false)
	private String id;

	@Column(nullable = false)
	private String movieName;

	private String movieSubName;

	private String starrings;

	private String creators;

	@Column(nullable = false)
	private long durationMin;

	private String description;
	private String image;

	@Column(nullable = false)
	private String thumnail;

	@Column(nullable = false)
	private String productionId;

	@Column(nullable = false)
	private int yearReleaseAt;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
	private LocalDate registAt;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
	private LocalDate updateAt;
}
