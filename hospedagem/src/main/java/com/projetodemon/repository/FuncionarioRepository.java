package com.projetodemon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetodemon.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
