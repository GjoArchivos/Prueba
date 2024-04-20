package com.proyecto.prueba.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.prueba.entity.Consignatario;
import com.proyecto.prueba.service.ConsignatarioService;

@CrossOrigin(origins= {"http://localhost:4200"} )
@RestController
@RequestMapping("/consignatarios")
public class ConsignatarioController {

	@Autowired
	private ConsignatarioService consignatarioService;
	
	@GetMapping("/consignatarios")
	public List<Consignatario> index(){
		return consignatarioService.findAll();
	}

	@GetMapping("/consignatario/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> show(@PathVariable Long id) {
		Consignatario unConsignatario = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			unConsignatario = consignatarioService.findById(id);
		} catch (DataAccessException e) {
			response.put("Error: ", "Error al realizar la consulta");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		if (unConsignatario == null) {
			response.put("Error: ", "Los datos del cliente no se encuntran");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Consignatario>(unConsignatario, HttpStatus.OK);
		
	}
	
	@PostMapping("consignatario")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@Validated @RequestBody Consignatario consignatario, BindingResult resultado) {
		@SuppressWarnings("unused")
		Consignatario nuevoConsignatario = null;
		Map<String, Object> response = new HashMap<>();
		
		if (resultado.hasErrors()) {
			List<String> miError = new ArrayList<>();
			for(FieldError err: resultado.getFieldErrors()) {
				miError.add("El campo: "+ "'" + err.getField()+ "'" + err.getDefaultMessage());
			}	
			response.put("errors: ", miError);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			nuevoConsignatario = consignatarioService.save(consignatario);
		} catch (Exception e) {
			response.put("Mensaje", "Error al Insertar nuevos datos");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.BAD_REQUEST);
		}
		response.put("Mensaje: ", "Nuevos datos ingresados con Exito!");
		response.put("Cliente: ", "Nuevo consignatario");
		//return new  ResponseEntity<Cliente>(nuevoConsignatario,HttpStatus.CREATED);
		return new  ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED); 
		
	}
	
	@PutMapping("/consignatario/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?>  update(@Validated @RequestBody Consignatario consignatario, BindingResult resultado, @PathVariable Long id) {
		Consignatario consignatarioActual = consignatarioService.findById(id);
		@SuppressWarnings("unused")
		Consignatario actualizaConsignatario = null;
		Map<String, Object> response = new HashMap<>();
		
		if (consignatarioActual == null) {
			response.put("Error: ", "No se puede actializar el Usuario. No existe en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		if (resultado.hasErrors()) {
			List<String> miError = new ArrayList<>();
			for(FieldError err: resultado.getFieldErrors()) {
				miError.add("El campo: "+ "'" + err.getField()+ "'" + err.getDefaultMessage());
			}	
			response.put("errors: ", miError);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			consignatarioActual.setConsignatarioactivo(consignatario.getConsignatarioactivo());
			consignatarioActual.setConsignatarionombre(consignatario.getConsignatarionombre());
			consignatarioActual.setConsignatariofechacreacion(consignatario.getConsignatariofechacreacion());
			consignatarioActual.setConsignatariofechamodificacion(consignatario.getConsignatariofechamodificacion());
			actualizaConsignatario = consignatarioService.save(consignatarioActual);
			
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al actualizar en la base de datos");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("Mensaje: ", "Nuevos datos ingresados con Exito!");
		response.put("Cliente: ", "Nuevo Cliente");
		//return new  ResponseEntity<Cliente>(nuevoConsignatario,HttpStatus.CREATED);
		return new  ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED); 
		
		
	}
	
	@DeleteMapping("/consignatario/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		
		try {
		consignatarioService.delete(id);
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al Eliminar en la base de datos");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("Mensaje: ", "Cliente eliminado con Exito!");
		return new  ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
}
