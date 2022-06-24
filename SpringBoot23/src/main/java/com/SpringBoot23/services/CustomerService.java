package com.SpringBoot23.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot23.entities.Customer;
import com.SpringBoot23.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	
	public List<Customer> findAllCustomers(){
		return customerRepository.findAll();
	}
	
	public Optional<Customer> findACustomer(Long id) {
		return customerRepository.findById(id);
	}
	
	public void saveCustomer(Customer customer) {
		customerRepository.save(customer);
	}
	
	public void deleteCustomer(Long id) {
		customerRepository.deleteById(id);
	}
	
}
