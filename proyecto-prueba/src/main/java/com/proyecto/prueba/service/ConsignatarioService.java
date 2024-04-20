package com.proyecto.prueba.service;

import java.util.List;

import com.proyecto.prueba.entity.Consignatario;

public interface ConsignatarioService {

	public List<Consignatario> findAll();
	public Consignatario findById(long consignatarioid);
	public Consignatario save(Consignatario consignatario);
	public void delete(long consignatarioid);
}
