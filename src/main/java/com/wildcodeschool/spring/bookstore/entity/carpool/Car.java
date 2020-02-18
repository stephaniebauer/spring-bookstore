package com.wildcodeschool.spring.bookstore.entity.carpool;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.wildcodeschool.spring.bookstore.entity.Customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String model;

	@ManyToMany(mappedBy = "cars")
	//@NotNull
	private Set<Customer> owners;

}
