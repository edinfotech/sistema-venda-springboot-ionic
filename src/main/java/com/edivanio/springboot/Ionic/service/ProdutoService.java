package com.edivanio.springboot.Ionic.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edivanio.springboot.Ionic.domain.Categoria;
import com.edivanio.springboot.Ionic.domain.Produto;
import com.edivanio.springboot.Ionic.repository.CategoriaRepository;
import com.edivanio.springboot.Ionic.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repo;
	
	public Produto buscar(Integer id) {
	   Optional<Produto>produto = repo.findById(id);
	   return produto.orElseThrow(() -> new ObjectNotFoundException(
			   "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName(), null));
	}
	
	public void salvar(List<Produto> lista) {
		repo.saveAll(lista);
	}

}
