package com.innova.controller;
import java.math.BigDecimal;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.innova.entity.EcoBienesUso;
import com.innova.entity.EcoMovLog;
import com.innova.entity.Economato_Elementos;
import com.innova.entity.Persona;
import com.innova.service.EconomatoService;
import com.innova.service.PersonaService;


@RestController
public class RestC {

	@Autowired
	EconomatoService ecoService;
	
	@Autowired
	PersonaService personaService;
	
	Integer idMov=null;
	
	@PostMapping("/saveMovBienes2")	
	public String saveMovBienes2(@RequestBody Request myRequest) {

		
		BigDecimal dni = new BigDecimal(myRequest.getDni());
		
		Persona persona = personaService.getPersonaByNameOrDni(dni);
		
		String json = myRequest.getTable().toString();
		
		JSONArray arr = new JSONArray(json);
		
		int total=0;
		
		try {
			idMov= ecoService.getLastIdMovLog();
			idMov++;
		}catch(Exception e) {
			idMov=1;
		}
		
		for (int i = 0; i < arr.length(); ++i) {
		    JSONObject rec = arr.getJSONObject(i);
		    int id = rec.getInt("id");
		    String nombre= rec.getString("nombre");
		    Integer cant = rec.getInt("stock");

		    try {
		    	System.out.println("SERA BU?");
		    	EcoBienesUso bu = ecoService.getBienByNameId(id,nombre);
		    	System.out.println("SI");
		    	System.out.println("BU ENCONTRADO "+bu);
		    	System.out.println("CANT BU: "+myRequest.getCant());
		    	
		    	//Guardo el movimiento general
		    	ecoService.saveMovBien(myRequest.getTipoMov(), 1, id, persona.getId(),cant,1);
		    	
		    	System.out.println("POR GUARDAR TEMPORAL DE "+persona.getId());
		    	//Guardo el elemento como temporal en la tabla Temporal
		    	ecoService.saveTemporal(persona.getId(), id, cant, myRequest.getTipoMov());
		    	
		    	int cantidadStock = ecoService.getStockBU(bu.getId());
		    	
		    	if(myRequest.getCant()<=cantidadStock) {
		    		total=cantidadStock-cant;
		    		bu.setStock(total);
		    		ecoService.updateStockBU(bu);		    		
		    	}
		    	
		    }catch(Exception e) {
		    	//e.printStackTrace();
		    	
		    	ecoService.saveMovBien(myRequest.getTipoMov(), 2, id, persona.getId(), cant, null);
		    	
		    	Economato_Elementos bc = ecoService.getBienByNameIdBC(id,nombre);
		    	
		    	System.out.println("BC ENCONTRADO "+bc);
		    	System.out.println("CANT BC: "+cant);		    	
		    	
		    	int cantidadStock = ecoService.getStockBC(bc.getId());		    	
		    	
		    	
		    	if(myRequest.getCant()<=cantidadStock) {
		    		total=cantidadStock-cant;
		    		bc.setStock(total);		    		
		    		ecoService.updateStockBC(bc);		    	
		    	}
		    }	
		    
		    
		    EcoMovLog movLog = new EcoMovLog();
		    
		    //busco el último ID de elemento que se registró en la base
		    System.out.println("Busco el ultimo id MOV");
		    Integer lastIdMovLog = ecoService.getLastIdMov();
		    
		    
		    
		    System.out.println("TRYCATCH si ya existe registro de movlog");
		    //me fijo si existe registro en Mov Log, en caso de que no, metemos el valor 1
		    try {		    	
		    	
		    	
		    	
				System.out.println("SETEANDO ID MOVLOG "+idMov);
				movLog.setId(idMov);
				movLog.setIdMov(lastIdMovLog);
				    
				ecoService.saveMovLog(movLog);
				    
				System.out.println("MOV LOG "+movLog); 
		    	
		    }catch(Exception e) {
		    	//e.printStackTrace();
		    	System.out.println("NO");
		    	idMov=1;
		    	System.out.println("SETEANDO ID MOVLOG "+idMov);
			    movLog.setId(idMov);
			    movLog.setIdMov(lastIdMovLog);
			    
			    ecoService.saveMovLog(movLog);
			    
			    System.out.println("MOV LOG "+movLog);
		    } 
		}

		idMov++;
		
		json=null;
		arr=null;
		return "";
	}
	
	
	
	
	@PostMapping("/saveMovBienesDev")	
	public String saveMovBienesDev(@RequestBody Request myRequest) {

		
		BigDecimal dni = new BigDecimal(myRequest.getDni());
		
		Persona persona = personaService.getPersonaByNameOrDni(dni);
		
		String json = myRequest.getTable().toString();
		
		JSONArray arr = new JSONArray(json);
		
		int total=0;
		
		int updateDev=0;
		
		for (int i = 0; i < arr.length(); ++i) {
		    JSONObject rec = arr.getJSONObject(i);
		    
		    int id = rec.getInt("id");
		    
		    String nombre= rec.getString("nombre");
		    
		    int dev = rec.getInt("stock");
		    
		    try {
		    	
		    	EcoBienesUso bu = ecoService.getBienByNameId(id,nombre);
		    	
		    	int buACargo = ecoService.getBienCantCargo(persona.getId(),id); 
		    	
		    	System.out.println("COMPARO SI LO QUE DEVUELVE ("+dev+") ES MENOR A LO QUE SE LE DIO ("+buACargo+")");
		    	
		    	if(dev<=buACargo) {
		    		ecoService.saveMovBien(myRequest.getTipoMov(), 1, id, persona.getId(),dev,1);
		    		//updateDev = buACargo - dev;
		    		System.out.println("SE ACTUALIZO STOCK A "+updateDev);
		    		ecoService.saveTemporal(persona.getId(), id, dev, myRequest.getTipoMov());
		    		//ecoService.updateBienCantCargo(updateDev,id,persona.getId());
		    	}else {
		    		ecoService.saveMovBien(myRequest.getTipoMov(), 1, id, persona.getId(),dev,0);
		    	}
		    	
		    	int cantidadStock = ecoService.getStockBU(bu.getId());
		    	
		    	System.out.println("EL STOCK QUE HAY DEL ELEM ES "+cantidadStock);
		    	
		    	total=cantidadStock+dev;
		    	
		    	System.out.println("AL DEVOLVER ESTO, QUEDA EL STOCK ASI: "+ total);
		    	
		    	bu.setStock(total);
		    	
		    	
		    	ecoService.updateStockBU(bu);		    		
		    	System.out.println("SE GUARDÓ EL STOCK AL ELEMENTO"); 

		    }catch(Exception e) {
		    	e.printStackTrace();		    	
		    }	
		}

		System.out.println("GUARDADO");
		
		json=null;
		arr=null;
		return "";
	}
}
