package com.innova.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.innova.entity.IngresoEstado;
import com.innova.entity.Persona;
import com.innova.service.IngresoService;
import com.innova.service.PersonaService;

@Controller
public class AjaxController {

	@GetMapping("/ajax")
	public String index() {
		return "ajax";
	}
	
	@RequestMapping(value="demo1", method= RequestMethod.GET)
	@ResponseBody
	public String demo1() {
		return "Demo 1";
	}
	
	@Autowired
	PersonaService personaService;
	
 
	
    @RequestMapping(value = "/get-all-employee", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public List<Persona> getAllEmployee(HttpServletRequest request) {
        List<Persona> response = new ArrayList<>();
        try {

            response = personaService.listPersonas(); // returns response object

        } catch (Exception e) {
           e.getStackTrace();
        }
        return response ; 
    }

	
	
	@GetMapping("/test2/{dni}")
	@ResponseBody
	public String demo2(@PathVariable("dni") BigDecimal dni) {
		
		System.out.println("DNI "+dni);
		
		Persona persona = personaService.getPersonaByNameOrDni(dni);
		
		return persona.getApellido();
		
	}
	
	@GetMapping("/json")
	@ResponseBody
	public String json() {
		
		List<Persona> personas = personaService.listPersonas();
		
		String gson = new Gson().toJson(personas);
		
		System.out.println("JSON : "+ gson);
		
		return gson;
	}
	
	@Autowired
	IngresoService ingresoService;
	
	@GetMapping("/jsonEstadoSearch")
	@ResponseBody
	public String jsonEstadoSearch() {
		
		List<IngresoEstado> ingresos = ingresoService.getIngresosSemaforo();
		
		String gson = new Gson().toJson(ingresos);
		
		System.out.println("JSON : "+ gson);
		
		return gson;
	}
	
	
	
}
