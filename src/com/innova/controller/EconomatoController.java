package com.innova.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.innova.entity.EcoBienesUso;
import com.innova.entity.Economato_Elementos;
import com.innova.entity.Persona;
import com.innova.service.EconomatoService;
import com.innova.service.PersonaService;

@Controller
public class EconomatoController {

	@RequestMapping("/elementos")
	public String economato(@RequestParam(name="page",required = false) Integer page,
							Model model) {
				
		List<Economato_Elementos> listBienesUso = economatoService.listElementos();
		
		PagedListHolder<Economato_Elementos> pagedListHolder = new PagedListHolder<>(listBienesUso);
		
		int totalBienesUso = economatoService.countBienesUso();
		
		int paginas = (int)Math.ceil(totalBienesUso / 10);
		
		pagedListHolder.setPageSize(paginas);
		
		model.addAttribute("maxPages",pagedListHolder.getPageCount());
		
		if(page==null || page < 1 || page > pagedListHolder.getPageCount())page=1;
		
		model.addAttribute("page",page);
		
		 if(page == null || page < 1 || page > pagedListHolder.getPageCount()){
	            pagedListHolder.setPage(0);
	            model.addAttribute("listado", pagedListHolder.getPageList());
		 }else if(page <= pagedListHolder.getPageCount()) {
	            pagedListHolder.setPage(page-1);	            
	            model.addAttribute("listado", pagedListHolder.getPageList());
	     }
				
		return "economato";
	} 
	
	@Autowired
	EconomatoService economatoService;
	
	@GetMapping("/elementoSearch")
	public String elementoSearch(@RequestParam(name="page",required = false) Integer page,
								@RequestParam(name="elemNombre", required=false) String nombre,
								@RequestParam(name="elemEstado", required=false) int estado,
								@RequestParam(name="elemTipo", required=false) int tipo
								,Model model) {
		
		List<Economato_Elementos> listado = economatoService.listElementosByFilters(nombre, estado, tipo);		
		
		PagedListHolder<Economato_Elementos> pagedListHolder = new PagedListHolder<>(listado);
		
		int totalBienesUso = economatoService.countBienesUso();
		
		int paginas = (int)Math.ceil(totalBienesUso / 10);
		
		pagedListHolder.setPageSize(paginas);
		
		model.addAttribute("maxPages",pagedListHolder.getPageCount());
		
		if(page==null || page < 1 || page > pagedListHolder.getPageCount())page=1;
		
		model.addAttribute("page",page);
		
		 if(page == null || page < 1 || page > pagedListHolder.getPageCount()){
	            pagedListHolder.setPage(0);
	            model.addAttribute("listado", pagedListHolder.getPageList());
		 }else if(page <= pagedListHolder.getPageCount()) {
	            pagedListHolder.setPage(page-1);	            
	            model.addAttribute("listado", pagedListHolder.getPageList());
	        }
		
		
		
		
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
	
	@GetMapping("/bienesUso")
	public String bienesUso(@RequestParam(name="page",required = false) Integer page, Model model) {
		
		List<EcoBienesUso> listBienesUso = economatoService.listBienesUso();
		
		PagedListHolder<EcoBienesUso> pagedListHolder = new PagedListHolder<>(listBienesUso);
		
		int totalBienesUso = economatoService.countBienesUso();
		
		int paginas = (int)Math.ceil(totalBienesUso / 10);
		
		pagedListHolder.setPageSize(paginas);
		
		model.addAttribute("maxPages",pagedListHolder.getPageCount());
		
		if(page==null || page < 1 || page > pagedListHolder.getPageCount())page=1;
		
		model.addAttribute("page",page);
		
		 if(page == null || page < 1 || page > pagedListHolder.getPageCount()){
	            pagedListHolder.setPage(0);
	            model.addAttribute("listado", pagedListHolder.getPageList());
		 }else if(page <= pagedListHolder.getPageCount()) {
	            pagedListHolder.setPage(page-1);	            
	            model.addAttribute("listado", pagedListHolder.getPageList());
	        }
		
				
		return "economatoBienesUso";
	}
	
	@GetMapping("/searchBU")
	public String searchBU(@RequestParam(name="page",required = false) Integer page,
							@RequestParam(name="nombreSearch")String nombre,
							  Model model) {
		
		
		List<EcoBienesUso> busquedaNombre = economatoService.listBienesUsoByName(nombre);
		
		PagedListHolder<EcoBienesUso> pagedListHolder = new PagedListHolder<>(busquedaNombre);
		
		int totalBienesUso = economatoService.countBienesUso();
		
		int paginas = (int)Math.ceil(totalBienesUso / 10);
		
		pagedListHolder.setPageSize(paginas);
		
		model.addAttribute("maxPages",pagedListHolder.getPageCount());
		
		if(page==null || page < 1 || page > pagedListHolder.getPageCount())page=1;
		
		model.addAttribute("page",page);
		
		 if(page == null || page < 1 || page > pagedListHolder.getPageCount()){
	            pagedListHolder.setPage(0);
	            model.addAttribute("listado", pagedListHolder.getPageList());
		 }else if(page <= pagedListHolder.getPageCount()) {
	            pagedListHolder.setPage(page-1);	            
	            model.addAttribute("listado", pagedListHolder.getPageList());
	        }
		
				
		return "economatoBienesUso";
		
	}
	
	@GetMapping("/nuevoBienUso")
	public String nuevoBienUso(Model model) {
		
		
		
		return "nuevoBienUso";
	}
	
	@Autowired
	PersonaService personaService;
	
	List<Integer> excepciones = new ArrayList<Integer>();
	
	@GetMapping("/nuevoMovimientoBU")
	public String nuevoMovBU(@RequestParam(name="bienSearch", required=false) String nombreBien,
						@RequestParam(name="dniSearch", required=false) BigDecimal dni, 
						@RequestParam(name="page",required = false) Integer page,
						@RequestParam(name="id", required = false) Integer id,
						Model model) {
		
		if(id!=null) {
			EcoBienesUso excep = economatoService.getBienById(id);
			
			excepciones.add(excep.getId());
			
			System.out.println("LISTADO "+excepciones);
		}
		
		
		if(dni!=null) {
			Persona persona = personaService.getPersonaByNameOrDni(dni);
			model.addAttribute("persona",persona);
		}

		
		List<EcoBienesUso> busquedaNombre = economatoService.listBienesUsoByNameExc(nombreBien,excepciones);
		
		PagedListHolder<EcoBienesUso> pagedListHolder = new PagedListHolder<>(busquedaNombre);

		int totalBienesUso = economatoService.countBienesUso();

		//int paginas = (int)Math.ceil(totalBienesUso / 10); REDONDEA PARA ARRIBA

		pagedListHolder.setPageSize(10);
		
		model.addAttribute("maxPages",pagedListHolder.getPageCount());
		
		if(page==null || page < 1 || page > pagedListHolder.getPageCount())page=1;
		
		model.addAttribute("page",page);
		
		 if(page == null || page < 1 || page > pagedListHolder.getPageCount()){
	            pagedListHolder.setPage(0);
	            model.addAttribute("listadoBU", pagedListHolder.getPageList());
		 }else if(page <= pagedListHolder.getPageCount()) {
	            pagedListHolder.setPage(page-1);	            
	            model.addAttribute("listadoBU", pagedListHolder.getPageList());
	        }
		
		 
		 List<EcoBienesUso> listBienesInc = economatoService.listBienesUsoByNameInc(excepciones); 
		 model.addAttribute("listadoBUselected",listBienesInc);
		 
		return "nuevoMovBU";
	}
	 
	@RequestMapping("/saveMovBU")
	public String saveMovBU(@RequestParam(name="listElementos", required=false) String lista,
							@RequestParam(name="id", required=false) Integer id, Model model) {
		System.out.println("ID "+id);
		System.out.println("LISTA "+lista);
		
		return "nuevoMovBU";
	}
	
}
