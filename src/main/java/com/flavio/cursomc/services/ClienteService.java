package com.flavio.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flavio.cursomc.domain.Cliente;
import com.flavio.cursomc.repositories.ClienteRepository;
import com.flavio.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService{
	
	@Autowired
	ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
}
