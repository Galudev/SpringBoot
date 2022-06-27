package com.SpringBoot14.controllers;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot14.Persona;

import ch.qos.logback.classic.Logger;

@RestController
public class HomeController {

	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(HomeController.class);

	@GetMapping("/persona")
	public String getPersona() {
		Persona persona = new Persona("Lucía","Gálvez",26);
		LOGGER.info(persona.toString());
		return persona.toString();
	}
	
	@PostMapping("/persona")
	public void postPersona(Persona persona) {
		LOGGER.info("Creando persona");
		System.out.println(persona.toString());
	}
	
	@DeleteMapping("/persona/{id}")
	public void deletePersona(@PathVariable(name = "id") int id) {
		LOGGER.info("Borrando");
		System.out.println("El objeto se ha eliminado correctamente");
	}
	
	@PutMapping("/persona")
	public void deletePersona(Persona persona) {
		LOGGER.info("Put");
		System.out.println("El objeto se ha introducido correctamente junto a los atributos del objeto");
	}
}
