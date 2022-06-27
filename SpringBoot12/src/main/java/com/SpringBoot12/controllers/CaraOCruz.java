package com.SpringBoot12.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CaraOCruz {

	@GetMapping("/caraocruz")
	@ResponseBody
	public String caraOCruz(@RequestParam String moneda) {
		String cae = (Math.round(Math.random()))==0 ? "cara" : "cruz";
		if((moneda.equals("cara"))||(moneda.equals("cruz"))) {
			return cae.equals(moneda) ? "Has ganado" : "Has perdido";
		}
		return "No válido";
	}
}
