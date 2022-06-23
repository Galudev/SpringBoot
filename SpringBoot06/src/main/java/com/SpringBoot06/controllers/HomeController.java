package com.SpringBoot06.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Controller
public class HomeController {
	
	@ResponseBody
	@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
	@RequestMapping(path = "/test1", produces = "application/json")
	public String test2() {
		return "{\"page\": \"index.html\"}";
	}

	@ResponseBody
	@RequestMapping("/test2")
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ObjectNode index() {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode objectNode = mapper.createObjectNode();
		objectNode.put("page", "index.html");
		return objectNode;
	}
}