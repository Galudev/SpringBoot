package com.SpringBoot08.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Controller
public class IndexController {

	@RequestMapping("/hola")
	public String cafe() {
		return "hola.html";
	}
	
	@ResponseBody
	@RequestMapping("controller")
	public ObjectNode controller() {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode objectNode = mapper.createObjectNode();
		objectNode.put("saludo", "Hola");
		return objectNode;
	}
	
}