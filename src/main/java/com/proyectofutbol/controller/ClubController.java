package com.proyectofutbol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyectofutbol.variable.*;
import com.proyectofutbol.repository.*;

@Controller
public class ClubController {
	
	@Autowired
	private ClubRepository clubRepositorio;
	
	@Autowired
	private EntrenadorRepository entrenadorRepositorio;
	
	@Autowired
	private AsociacionRepository asociacionRepositorio;
	
	@Autowired
	private CompeticionesRepository competicionRepositorio;
	
	@GetMapping({"/verClub","/mostrarclub","/listarclub"})  
	public String listarClub(Model model) {
		List<Club> listaClub = clubRepositorio.findAll();
		model.addAttribute("listaClub", listaClub);
		
		return "verClub";
	}
	
	@GetMapping("/verClub/formClub")
	public String mostrarFormulario (Model model) {
		model.addAttribute("club", new Club());
		
		List<Entrenadores> listaEntrenador = entrenadorRepositorio.findAll();
		model.addAttribute("listaEntrenador", listaEntrenador);
		
		List<Asociaciones> listaAsociacion = asociacionRepositorio.findAll();
		model.addAttribute("listaAsociacion", listaAsociacion);
		
		List<Competiciones> listaCompeticion = competicionRepositorio.findAll();
		model.addAttribute("listaCompeticion", listaCompeticion);
		
		return "formClub";
	}
	
	@PostMapping("/guardarClub")
	public String guardarClub (Club club) {
		clubRepositorio.save(club);
		return "redirect:/verClub";
	}
	
	@GetMapping("/club/editar/{id}")
	public String modificarClub (@PathVariable("id") Integer id, Model model) {
		Club club = clubRepositorio.findById(id).get();
		model.addAttribute("club", club);
		
		List<Entrenadores> listaEntrenador = entrenadorRepositorio.findAll();
		model.addAttribute("listaEntrenador", listaEntrenador);
		
		List<Asociaciones> listaAsociacion = asociacionRepositorio.findAll();
		model.addAttribute("listaAsociacion", listaAsociacion);
		
		List<Competiciones> listaCompeticion = competicionRepositorio.findAll();
		model.addAttribute("listaCompeticion", listaCompeticion);
		
		return "formClub";
	}
	
	@GetMapping("/club/eliminar/{id}")
	public String eliminarClub(@PathVariable("id") Integer id, Model model) {
		clubRepositorio.deleteById(id);
		return "redirect:/verClub";
	}
	

	
}