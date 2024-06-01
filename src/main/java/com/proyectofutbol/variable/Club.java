package com.proyectofutbol.variable;

import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity

@Table(name="club")

public class Club {

	@Id
	@Column(name="id")
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int Id;
	
	@NotEmpty
	private String nombre;
	
	//Relación entre club y entrenadores
	@OneToOne
	private Entrenadores entrenadores;
	
	//Relacion entre club y jugadores
	@OneToMany
	@JoinColumn(name = "id_club")
	private List<Jugadores> jugadores;
	
	//Relacion entre club y asociaciones
	@ManyToOne
	private Asociaciones asociaciones;

	//Relacion entre club y competiciones
	@ManyToMany
	private List<Competiciones> competiciones;

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

	public Entrenadores getEntrenadores() {
		return entrenadores;
	}

	public void setEntrenadores(Entrenadores entrenadores) {
		this.entrenadores = entrenadores;
	}

	public List<Jugadores> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugadores> jugadores) {
		this.jugadores = jugadores;
	}

	public Asociaciones getAsociaciones() {
		return asociaciones;
	}

	public void setAsociaciones(Asociaciones asociaciones) {
		this.asociaciones = asociaciones;
	}

	public List<Competiciones> getCompeticiones() {
		return competiciones;
	}

	public void setCompeticiones(List<Competiciones> competiciones) {
		this.competiciones = competiciones;
	}
	

	
	
	
	
	
	
}