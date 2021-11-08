package com.innova.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.innova.entity.Economato_Elementos;
import com.innova.service.EconomatoService;

@Controller
public class EconomatoController {

	@RequestMapping("/economato")
	public String economato(Model model) {
		
		List<Economato_Elementos> listado = economatoService.listElementos(); 
		System.out.println("LISTADO CONTROLLER " + listado);
		model.addAttribute("listado",listado);
		
		return "economato";
	} 
	
	@Autowired
	EconomatoService economatoService;
	
	@GetMapping("/economatoSearch")
	public String search(Model model) {
		
		List<Economato_Elementos> listado = economatoService.listElementos(); 
		System.out.println("LISTADO CONTROLLER " + listado);
		model.addAttribute("listado",listado);
		
		return "economato";
	}
}
