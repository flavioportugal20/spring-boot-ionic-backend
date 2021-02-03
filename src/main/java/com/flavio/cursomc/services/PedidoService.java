package com.flavio.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flavio.cursomc.domain.Pedido;
import com.flavio.cursomc.repositories.PedidoRepository;
import com.flavio.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService{
	
	@Autowired
	PedidoRepository repo;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
}
