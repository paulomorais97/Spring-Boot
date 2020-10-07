package com.atividade1.lista.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/minhaPrimeiraAplicacao")
public class MinhaPrimeiraAplicacao {

	@GetMapping
	public String minhaPrimeiraAplicacao() {
		return "Persistencia e Atenção aos Detalhes";
	}
//	@GetMapping("/get2")
//	public String controller() {
//		return "Persistencia e Atenção aos Detalhes e blablabla";
//	}
}
