package com.innova.controller;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
		 		 
		 return "home2";
	 } 
	 
	
	 @GetMapping("/search")
	 public String searchUsers(@RequestParam(value="id", required=false) Integer id, Model model) {

		//List<Ingreso> ingresos = ingresoService.getIngresosByName(personaSearch);
		
		 
		 
		List<Ingreso> ingresos = ingresoService.getIngresosById(id);
		
		model.addAttribute("ingresos",ingresos);
		
		return "search";		 
	 }
	 
	 @GetMapping("/searchFecha")
	 public String searchFecha(@RequestParam(value="fechaSearch", required=false) String fecha, Model model) {

		 try {
			final String OLD_FORMAT = "MM/dd/yyyy";
			final String NEW_FORMAT = "dd-MM-yyyy";

			 // August 12, 2010
			String oldDateString = fecha;
			String newDateString;

			SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
			Date d = sdf.parse(oldDateString);
			sdf.applyPattern(NEW_FORMAT);
			newDateString = sdf.format(d);
			 
			System.out.println("NEW DATE STRING : "+newDateString);
				
			 
			List<Ingreso> ingresos = ingresoService.getIngresosByFecha(newDateString);
			
			
			model.addAttribute("ingresos",ingresos);
		 }
		 catch(Exception exc){
			 exc.printStackTrace();
		 }
		 
		//List<Ingreso> ingresos = ingresoService.getIngresosByName(personaSearch);
		
		 
	
		
		return "search";		 
	 }
	 
	 @GetMapping("/estadoSearch")
	 public String estadoSearch(@RequestParam(value = "personaSearch", required=false) String personaSearch,
			 					@RequestParam(value = "dniSearch", required=false) BigDecimal dni,
			 					@RequestParam(value = "estadoSearch", required=false) Integer estado,
			 					 Model model) {

		 List<IngresoEstado> ingresos = ingresoService.getIngresosEstadosByFiltros(personaSearch, dni, estado);
		 model.addAttribute("listado",ingresos);
		 
		 return "estadoSearch";		 
	 }
	 
	 
	 
	 
	 
	 @GetMapping("/nuevoMovimiento")
	 public String nuevoMovmiento(@RequestParam(value="searchPerson", required=false) String busqueda, 
			 					@RequestParam(value = "dniSearch", required=false) BigDecimal dni,Model model) {	 
		 System.out.println("DNI DESDE EL CONTROLLER ES "+dni);
		 if(dni != null) {			
			 	List<Persona> personas = userService.listUsersByDni(dni);			 
				model.addAttribute("searchUsers",personas);
			}else {
				List<Persona> personas = userService.listUsersByName(busqueda);					
				model.addAttribute("searchUsers",personas);	
			}
		 
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
		 
		 System.out.println("PARAMETROS PARA CARGAR INGRESO");
		 System.out.println("ID: "+id);
		 System.out.println("DETALLE: "+detalle);
		 System.out.println("ITEM: "+item);
		 
		 ingreso.setUserId(persona.getId());
		 ingreso.setAudDel(null);
		 ingreso.setAudIns(null);
		 ingreso.setAudUpd(null);
		 ingreso.setDetalles(detalle);
		 		 
		 ingresoEstado.setPerId(persona.getId());
		 
		 Timestamp ts=new Timestamp(System.currentTimeMillis());
		 Timestamp ts2=new Timestamp(System.currentTimeMillis());
		 
		 if(item.equals("ingreso")) {			 
			 ingreso.setFechaIn(new Date(ts.getTime()));
			 ingreso.setFechaFin(null);
			 ingresoEstado.setEstado(1);			 
		 }
				 
		 if(item.equals("egreso")) {
			 Ingreso lastTime = ingresoService.getLastTimeIngreso(id);
			 ts = (Timestamp)lastTime.getFechaIn();
			 if(lastTime.getFechaIn()!=null) {				 
				 ingreso.setFechaIn(ts);				 
			 }else {
				 ingreso.setFechaIn(null);
			 }
			 
			 ingreso.setFechaFin(ts2);			 
			 ingresoEstado.setEstado(0);
		 } 
		 
		 ingreso.setUserIns(null);
		 ingreso.setUserUpd(null);		 
		 
		 
		 System.out.println("SE VA A GUARDAR ESTO -->" + ingreso);
		 
		 
		 userService.ingresoPersona(ingreso);
		 		 
		 userService.estadoIngreso(ingresoEstado);
		 
		 return "redirect:/estadoSearch";
	 }
	 
	 @GetMapping("/buscarMov")
	 public String buscarMov(@RequestParam(value="buscarMovi", required=false) String busqueda, Model model) {
		 		 
		 List<Ingreso> searchIngresos = ingresoService.getIngresosByName(busqueda);
		 
		 model.addAttribute("ingresosA",searchIngresos);
		 
		 return "redirect:/search";
	 }	 
}
