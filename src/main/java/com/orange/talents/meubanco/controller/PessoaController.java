package com.orange.talents.meubanco.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orange.talents.meubanco.config.GeneralResponse;
import com.orange.talents.meubanco.dto.PessoaDTO;
import com.orange.talents.meubanco.service.PessoaService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/pessoa")
@CrossOrigin(origins="*")
public class PessoaController {

	@Autowired
	PessoaService service;

	@PostMapping
	@ApiOperation(value = "Salva uma nova entidade de pessoa no banco de dados.")
	public ResponseEntity<GeneralResponse<Boolean>> salvarPessoa(@Valid @RequestBody PessoaDTO entidade) {
		GeneralResponse<Boolean> response = new GeneralResponse<>();
		response.setData(service.salvarNovaPessoa(entidade));
		
		response.setStatusCode(HttpStatus.CREATED.value());		
		response.setTimestamp(System.currentTimeMillis());		
		response.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PessoaController.class).salvarPessoa(entidade)).withSelfRel());
		response.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PessoaController.class).retornaPessoas()).withRel("GET_ALL"));
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping
	@ApiOperation(value = "Lista todas as pessoas no banco de dados.")
	public ResponseEntity<GeneralResponse<List<PessoaDTO>>> retornaPessoas() {
		GeneralResponse<List<PessoaDTO>> response = new GeneralResponse<>();
		response.setData(service.listarTodasPessoas());
		response.setStatusCode(HttpStatus.OK.value());
		response.setTimestamp(System.currentTimeMillis());
		response.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PessoaController.class).retornaPessoas())
				.withSelfRel());		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
