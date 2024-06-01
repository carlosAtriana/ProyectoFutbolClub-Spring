package com.proyectofutbol.variable;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity

@Table(name="asociaciones")
public class Asociaciones {
	
	@Id
	@Column(name="id")
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int Id;
	
	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String pais;
	
	@NotEmpty
	private String presidente;
	
	@NotEmpty
	private String siglas;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getPresidente() {
		return presidente;
	}

	public void setPresidente(String presidente) {
		this.presidente = presidente;
	}

	public String getSiglas() {
		return siglas;
	}

	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}

	
	
	

}
