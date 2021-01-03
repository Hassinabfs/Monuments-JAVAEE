package org.glsid.services;

import java.util.List;
import java.util.Optional;

import org.glsid.entite.Celebrite;
import org.glsid.entite.Departement;
import org.glsid.entite.Monument;
import org.glsid.metier.CelebriteMetier;
import org.glsid.metier.DepartementMetier;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CelebriteRestService {
	@Autowired
	private CelebriteMetier celebriteMetier;

	@RequestMapping(value="/celebrites",method=RequestMethod.GET)
	public String listCelebrite(Model model) {
		List<Celebrite> celebrites = celebriteMetier.listCelebrite();
		model.addAttribute("celebrites",celebrites);
		return "celebrite";
	}
	
	
	@GetMapping(value="/formCelebrite")
	public String formCelebrite(Model model) {
		model.addAttribute("celebrite",new Celebrite());
		return "formCelebrite";
	}
	
	@RequestMapping(value="/addCelebrite")
	public String ajoutCelebrite(Celebrite c) {
		celebriteMetier.saveCelebrite(c);
		return "formCelebrite";
	}
	
	
	@RequestMapping (value="/findCelebrite")
	public String getCelebriteNumC(Model model,  String numC){
		try {
	Optional<Celebrite> listCelebrite= celebriteMetier.findByNumC(numC);
		model.addAttribute("celebrite", listCelebrite.get());
		}catch(Exception e) {
		model.addAttribute("Exception",e);}
		return "findCelebrite";	
	}
	
	@RequestMapping(value="/deleteCelebrite")
	public String removeCelebrite(@RequestParam  String numC ){
		
		Celebrite deleteCelebrite  = celebriteMetier.getCelebrite(numC);
		if(deleteCelebrite != null) {
			celebriteMetier.removeCelebrite(deleteCelebrite);
		}
		return "findCelebrite";
	}
	
	@GetMapping("/editCelebrite/{numC}")
	public String updateCelebrite(@PathVariable("numC")  String numC, Model model) {
		Celebrite  celebrite = celebriteMetier.findByNumC(numC).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + numC));
	    List<Celebrite> celebrites = celebriteMetier.listCelebrite();
	    model.addAttribute("celebrite", celebrite);
	    model.addAttribute("celebrites", celebrites);
	    return "updateCelebrite";
	}

}
