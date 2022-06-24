package com.SpringBoot23.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CUSTOMERS")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	Long id;
	@Column(name = "NAME")
	String name;
	@Column(name = "SURNAME")
	String surname;
	@Column(name = "BIRTHDATE")
	String birthdate;
	@Column(name = "PHONE")
	String phone;
	@Column(name = "COUNTRY")
	String country;
	@Column(name = "CITY")
	String city;
	@Column(name = "DIRECTION")
	String direction;
	@Column(name = "POSTCODE")
	String postcode;
}
