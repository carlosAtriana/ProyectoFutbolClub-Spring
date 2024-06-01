package com.proyectofutbol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyectofutbol.repository.*;
import com.proyectofutbol.variable.*;


@Controller
public class JugadorController {
	
	@Autowired
	private JugadoresRepository jugadoresrespository;
	
	
	
	@GetMapping("/verJugadores")  
	public String listarJugadores(Model model) {
		List<Jugadores> listaJugadores = jugadoresrespository.findAll();
		model.addAttribute("listaJugadores", listaJugadores);
		
		return "verJugadores";
	}
	
	@GetMapping("formJugadores")
	public String mostrarFormulario (Model model) {
		model.addAttribute("jugadores", new Jugadores());
		
		List<Jugadores> listaJugadores = jugadoresrespository.findAll();
		model.addAttribute("listaJugadores", listaJugadores);
		
		return "formJugadores";
	}
	
	@PostMapping("/guardarJugadores")
	public String guardarJugadores (Jugadores jugadores) {
		jugadoresrespository.save(jugadores);
		return "redirect:/verJugadores";
	}
	
	@GetMapping("/Jugadores/editar/{id}")
	public String modificarJugador (@PathVariable("id") Integer id, Model model) {

		Jugadores jugadores = jugadoresrespository.findById(id).get();
		model.addAttribute("jugadores", jugadores);
		
		List<Jugadores> listaJugadores = jugadoresrespository.findAll();
		model.addAttribute("listaJugadores", listaJugadores);
		
		return "formJugadores";
	}
	
	@GetMapping("/Jugadores/eliminar/{id}")
	public String eliminarJugadores(@PathVariable("id") Integer id, Model model) {
		jugadoresrespository.deleteById(id);
		return "redirect:/verJugadores";
	}
	

}
