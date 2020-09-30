package com.atividade1.lista.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("segundaAplicacao")
public class MinhaSegundaAplicacao {

	@GetMapping
	public String segundaAplicacao() {
	 return "Aprender Spring Boot";	
	}
	
}
