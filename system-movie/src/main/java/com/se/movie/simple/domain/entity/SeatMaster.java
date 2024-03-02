package com.se.movie.simple.domain.entity;

import org.hibernate.annotations.UuidGenerator;
import org.hibernate.annotations.UuidGenerator.Style;

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
@Table(name="booking_info")
public class SeatMaster {

	@Id
    @GeneratedValue
    @UuidGenerator(style = Style.TIME)
    @Column(name = "id", updatable = false, nullable = false)
	private String id;
	
	@Column(nullable = false)
	private int seatRow;
	
	@Column(nullable = false)
	private int seatColume;
	
	@Column(nullable = false)
	private byte usableStatus;
	
	@Column(nullable = false)
	private String siteInfoId;
}
