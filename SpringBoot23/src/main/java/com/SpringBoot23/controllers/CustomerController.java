package com.SpringBoot23.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot23.entities.Customer;
import com.SpringBoot23.services.CustomerService;

import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping(value = "/1.0.0")
public class CustomerController {
	@Autowired(required = false)
	CustomerService customerService;
	
	@GetMapping(value="/customers")
	public List<Customer> getCustomers(){
		log.info("Request a http://localhost:PORT/api/customers (GET)");
		return customerService.findAllCustomers();
	}
	
	@GetMapping(value="/customers/{id}")
	public Optional<Customer> getACustomer(@PathVariable(name = "id") Long id) {
		return customerService.findACustomer(id);
	}
	
	@RequestMapping(value="/customers/add", method = {RequestMethod.PUT, RequestMethod.POST})
	public void saveCustomer(Customer customer) {
		customerService.saveCustomer(customer);
	}
	
	@DeleteMapping(value="/customers/delete/{id}")
	public void deleteCustomer(@PathVariable(name = "id") Long id) {
		customerService.deleteCustomer(id);
	}
	
	@PatchMapping(value="/customers/update")
	public void updateCustomer(Customer customer) {
		customerService.saveCustomer(customer);
	}
}
