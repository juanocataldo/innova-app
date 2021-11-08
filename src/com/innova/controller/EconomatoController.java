package com.innova.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.innova.entity.Economato_Elementos;
import com.innova.service.EconomatoService;

@Controller
public class EconomatoController {

	@RequestMapping("/elementos")
	public String economato(Model model) {
		
		List<Economato_Elementos> listado = economatoService.listElementos(); 
		System.out.println("LISTADO CONTROLLER " + listado);
		model.addAttribute("listado",listado);
		
		return "economato";
	} 
	
	@Autowired
	EconomatoService economatoService;
	
	@GetMapping("/elementoSearch")
	public String elementoSearch(@RequestParam(name="elemNombre", required=false) String nombre,
								@RequestParam(name="elemEstado", required=false) int estado,
								@RequestParam(name="elemTipo", required=false) int tipo
								,Model model) {
		
		List<Economato_Elementos> listado = economatoService.listElementosByFilters(nombre, estado, tipo); 
		model.addAttribute("listado",listado);
		
		return "economato";
	}
	
	@RequestMapping("/nuevoElemento")
	public String nuevoElemento(Model model) {
		
		return "nuevoElemento";
	}
	
	@PostMapping("/addElemento")
	public String addElemento(@RequestParam(name="nombreElem") String nombre,
							@RequestParam(name="tipoElem") int tipo,
							Model model) {
		
		Economato_Elementos nuevoElemento = new Economato_Elementos();
		
		nuevoElemento.setNombre(nombre);
		nuevoElemento.setTipo(tipo);
		nuevoElemento.setEstado(1);
		
		economatoService.addElemento(nuevoElemento);
		
		return "redirect:/elementos";
	}
}
