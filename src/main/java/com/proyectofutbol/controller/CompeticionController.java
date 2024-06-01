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
public class CompeticionController {
	

	@Autowired
	private CompeticionesRepository competicionesrespository;
	
	
	
	@GetMapping("/verCompeticiones")
	public String listarCompeticiones(Model model) {
		List<Competiciones> listaCompeticiones = competicionesrespository.findAll();
		model.addAttribute("listaCompeticiones", listaCompeticiones);
		
		return "verCompeticiones";
	}
	
	@GetMapping("formCompeticiones")
	public String mostrarFormulario (Model model) {
		model.addAttribute("competiciones", new Competiciones());
		
		List<Competiciones> listaCompeticiones = competicionesrespository.findAll();
		model.addAttribute("listaCompeticiones", listaCompeticiones);
		
		return "formCompeticiones";
	}
	
	@PostMapping("/guardarCompeticiones")
	public String guardarAsociaciones (Competiciones competiciones) {
		competicionesrespository.save(competiciones);
		return "redirect:/verCompeticiones";
	}
	
	@GetMapping("/competiciones/editar/{id}")
	public String modificarAsociaciones (@PathVariable("id") Integer id, Model model) {

		Competiciones competiciones = competicionesrespository.findById(id).get();
		model.addAttribute("competiciones", competiciones);
		
		List<Competiciones> listaCompeticiones = competicionesrespository.findAll();
		model.addAttribute("listaCompeticiones", listaCompeticiones);
		
		return "formCompeticiones";
	}
	
	@GetMapping("/competiciones/eliminar/{id}")
	public String eliminarCompeticion(@PathVariable("id") Integer id, Model model) {
		competicionesrespository.deleteById(id);
		return "redirect:/verCompeticiones";
	}
	

}
