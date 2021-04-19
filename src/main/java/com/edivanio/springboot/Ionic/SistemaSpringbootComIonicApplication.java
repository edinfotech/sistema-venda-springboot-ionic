package com.edivanio.springboot.Ionic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edivanio.springboot.Ionic.domain.Categoria;
import com.edivanio.springboot.Ionic.domain.Produto;
import com.edivanio.springboot.Ionic.service.CategoriaService;
import com.edivanio.springboot.Ionic.service.ProdutoService;

@SpringBootApplication
public class SistemaSpringbootComIonicApplication implements CommandLineRunner {

	@Autowired
	private CategoriaService categoriaService;
	@Autowired
	private ProdutoService produtoService;
	
	public static void main(String[] args) {
		SpringApplication.run(SistemaSpringbootComIonicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 =  new Categoria(null, "Informática");
		Categoria cat2 =  new Categoria(null, "Escritório");
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 50.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().add(p2);
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaService.salvar(Arrays.asList(cat1,cat2));
		produtoService.salvar(Arrays.asList(p1,p2,p3));
		
		
	}

}
