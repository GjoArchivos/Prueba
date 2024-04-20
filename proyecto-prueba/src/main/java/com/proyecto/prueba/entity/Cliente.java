package com.proyecto.prueba.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
//import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.lang.NonNull;



@Entity
@Table(name="cliente")
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@NonNull
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="clienteid")
	private Long clienteid;
	@NonNull
	@Column(name="clienteactivo")
	private Boolean clienteactivo;
	@NonNull
	@Column(name="clientenombre")
	private String clientenombre;
	@NonNull
	@Column(name="clientefechacreacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date clientefechacreacion;
	@NonNull
	@Column(name="clientefechamodificacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date clientefechamodificacion;
	
	@PrePersist
	public void prePersist() {
		clientefechacreacion = new Date();
		clientefechamodificacion = new Date();
	}
	//@OneToOne(mappedBy = "clienteid", fetch = FetchType.LAZY)
	//private Consignatario consignatario;

	public Cliente() {
	}

	//public Consignatario getConsignatario() {
	//	return consignatario;
	//}

	//public void setConsignatario(Consignatario consignatario) {
	//	this.consignatario = consignatario;
	//}

	public Cliente(Long clienteid, Boolean clienteactivo, String clientenombre, Date clientefechacreacion,
			Date clientefechamodificacion) {
		this.clienteid = clienteid;
		this.clienteactivo = clienteactivo;
		this.clientenombre = clientenombre;
		this.clientefechacreacion = clientefechacreacion;
		this.clientefechamodificacion = clientefechamodificacion;
	}

	public Long getClienteid() {
		return clienteid;
	}

	public void setClienteid(Long clienteid) {
		this.clienteid = clienteid;
	}

	public Boolean getClienteactivo() {
		return clienteactivo;
	}

	public void setClienteactivo(Boolean clienteactivo) {
		this.clienteactivo = clienteactivo;
	}

	public String getClientenombre() {
		return clientenombre;
	}

	public void setClientenombre(String clientenombre) {
		this.clientenombre = clientenombre;
	}

	public Date getClientefechacreacion() {
		return clientefechacreacion;
	}

	public void setClientefechacreacion(Date clientefechacreacion) {
		this.clientefechacreacion = clientefechacreacion;
	}

	public Date getClientefechamodificacion() {
		return clientefechamodificacion;
	}

	public void setClientefechamodificacion(Date clientefechamodificacion) {
		this.clientefechamodificacion = clientefechamodificacion;
	}
	
	
	
}
	