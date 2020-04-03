package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Funcionarios;

public interface FuncionarioRepository extends JpaRepository<Funcionarios, Integer> {

}
