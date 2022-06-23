package com.SpringBoot05.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.SpringBoot05.pojos.TextToJSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Controller
public class HomeController {

	@ResponseBody
	@RequestMapping("/test1")
	public TextToJSON test() {
		return new TextToJSON("index.html");
	}
	
	@ResponseBody
	@RequestMapping(path="/test2", produces="application/json")
	public String test2() {
		return "{\"page\": \"index.html\"}";
	}
	
	@ResponseBody
	@RequestMapping("/test3")
	public ObjectNode index() {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode objectNode = mapper.createObjectNode();
		objectNode.put("page", "index.html");
		return objectNode;
	}
	
	@ResponseBody
	@RequestMapping("/test4")
	public ResponseEntity<String> getGreetingWithResponseEntity(){
		final HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<String>("{\"page\": \"index.html\"}",httpHeaders,HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping("/test5")
	public ResponseEntity<String> getGreetingWithResponseEntity2(){
		final HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<String>("{\"page\": \"index.html\"}",httpHeaders,HttpStatus.MULTIPLE_CHOICES);
	}
}