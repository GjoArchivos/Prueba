package com.proyecto.prueba.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.lang.NonNull;

@Entity
@Table(name="consignatario")
public class Consignatario implements Serializable{

	private static final long serialVersionUID = 1L;
	@NonNull
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "clienteid")
	private Cliente clienteid;
	@NonNull
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="consignatarioid")
	private Long consignatarioid;
	@NonNull
	@Column(name="consignatarioactivo")
	private Boolean consignatarioactivo;
	@NonNull
	@Column(name="consignatarionombre")
	private String consignatarionombre;
	@NonNull
	@Column(name="consignatariofechacreacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date consignatariofechacreacion;
	@NonNull
	@Column(name="consignatariofechamodificacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date consignatariofechamodificacion;
	
	@PrePersist
	public void prePersist() {
		consignatariofechacreacion = new Date();
		consignatariofechamodificacion = new Date();
	}
	
	public Consignatario() {
	}
	
	public Consignatario(Cliente clienteid, Long consignatarioid, Boolean consignatarioactivo, String consignatarionombre,
			Date consignatariofechacreacion, Date consignatariofechamodificacion) {
		this.clienteid = clienteid;
		this.consignatarioid = consignatarioid;
		this.consignatarioactivo = consignatarioactivo;
		this.consignatarionombre = consignatarionombre;
		this.consignatariofechacreacion = consignatariofechacreacion;
		this.consignatariofechamodificacion = consignatariofechamodificacion;
	}
	public Cliente getClienteid() {
		return clienteid;
	}
	public void setClienteid(Cliente clienteid) {
		this.clienteid = clienteid;
	}
	public Long getConsignatarioid() {
		return consignatarioid;
	}
	public void setConsignatarioid(Long consignatarioid) {
		this.consignatarioid = consignatarioid;
	}
	public Boolean getConsignatarioactivo() {
		return consignatarioactivo;
	}
	public void setConsignatarioactivo(Boolean consignatarioactivo) {
		this.consignatarioactivo = consignatarioactivo;
	}
	public String getConsignatarionombre() {
		return consignatarionombre;
	}
	public void setConsignatarionombre(String consignatarionombre) {
		this.consignatarionombre = consignatarionombre;
	}
	public Date getConsignatariofechacreacion() {
		return consignatariofechacreacion;
	}
	public void setConsignatariofechacreacion(Date consignatariofechacreacion) {
		this.consignatariofechacreacion = consignatariofechacreacion;
	}
	public Date getConsignatariofechamodificacion() {
		return consignatariofechamodificacion;
	}
	public void setConsignatariofechamodificacion(Date consignatariofechamodificacion) {
		this.consignatariofechamodificacion = consignatariofechamodificacion;
	}
	
	
	
	
}
