package com.proyecto.prueba.service;

import java.util.List;

import com.proyecto.prueba.entity.Cliente;

public interface ClienteService {
	
	public List<Cliente> findAll();
	public Cliente findById(long clienteid);
	public Cliente save(Cliente Cliente);
	public void delete(Long clienteid);

}
