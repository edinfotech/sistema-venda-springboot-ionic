package com.edivanio.springboot.Ionic.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edivanio.springboot.Ionic.domain.Produto;
import com.edivanio.springboot.Ionic.service.ProdutoService;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoResources {
	
	@Autowired
	private ProdutoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id){
		Produto obj  = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}
