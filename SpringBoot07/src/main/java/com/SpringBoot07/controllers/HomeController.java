package com.SpringBoot07.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
public class HomeController {

	@RequestMapping("/apiVersion/hacecafe")
	@ResponseStatus(HttpStatus.OK)
	public ObjectNode cafe() {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode objectNode = mapper.createObjectNode();
		objectNode.put("hacer", "cafe");
		return objectNode;
	}

	@RequestMapping("/apiVersion/hacete")
	@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
	public String te() {
		return "Soy una tetera!";
	}

	@RequestMapping("/apiVersion/notfound")
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String notFound() {
		return "Not found";
	}
}