package com.edivanio.springboot.Ionic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edivanio.springboot.Ionic.domain.Pedido;
import com.edivanio.springboot.Ionic.exception.ObjectNotFoundException;
import com.edivanio.springboot.Ionic.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
	   Optional<Pedido> pedidos = repo.findById(id);
	   return pedidos.orElseThrow(() -> new ObjectNotFoundException(
			   "Categoria não encontrada! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
	
	public void salvar(List<Pedido> lista) {
		repo.saveAll(lista);
	}

}
