package com.proyecto.prueba.dao;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.prueba.entity.Cliente;


public interface ClienteDao extends CrudRepository<Cliente, Long>{

}
