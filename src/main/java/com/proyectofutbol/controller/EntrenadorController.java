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
public class EntrenadorController {
	

	@Autowired
	private EntrenadorRepository entrenadorrespository;
	
	
	
	@GetMapping("/verEntrenador")  
	public String listarEntrenador(Model model) {
		List<Entrenadores> listaEntrenador = entrenadorrespository.findAll();
		model.addAttribute("listaEntrenador", listaEntrenador);
		
		return "verEntrenador";
	}
	
	@GetMapping("formEntrenador")
	public String mostrarFormulario (Model model) {
		model.addAttribute("entrenadores", new Entrenadores());
		
		List<Entrenadores> listaEntrenador = entrenadorrespository.findAll();
		model.addAttribute("listaEntrenador", listaEntrenador);
		
		return "formEntrenador";
	}
	
	@PostMapping("/guardarEntrenador")
	public String guardarEntrenador (Entrenadores entrenador) {
		entrenadorrespository.save(entrenador);
		return "redirect:/verEntrenador";
	}
	
	@GetMapping("/entrenador/editar/{id}")
	public String modificarEntrenador (@PathVariable("id") Integer id, Model model) {

		Entrenadores entrenadores = entrenadorrespository.findById(id).get();
		model.addAttribute("entrenadores", entrenadores);
		
		List<Entrenadores> listaEntrenador = entrenadorrespository.findAll();
		model.addAttribute("listaEntrenador", listaEntrenador);
		
		return "formEntrenador";
	}
	
	@GetMapping("/entrenador/eliminar/{id}")
	public String eliminarEntrenador(@PathVariable("id") Integer id, Model model) {
		entrenadorrespository.deleteById(id);
		return "redirect:/verEntrenador";
	}
	

}
