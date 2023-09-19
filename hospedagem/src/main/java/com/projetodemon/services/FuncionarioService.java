package com.projetodemon.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetodemon.entities.Funcionario;
import com.projetodemon.repository.FuncionarioRepository;

@Service

public class FuncionarioService {

	private final FuncionarioRepository funcionarioRepository;

	@Autowired

	public FuncionarioService(FuncionarioRepository funcionarioRepository) {

		this.funcionarioRepository = funcionarioRepository;

	}

	public List<Funcionario> buacaTodosFuncionarios() {

		return funcionarioRepository.findAll();

	}

	public Funcionario buscaFuncionarioPeloCodigo(Long codigo) {

		Optional<Funcionario> funcionario = funcionarioRepository.findById(codigo);

		return funcionario.orElse(null);

	}

	public Funcionario salvaFuncionario(Funcionario funcionario) {

		return funcionarioRepository.save(funcionario);

	}

	public Funcionario alterarFuncionario(Long codigo, Funcionario alterarFuncionario) {

		Optional<Funcionario> existeFuncionario = funcionarioRepository.findById(codigo);

		if (existeFuncionario.isPresent()) {

			alterarFuncionario.setCodigo(codigo);

			return funcionarioRepository.save(alterarFuncionario);

		}

		return null;

	}

	public boolean apagarFuncionario(Long codigo) {

		Optional<Funcionario> existeFuncionario = funcionarioRepository.findById(codigo);

		if (existeFuncionario.isPresent()) {

			funcionarioRepository.deleteById(codigo);

			return true;

		}

		return false;

	}

}
