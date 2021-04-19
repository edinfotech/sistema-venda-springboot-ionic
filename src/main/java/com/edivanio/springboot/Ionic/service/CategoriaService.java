package com.edivanio.springboot.Ionic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edivanio.springboot.Ionic.domain.Categoria;
import com.edivanio.springboot.Ionic.exception.ObjectNotFoundException;
import com.edivanio.springboot.Ionic.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
	   Optional<Categoria>categoria = repo.findById(id);
	   return categoria.orElseThrow(() -> new ObjectNotFoundException(
			   "Categoria não encontrada! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public void salvar(List<Categoria> lista) {
		repo.saveAll(lista);
	}

}
