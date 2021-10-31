package com.innova.controller;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.innova.entity.Ingreso;
import com.innova.entity.IngresoEstado;
import com.innova.entity.Persona;

import com.innova.service.IngresoService;
import com.innova.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	IngresoService ingresoService;
	
	 @RequestMapping("/")
	 public String home(Model model) {
		 
		 
		 return "home";
	 }
	
	 @GetMapping("/search")
	 public String searchUsers(@RequestParam(value = "personaSearch", required=false) String personaSearch, 
			 					@RequestParam(value="diaSearch", required=false) String dia, Model model) {
		 
		 		 
		List<Ingreso> ingresos = ingresoService.getIngresosByName(personaSearch);
		 
		model.addAttribute("ingresos",ingresos);
		 return "search";		 
	 }
	 
	 @GetMapping("/estadoSearch")
	 public String estadoSearch(@RequestParam(value = "personaSearch", required=false) String personaSearch, 
			 					 Model model) {
		 
		 		 
		List<IngresoEstado> ingresos = ingresoService.getIngresosEstadosByName(personaSearch);
		 
		model.addAttribute("listado",ingresos);
		 return "estadoSearch";		 
	 }
	 
	 
	 
	 
	 
	 @GetMapping("/nuevoMovimiento")
	 public String nuevoMovmiento(@RequestParam(value="searchPerson", required=false) String busqueda, Model model) {	 
		 
		 List<Persona> personas = userService.listUsersByName(busqueda);
		 
		 model.addAttribute("searchUsers",personas);
		 
		 return "nuevoMovimiento";
	 }
	 
	 @RequestMapping("/addPerson")
	 public String actividadPersona(@RequestParam(value="id", required=false) int id, Model model) {
		 
		 Persona userSelected = userService.getPersonaById(id);
		 
		 Ingreso ingreso = ingresoService.getLastIngreso(userSelected.getId());
		 
		 model.addAttribute("userSelected",userSelected);
		 
		 model.addAttribute("ingresoPersona",ingreso);
		 
		 return "entradaSalida";
	 }
	 
		 
	 @RequestMapping("/guardarMovimiento")
	 public String guardarMovimiento(@RequestParam(value="id", required=false) Integer id,
			 						@RequestParam("detalle") String detalle,
			 						@RequestParam("item") String item, Model model) {

		
		 Ingreso ingreso = new Ingreso();
		 
		 Persona persona = userService.getPersonaById(id);
		 
		 IngresoEstado ingresoEstado = new IngresoEstado();
		  
		 //User user = userService.getUserById(id);
		 //System.out.println("EL ID QUE PASOOOOOOOOOOO "+user.getId());
		 ingreso.setUserId(persona.getId());
		 ingreso.setAudDel(null);
		 ingreso.setAudIns(null);
		 ingreso.setAudUpd(null);
		 ingreso.setDetalles(detalle);
		 
		 
		 ingresoEstado.setPerId(persona.getId());
		 
		 Timestamp ts=new Timestamp(System.currentTimeMillis());  
		 
		 if(item.equals("ingreso")) {
			 ingreso.setFechaIn(new Date(ts.getTime()));
			 ingreso.setFechaFin(null);
			 ingresoEstado.setEstado(1);			  
		 }			
		 if(item.equals("egreso")) {
			 Ingreso lastTime = ingresoService.getLastTimeIngreso(id);
			 Timestamp ts2=(Timestamp)lastTime.getFechaIn();  
			 ingreso.setFechaIn(new Date(ts2.getTime()));
			 ingreso.setFechaFin(new Date(ts.getTime()));
			 ingresoEstado.setEstado(0);
		 } 
		 
		 ingreso.setUserIns(null);
		 ingreso.setUserUpd(null);		 
		 
		 userService.ingresoPersona(ingreso);
		 
		 userService.estadoIngreso(ingresoEstado);
		 
		 return "redirect:/search";
	 }
	 
	 @GetMapping("/buscarMov")
	 public String buscarMov(@RequestParam(value="buscarMovi", required=false) String busqueda, Model model) {
		 		 
		 List<Ingreso> searchIngresos = ingresoService.getIngresosByName(busqueda);
		 
		 model.addAttribute("ingresosA",searchIngresos);
		 
		 return "redirect:/search";
	 }
}
