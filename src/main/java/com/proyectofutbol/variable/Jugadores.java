package com.proyectofutbol.variable;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity

@Table(name="jugadores")
public class Jugadores {
	
	@Id
	@Column(name="id")
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int Id;
	
	@NotEmpty
	private String apellido;
	
	@NotEmpty
	private String nombre;
	
	@NotNull
	private int numero;
	
	@NotEmpty
	private String posicion;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}


	

}
