package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;


@Entity
public class Funcionarios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cpf;
	
	@NotEmpty
	private String nome;
	
	@NotEmpty
	private String areaAtuante;
	
	@NotEmpty
	private Integer idade;

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAreaAtuante() {
		return areaAtuante;
	}

	public void setAreaAtuante(String areaAtuante) {
		this.areaAtuante = areaAtuante;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	
}
