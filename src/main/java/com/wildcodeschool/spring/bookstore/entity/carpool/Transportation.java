package com.wildcodeschool.spring.bookstore.entity.carpool;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.wildcodeschool.spring.bookstore.entity.Customer;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="transportation")
@Getter
@Setter

public class Transportation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@ManyToOne
	@JoinColumn
	private Car car;
	
	
	@ManyToOne
	@JoinColumn
	private Customer customers;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate transportation_end;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate transportation_start;

	
	
}
