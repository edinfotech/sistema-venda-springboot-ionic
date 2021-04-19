package com.edivanio.springboot.Ionic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edivanio.springboot.Ionic.domain.Categoria;
import com.edivanio.springboot.Ionic.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
