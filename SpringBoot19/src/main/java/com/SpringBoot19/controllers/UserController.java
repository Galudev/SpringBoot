package com.SpringBoot19.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot19.entities.User;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(value = "/api")
public class UserController {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		final String QUERRY1 = "SELECT * FROM users;";

		List<Map<String, Object>> results = jdbcTemplate.queryForList(QUERRY1);

		List<User> userList = new ArrayList<User>();

		for (Map<String, Object> item : results) {
			userList.add(mapUserResult(item));
		}

		return userList;
	}

	private User mapUserResult(final Map<String, Object> result) {
		User user = new User();
		user.setId(((Integer) result.get("ID")).longValue());
		user.setName((String) result.get("name"));
		user.setSurname((String) result.get("surname"));
		return user;
	}

	@ApiResponses(value = { @ApiResponse(responseCode = "404", description = "Not found - The product was not found") })
	@RequestMapping(value = "/users/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<User> getById(@PathVariable Long id) {
		final String QUERY = "SELECT * FROM users WHERE id=?;";
		List<User> us = jdbcTemplate.query(QUERY, new BeanPropertyRowMapper<User>(User.class), id);
		if (us.isEmpty())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<User>(us.get(0), HttpStatus.OK);
	}

	@PutMapping("/users/add")
	public ResponseEntity<Void> createUser(@RequestParam(required = true) String name, String surname) {

		final String VALUES = "(\"" + name + "\",\"" + surname + "\");";
		final String sql = "INSERT INTO users(name, surname) VALUES " + VALUES;
		int i = jdbcTemplate.update(sql);
		if (i != 0) {
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}

	@PatchMapping("/users/update/{id}")
	public ResponseEntity<Void> updateUser(@PathVariable Long id, @RequestParam(required = true) String name, String surname) {
		final String VALUES = "name = \"" + name + "\", surname = \"" + surname + "\" WHERE id = " + id + ";";
		final String sql = "UPDATE users SET " + VALUES;
		int i = jdbcTemplate.update(sql);
		if (i != 0) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/users/delete/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id){
		final String sql = "DELETE FROM users WHERE id = " + id + ";";
		int i = jdbcTemplate.update(sql);
		if (i != 0) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}