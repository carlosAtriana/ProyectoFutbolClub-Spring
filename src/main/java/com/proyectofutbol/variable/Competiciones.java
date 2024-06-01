package com.proyectofutbol.variable;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity

@Table(name="competiciones")

public class Competiciones {

	@Id
	@Column(name="id")
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int Id;
	
	@NotEmpty
	private String fecha_inicio;
	
	@NotEmpty
	private String fecha_fin;
	
	@NotNull
	private float monto_premio;
	
	@NotEmpty
	private String nombre;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public String getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public float getMonto_premio() {
		return monto_premio;
	}

	public void setMonto_premio(float monto_premio) {
		this.monto_premio = monto_premio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
	
}
