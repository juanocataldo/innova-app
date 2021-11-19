package com.innova.controller;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.innova.entity.EcoBienesUso;
import com.innova.entity.Economato_Elementos;
import com.innova.entity.Ingreso;
import com.innova.entity.IngresoEstado;
import com.innova.entity.Persona;
import com.innova.service.EconomatoService;
import com.innova.service.IngresoService;
import com.innova.service.PersonaService;
import com.innova.service.UserService;

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
		
		return persona.getApellido()+", "+persona.getNombre();
		
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
	
	
	@GetMapping("/jsonEstadoSearch3")
	@ResponseBody
	public String jsonEstadoSearch3(@RequestParam(name="id", required=false) int id) {
		
		Persona persona = personaService.getPersonById(id);
		
		List<Ingreso> ingresos = ingresoService.getIngresosById(persona.getId());
		
		String gson = new Gson().toJson(ingresos);
		
		System.out.println("JSON: "+gson);
		
		return gson;
	}
	
	@Autowired
	EconomatoService economatoService;
	
	@GetMapping("/jsonEstadoSearch5")
	@ResponseBody
	public String jsonEstadoSearch5() {
		
		List<Economato_Elementos> listBienesUso = economatoService.listElementos();
		
		String gson = new Gson().toJson(listBienesUso);
		
		return gson;
	}
	
	@Autowired
	UserService userService;
	
	@GetMapping("/ajaxEstado2")
	@ResponseBody
	public void ajaxEstado(@RequestParam(name="dni", required=false) BigDecimal dni,
							@RequestParam(name="detalles", required=false) String detalles,
							@RequestParam(name="item", required=false) String item) {
	
		
		Ingreso ingreso = new Ingreso();
		 
		 Persona persona = userService.getPersonaByDni(dni);
		 
		 IngresoEstado ingresoEstado = new IngresoEstado();
		 
		 /*System.out.println("PARAMETROS PARA CARGAR INGRESO");
		 System.out.println("ID: "+id);
		 System.out.println("DETALLE: "+detalle);
		 System.out.println("ITEM: "+item);*/
		 
		 ingreso.setUserId(persona.getId());
		 ingreso.setAudDel(null);
		 ingreso.setAudIns(null);
		 ingreso.setAudUpd(null);
		 ingreso.setDetalles(detalles);
		 		 
		 ingresoEstado.setPerId(persona.getId());
		 
		 Timestamp ts=new Timestamp(System.currentTimeMillis());
		 Timestamp ts2=new Timestamp(System.currentTimeMillis());
		 
		 if(item.equals("ingreso")) {			 
			 ingreso.setFechaIn(new Date(ts.getTime()));
			 ingreso.setFechaFin(null);
			 ingresoEstado.setEstado(1);			 
		 }
				 
		 if(item.equals("egreso")) {
			 Ingreso lastTime = ingresoService.getLastTimeIngreso(persona.getId());
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
	}
	
	@PostMapping("/editBienConsumo")
	public String editBienConsumo(@RequestParam(name="id") int id,
								@RequestParam(name="stock", required=false) Integer stock,
								@RequestParam(name="nombre", required=false) String nombre) {
		
		if(stock!=null && nombre!=null) {
			int bienConsumo = economatoService.editBC(id, stock, nombre);
			System.out.println("SE EDITÓ "+bienConsumo);
		}else
			System.out.println("NO PUEDEN EXISTIR CAMPOS VACIOS");
		
		return "economato";		
	}
	
	@PostMapping("/newBC")
	@ResponseBody
	public void newBC(@RequestParam(name="nombre", required=false) String nombre,
						@RequestParam(name="stock", required=false) int stock,
						@RequestParam(name="categoria", required=false) int categoria) {
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>ENTRO A NEWBC");
		Economato_Elementos nuevoElemento = new Economato_Elementos();
		
		
		nuevoElemento.setNombre(nombre);
		nuevoElemento.setTipo(categoria);
		nuevoElemento.setStock(stock);
		nuevoElemento.setEstado(1);
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>"+nombre+" "+categoria+" "+stock);
		economatoService.addElemento(nuevoElemento);
		 
		System.out.println("OK");
		
	}
	 
	@PostMapping("/bajaBien")
	public String bajaBien(@RequestParam(name="id") int id,
						@RequestParam(name="estado") int estado) {
		
		if(estado==0)
			estado = 1;
		else
			estado = 0;
		
		economatoService.updateBCestado(estado, id);
		
		System.out.println("UPDATE OK");
		
		return "economato";
	}
	

	
	@GetMapping("/listBienesUso")
	@ResponseBody
	public String listBienesUso() {
		
		List<EcoBienesUso> listBienesUso = economatoService.listBienesUso();
		
		String gson = new Gson().toJson(listBienesUso);
		
		return gson;
	}
}
