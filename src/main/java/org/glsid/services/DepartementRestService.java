package org.glsid.services;

import java.util.List;

import org.glsid.entite.Departement;
import org.glsid.entite.Lieu;
import org.glsid.metier.DepartementMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class DepartementRestService {
	@Autowired
	private DepartementMetier departementMetier;

	@RequestMapping(value="/departement",method=RequestMethod.GET)
	public String listDepartement(Model model) {
		List<Departement> Departements = departementMetier.listDepartement();
		model.addAttribute("departements",Departements);
		return "departement";
	}
	@GetMapping(value="/formDepartement")
	public String formDepartement(Model model) {
		model.addAttribute("departement",new Departement());
		return "formDepartement";
	}
	
	@RequestMapping(value="/addDepartement")
	public String ajoutDepartement(Departement d) {
		departementMetier.saveDepartement(d);
		return "formDepartement";
	}
	
	
}
