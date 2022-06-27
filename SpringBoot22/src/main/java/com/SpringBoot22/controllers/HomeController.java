package com.SpringBoot22.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.java.Log;

@Log
@RestController
public class HomeController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	@GetMapping("/users")
	public ResponseEntity<List<String>> getAllUsers() {
		final String QUERRY1 = "SELECT * FROM db_test.usuarios;";
		
		List<Map<String, Object>> results = jdbcTemplate.queryForList(QUERRY1);
		
		List<String> userList = new ArrayList<String>();
		
		for (Map<String, Object> item : results) {
			userList.add(item.toString());
		}
		
		return new ResponseEntity<>(userList, HttpStatus.OK);
	}
	
	
	@PostMapping("/user")
	public ResponseEntity<String> createUser(@RequestParam(required=true) String nombre, String edad, String nacionalidad) {
		
		final String VALUES = "(\"" + nombre + "\",\"" + edad + "\",\"" + nacionalidad + "\");";
		final String QUERRY = "INSERT INTO db_test.usuarios(nombre, edad, nacionalidad) VALUES " + VALUES;
		final int i = jdbcTemplate.update(QUERRY);
		if(i!=0) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
	}
	
}
