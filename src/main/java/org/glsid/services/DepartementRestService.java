package org.glsid.services;

import java.util.List;
import java.util.Optional;


import org.glsid.entite.Departement;
import org.glsid.entite.Lieu;
import org.glsid.metier.DepartementMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class DepartementRestService {
	@Autowired
	private DepartementMetier departementMetier;

	@Secured(value = { "ROLE_ADMIN","ROLE_USER"}) 
	@RequestMapping(value="/departements",method=RequestMethod.GET)
	public String listDepartement(Model model) {
		List<Departement> Departements = departementMetier.listDepartement();
		model.addAttribute("departements",Departements);
		return "departement";
	}
	
	@Secured(value = { "ROLE_ADMIN"}) 
	@GetMapping(value="/formDepartement")
	public String formDepartement(Model model) {
		model.addAttribute("departement",new Departement());
		return "formDepartement";
	}
	
	
	@Secured(value = { "ROLE_ADMIN"}) 
	@RequestMapping(value="/addDepartement")
	public String ajoutDepartement(Departement d) {
		departementMetier.saveDepartement(d);
		return "formDepartement";
	}
	
	@Secured(value = { "ROLE_ADMIN","ROLE_USER"}) 
	@RequestMapping (value="/findDepartement")
	public String getDepartementDep(Model model, String dep){
		try {
	Optional<Departement> listDep= departementMetier.findByDep(dep);
		model.addAttribute("departement", listDep.get());
		}catch(Exception e) {
		model.addAttribute("Exception",e);}
		return "findDepartement";	
	}
	
	
	@Secured(value = { "ROLE_ADMIN","ROLE_USER"}) 
	@RequestMapping (value="/findDepartementNom")
	public String getDepartementNomDep(Model model, String nomDep){
		try {
	Optional<Departement> listDep= departementMetier.findByNomDep(nomDep);
		model.addAttribute("departement", listDep.get());
		}catch(Exception e) {
		model.addAttribute("Exception",e);}
		return "findDepartement";	
	}
	
	
	
	
	@Secured(value = {"ROLE_ADMIN"}) 
	@RequestMapping(value="/deleteDep")
	public String removeDepartement(@RequestParam String dep ){
		
		Departement deleteDep  = departementMetier.getDepartement(dep);
		if(deleteDep != null) {
			departementMetier.removeDepartement(deleteDep);
		}
		return "findDepartement";
	}
	
	@Secured(value = {"ROLE_ADMIN"}) 
	@GetMapping("/editDepartement")
	public String updateDep(String dep, Model model) {
	    Departement  departement = departementMetier.findByDep(dep).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + dep));
	    model.addAttribute("departement", departement);
	    return "formDepartement";
	}
	
	
}
