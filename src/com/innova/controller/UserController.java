package com.innova.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.innova.dao.SumAsigInvDAO;
import com.innova.entity.Ingreso;
import com.innova.entity.Persona;
import com.innova.entity.SumAsigInv;
import com.innova.entity.User;
import com.innova.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	 @RequestMapping("/")
	 public String home(Model model) {
	
		 List<User> users = userService.listUsers();
		 
		 model.addAttribute("users",users);
		 //model.addAttribute("users",user);
		 
		 return "home";
	 }
	
	 /*
	 @RequestMapping("/sumarios")
	 public String sumarios(Model model) {
		 
		 List<Sumarios> sumarios = invDAO.getSumarios();
		 
		 model.addAttribute("sumarios",sumarios);
		 
		 return "sumarios";
	 }*/
	 
	 
	 @Autowired
	 SumAsigInvDAO sumAsigInvDao;
	 
	 @RequestMapping("/sumariosPerid")
	 public String sumariosPerId(Model model) {
		 
		 List<SumAsigInv> sumarios = sumAsigInvDao.sumarios();
		 
		 model.addAttribute("sumariosPerid",sumarios);
		 
		 
		 return "sumariosPerid";
	 }
	 
	 @RequestMapping("/proc")
	 public String showProc(Model model) {
		
		 return "showProc";
	 }
	 
	 @GetMapping("/search")
	 public String searchUsers(@RequestParam(value = "searchPerson", required=false) String busqueda, Model model) {
		 
		 
		 List<Persona> theUsers = userService.listUsersByName(busqueda);
		 
		 model.addAttribute("searchUsers",theUsers);
		 
		 return "search";		 
	 }
	 
	 @RequestMapping("/actividadPersona")
	 public String actividadPersona(@RequestParam(value="id", required=false) int id, Model model) {
		 
		 Persona userSelected = userService.getPersonaById(id);
		 
		 model.addAttribute("userSelected",userSelected);
		 
		 return "actividadPersona";
	 }
	 
	 @PostMapping("/guardarMovimiento")
	 public String finActividadPersona(@RequestParam(value="userSelected", required=false) int id, Model model) {
		 
		 Ingreso ingreso = new Ingreso();
		 
		 int idi=1;
		 ingreso.setId(idi);
		 ingreso.setUserId(id);
		 ingreso.setAudDel(null);
		 ingreso.setAudIns(null);
		 ingreso.setAudUpd(null);
		 ingreso.setDetalles(null);
		 ingreso.setFechaFin(null);
		 ingreso.setFechaIn(null);
		 ingreso.setUserIns(null);
		 ingreso.setUserUpd(null);		 
		 
		 userService.ingresoPersona(ingreso);
		 
		 return "redirect:/search";
	 }
}
