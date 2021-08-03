package com.mult3multbroker.teste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mult3multbroker.teste.model.Pessoa;
import com.mult3multbroker.teste.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoa")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PessoaController {
	
	@Autowired
	private PessoaRepository repository;
	
	//Get
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<Pessoa>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	//Post
	@PostMapping
	public ResponseEntity<Pessoa> postPessoa(@RequestBody Pessoa pessoa){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(pessoa));
	}
	
	//Put
	@PutMapping
	public ResponseEntity<Pessoa> putPessoa(@RequestBody Pessoa pessoa){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(pessoa));
	}
	
	//Delete
	@DeleteMapping("/{id}")
	public void deletePessoa(@PathVariable long id){
		repository.deleteById(id);
	}

}
