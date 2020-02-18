package com.wildcodeschool.spring.bookstore.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.wildcodeschool.spring.bookstore.entity.carpool.Car;
import com.wildcodeschool.spring.bookstore.repository.CarRepository;
import com.wildcodeschool.spring.bookstore.repository.CustomerRepository;

@Controller
public class CarController {
	private final CarRepository repository;
	private final CustomerRepository customerRepository;

	@Autowired
	public CarController(CarRepository repository, CustomerRepository customerRepository) {
		this.repository = repository;
		this.customerRepository = customerRepository;
	}

	@GetMapping("/cars")
	public String getAll(Model model) {
		model.addAttribute("cars", repository.findAll());
		return "car/get_all";
	}

	@PostMapping("/car/upsert")
	public String upsert(@Valid Car car, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("allCustomers", customerRepository.findAll());
			return "car/edit";
		}
		car = repository.save(car);
		return "redirect:/cars";

	}

	@GetMapping("/car/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		repository.deleteById(id);
		return "redirect:/cars";
	}

}
