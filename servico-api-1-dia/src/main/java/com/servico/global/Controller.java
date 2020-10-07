package com.servico.global;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//Com o cross a classe aceita reposições de qualquer origem.

@RestController
@Api(value = "API SERVICOS")
@CrossOrigin("*")
public class Controller {

	@Autowired
	private ServicoRepository repository;

		@GetMapping("/servicos")
	public List<ServicoModel> pegarTodos() {
		return repository.findAll();
	}

	// findById() = busca por ID
	@GetMapping("/servicos/{id}")
	@ApiOperation("Selecione os serviços por ID")
	public ResponseEntity<ServicoModel> GetById(@PathVariable long id) {// quando for inserido um busca por ID ele pode
																		// trazer tanto
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)) // A RESPOSTA DO OBJETO, UM OKAY POR EXEMPLO
				.orElse(ResponseEntity.notFound().build()); // OU ERRO QUANDO UM OBJETO NÃO EXISTA OU AJA ALGUM ERRO

	}

	// findByName = busca por nome
	@GetMapping("/servicos/nome/{nome}")
	@ApiOperation("Selecione os serviços por nome")
	public List<ServicoModel> buscarPorNome(@PathVariable String nome) {
		return repository.findByNome(nome);
	}

	@PostMapping("/servicos")
	@ApiOperation("Insere um serviço")
	public ServicoModel criar(@RequestBody ServicoModel model) {
		repository.save(model);
		return model;
	}

	// PathVariable = pega a variavel
	// resquestBody = coloca o valor

	@PutMapping("/servicos/{id}")
	@ApiOperation("Altera um serviço")
	public ServicoModel atualizar(@PathVariable Long id, @RequestBody ServicoModel model) {
		model.setId(id);
		repository.save(model);
		return model;
	}

	/*
	 * @DeleteMapping("/{id}") public void deleteServico(@PathVariable long id) {
	 * repository.deleteById(id); }
	 */
	@DeleteMapping("/servicos/{id}")
	@ApiOperation("Deleta um serviço")
	public String remover(@PathVariable Long id) {
		repository.deleteById(id);
		return "sucesso";
	}

}
