
package com.proyecto.prueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.prueba.dao.ConsignatarioDao;
import com.proyecto.prueba.entity.Consignatario;

@Service
public class ConsignatarioServiceImpl implements ConsignatarioService {

	@Autowired
	private ConsignatarioDao consignatarioDao;

	@Override
	@Transactional(readOnly = true)
	public List<Consignatario> findAll() {
		return (List<Consignatario>) consignatarioDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Consignatario findById(long consignatarioid) {
		return consignatarioDao.findById(consignatarioid).orElse(null);
	}

	@Override
	@Transactional
	public Consignatario save(Consignatario consignatario) {
		return consignatarioDao.save(consignatario);
	}

	@Override
	@Transactional
	public void delete(long consignatarioid) {
		consignatarioDao.deleteById(consignatarioid);
	}
}
