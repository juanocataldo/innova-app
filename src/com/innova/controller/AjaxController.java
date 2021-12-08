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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.innova.entity.EcoBienesMov;
import com.innova.entity.EcoBienesUso;
import com.innova.entity.EcoTemporal;
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
	public String demo2(@PathVariable("dni") BigDecimal dni, Model model) {
		
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
		
		List<Economato_Elementos> listBienesConsumo = economatoService.listElementos();
		
		String gson = new Gson().toJson(listBienesConsumo);
		
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
	
	
	
	
	@PostMapping("/editBienUso")
	public String editBienUso(@RequestParam(name="id") int id,
								@RequestParam(name="stock", required=false) Integer stock,
								@RequestParam(name="nombre", required=false) String nombre) {
		
		if(stock!=null && nombre!=null) {
			int bienUso = economatoService.editBU(id, stock, nombre);
				if(bienUso==1)
					System.out.println("SE EDITÓ "+bienUso);
				else
					System.out.println("ALGO SUCEDIÓ");
		}else
			System.out.println("NO PUEDEN EXISTIR CAMPOS VACIOS");
		
		return "economatoBienesUso";		
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
	
	
	@PostMapping("/bajaBienUso")
	public String bajaBienUso(@RequestParam(name="id") int id,
						@RequestParam(name="estado") int estado) {
		
		if(estado==0)
			estado = 1;
		else
			estado = 0;
		
		economatoService.updateBUestado(estado, id);
		
		System.out.println("UPDATE OK");
		
		return "economatoBienesUso";
	}
	

	
	@GetMapping("/listBienesUso1")
	@ResponseBody
	public String listBienesUso1() {
		
		List<EcoBienesUso> listBienesUso = economatoService.listBienesUso();
		
		String gson = new Gson().toJson(listBienesUso);
		
		return gson;
	}
	
	
	@PostMapping("/newBU")
	@ResponseBody
	public void newBU(@RequestParam(name="nombre", required=false) String nombre,
						@RequestParam(name="stock", required=false) int stock
						) {
		
		EcoBienesUso nuevoElemento = new EcoBienesUso();
		
		nuevoElemento.setNombre(nombre);		
		nuevoElemento.setStock(stock);
		nuevoElemento.setEstado(1);
		
		economatoService.addElementoBU(nuevoElemento);
		 
		System.out.println("OK");		
	}
	
	List<Economato_Elementos> listadoBC = new ArrayList<>();
	List<EcoBienesUso> listadoBU = new ArrayList<>();
	List<Object> listSelec = new ArrayList<>();
	List<String> select = new ArrayList<>();
	
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	@GetMapping("/listBienesSeleccioandos")
	@ResponseBody
	public String listBienesSeleccioandos(@RequestParam(name="id", required=false) Integer id,
											@RequestParam(name="cat", required=false) Integer cat,
											@RequestParam(name="cant", required=false) Integer cant) {
		
		
		
		if(id!=null || cat!=null || cant!=null) {
			
			if(cat==2) {
				System.out.println("Entramos a BU "+cat+". Buscamos ID "+id);
				EcoBienesUso bu = economatoService.getBienById(id);
				bu.setStock(cant);
				listSelec.add(bu);
				JsonElement json = gson.toJsonTree(listSelec);
				
				return json.toString();
			}else {		
				System.out.println("Entramos a BC "+cat+". Buscamos ID "+id);
				Economato_Elementos bc = economatoService.getBCbyId(id);
				bc.setStock(cant);
				listSelec.add(bc);
				JsonElement json = gson.toJsonTree(listSelec);
				return json.toString();	
			}
			
		}
			JsonElement json = gson.toJsonTree(listSelec);
			
			
			
			return json.toString();			
	}
	
	@GetMapping("/limpiar")
	@ResponseBody
	public String limpiar() {
		
		listSelec.clear();
		listSelecDev.clear();
		System.out.println("CANCELAR");
		
		JsonElement json = gson.toJsonTree(listSelec);
		return json.toString();
	}
	
	@PostMapping("/inOut")
	public String inOut(@RequestParam(name="tipoMov", required=false) int mov,
						@RequestParam(name="dniSearch", required=false) BigDecimal dni,
						Model model) {
		
		System.out.println("DNI "+dni);
		
		if(mov==1) {
			model.addAttribute("tipoMov",mov);
			return "nuevoMovBU";
		}
		else {
			model.addAttribute("dni",dni);
			return "devolucionB";	
		}
			
	}
	
	
	
	
	@GetMapping("/listadoMovimientos")
	@ResponseBody
	public String listadoMovimientos() {
		
		List<EcoBienesMov> listMovs = economatoService.listMovimientos();
		
		String gson = new Gson().toJson(listMovs);
		
		return gson;			
	}
	
	@GetMapping("/listBienesCargo")
	@ResponseBody
	public String listBienesCargo(@RequestParam(name="dni", required=false) BigDecimal dni) {
		
		Persona persona = personaService.getPersonaByNameOrDni(dni);
		System.out.println("PERSONA ENCONTRADA "+persona);
		List<EcoTemporal> mov = economatoService.listBienesCargo(persona.getId());
		
		String gson = new Gson().toJson(mov);
		
		return gson; 
	}
	
	List<Object> listSelecDev = new ArrayList<>();
	@GetMapping("/listBienesSeleccioandosDev")
	@ResponseBody
	public String listBienesSeleccioandosDev(@RequestParam(name="id", required=false) Integer id,											
											@RequestParam(name="cant", required=false) Integer cant) {
		
		
		
		if(id!=null || cant!=null) {
			
			
				System.out.println("Entramos a BU ");
				EcoBienesUso bu = economatoService.getBienById(id);
				bu.setStock(cant);
				listSelecDev.add(bu);
				JsonElement json = gson.toJsonTree(listSelecDev);
				
				return json.toString();
			
		}
			JsonElement json = gson.toJsonTree(listSelecDev);
			
			
			
			return json.toString();			
					
	} 
	
	
	@GetMapping("/detalleBien/{id}")
	@ResponseBody
	public String detalleBien(@PathVariable("id") int id) {
		
		List<EcoBienesMov> listMovs = economatoService.listMovsById(id);
		System.out.println("listMovs "+ listMovs);
		String gson = new Gson().toJson(listMovs);
		
		return gson;			
	}
	
	@GetMapping("/listadoElems/{id}")
	public String listadoElems(@PathVariable("id") int id) {
		
		return "detalleBien";
	}
	
	
}
