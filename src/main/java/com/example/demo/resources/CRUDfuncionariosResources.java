package com.example.demo.resources;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Funcionarios;
import com.example.demo.repository.FuncionarioRepository;

@RestController
@RequestMapping("/funcionarios")
public class CRUDfuncionariosResources {
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	@GetMapping
	public ResponseEntity <?> selecionarFuncionarios(){
		List<Funcionarios> funcionarios = funcionarioRepository.findAll();
		if(funcionarios.isEmpty()) {
			
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Não há funcionários cadastrados");
			
		}else {
			
			return ResponseEntity.ok(funcionarioRepository.findAll());
			
		}
		
	}
	
	@GetMapping("/{cpf}")
	public ResponseEntity <Funcionarios> selecionarFuncionarios(@PathVariable int cpf){
		
		Optional<Funcionarios> funcionarios = funcionarioRepository.findById(cpf);
		
		if(funcionarios.isPresent()) {
			return ResponseEntity.ok(funcionarios.get());
		}else {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Não existe um funcionário com esse cpf");
		}
		
	}
	
	@PostMapping
	public ResponseEntity <Funcionarios> cadastrarFuncionario(@Valid @RequestBody Funcionarios funcionarios){
		
		Funcionarios funcionariosParaCadastrar = funcionarioRepository.save(funcionarios);
		return ResponseEntity.status(HttpStatus.CREATED).body(funcionariosParaCadastrar);
	}
	
	@PutMapping("/{cpf}")
	public ResponseEntity<Funcionarios> alterarFuncionario(@PathVariable Integer cpf, @Valid @RequestBody Funcionarios funcionarios) {
		Optional<Funcionarios> funcionarioExistente = funcionarioRepository.findById(cpf);
		if(funcionarioExistente.isPresent()) {
			return ResponseEntity.ok(funcionarioExistente.get());
		} else {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Esse funcionário não existe");
		}
	}
	@DeleteMapping("/{cpf}")
	public ResponseEntity<String> excluirFuncionario(@PathVariable Integer cpf) {
		Optional<Funcionarios> funcionarioExistente = funcionarioRepository.findById(cpf);
		if(funcionarioExistente.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body("O funcionario "+ funcionarioExistente.get().getNome() +" foi excluido");
		} else {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Funcionarios não identificado");
		}
	}
	

}
