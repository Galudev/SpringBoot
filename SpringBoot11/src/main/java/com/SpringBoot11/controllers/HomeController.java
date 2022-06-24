package com.SpringBoot11.controllers;

import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/api")
public class HomeController {
	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(HomeController.class);

	@GetMapping("/test")
	@ResponseBody
	public String inf(@RequestParam Map<String,String> allParams) {
		if (allParams.isEmpty()) {
			return "La zona de parámetro está vacía ¡No has enviado nada!";
		}
		
		for(String key : allParams.keySet()) {
			LOGGER.info(key + ": " + allParams.get(key));
		}
		
		return "Parámetros: " + allParams.entrySet();
	}
}