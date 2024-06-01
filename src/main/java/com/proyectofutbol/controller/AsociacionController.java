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
public class AsociacionController {
	

	@Autowired
	private AsociacionRepository asociacionRepositorio;
	
	
	
	@GetMapping("/verAsociaciones")  
	public String listarAsociaciones(Model model) {
		List<Asociaciones> listaAsociaciones = asociacionRepositorio.findAll();
		model.addAttribute("listaAsociaciones", listaAsociaciones);
		
		return "verAsociaciones";
	}
	
	@GetMapping("formAsociaciones")
	public String mostrarFormulario (Model model) {
		model.addAttribute("asociaciones", new Asociaciones());
		
		List<Asociaciones> listaAsociacion = asociacionRepositorio.findAll();
		model.addAttribute("listaAsociacion", listaAsociacion);
		
		return "formAsociacion";
	}
	
	@PostMapping("/guardarAsociaciones")
	public String guardarAsociaciones (Asociaciones asociaciones) {
		asociacionRepositorio.save(asociaciones);
		return "redirect:/verAsociaciones";
	}
	
	@GetMapping("/asociaciones/editar/{id}")
	public String modificarAsociaciones (@PathVariable("id") Integer id, Model model) {
		Asociaciones asociaciones = asociacionRepositorio.findById(id).get();
		model.addAttribute("asociaciones", asociaciones);
		
		List<Asociaciones> listaAsociacion = asociacionRepositorio.findAll();
		model.addAttribute("listaAsociacion", listaAsociacion);
		
		return "formAsociacion";
	}
	
	@GetMapping("/asociaciones/eliminar/{id}")
	public String eliminarAsociacion(@PathVariable("id") Integer id, Model model) {
		asociacionRepositorio.deleteById(id);
		return "redirect:/verAsociaciones";
	}
	
	

}
