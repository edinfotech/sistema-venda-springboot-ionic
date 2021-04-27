package com.edivanio.springboot.Ionic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edivanio.springboot.Ionic.domain.Categoria;
import com.edivanio.springboot.Ionic.domain.Cliente;
import com.edivanio.springboot.Ionic.exception.ObjectNotFoundException;
import com.edivanio.springboot.Ionic.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
	   Optional<Cliente>Cliente = repo.findById(id);
	   return Cliente.orElseThrow(() -> new ObjectNotFoundException(
			   "CLiente não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
	
	public void salvar(List<Cliente> lista) {
		repo.saveAll(lista);
	}

}
