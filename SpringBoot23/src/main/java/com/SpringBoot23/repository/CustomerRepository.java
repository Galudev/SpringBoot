package com.SpringBoot23.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBoot23.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {}
