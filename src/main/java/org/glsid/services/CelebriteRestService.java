package org.glsid.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.glsid.entite.Celebrite;
import org.glsid.entite.Departement;
import org.glsid.entite.Monument;
import org.glsid.metier.CelebriteMetier;
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
public class CelebriteRestService {
	@Autowired
	private CelebriteMetier celebriteMetier;
	
	
	//afficher  la liste des celebrites
	
	@Secured(value = { "ROLE_ADMIN","ROLE_USER"}) 
	@RequestMapping(value="/celebrites",method=RequestMethod.GET)
	public String listCelebrite(Model model) {
		List<Celebrite> celebrites = celebriteMetier.listCelebrite();
		model.addAttribute("celebrites",celebrites);
		return "celebrite";
	}
	
	//formulaire d'ajout d'une celebrite
	
	
	@Secured(value = { "ROLE_ADMIN"}) 
	@GetMapping(value="/formCelebrite")
	public String formCelebrite(Model model) {
		model.addAttribute("celebrite",new Celebrite());
		return "formCelebrite";
	}
	
	// la methode d'ajout d'une celebrite dans la base (sauvegarder)
	
	@Secured(value = {"ROLE_ADMIN"}) 
	@RequestMapping(value="/addCelebrite")
	public String ajoutCelebrite(Celebrite c) {
		celebriteMetier.saveCelebrite(c);
		return "celebrite";
	}
	
	// trouver une celebrite  par le num (cle primaire)
	
	@Secured(value = { "ROLE_ADMIN","ROLE_USER"}) 
	@RequestMapping (value="/findCelebrite")
	public String getCelebriteNumC(Model model,  String numC){
		try {
	Optional<Celebrite> listCelebrite= celebriteMetier.findByNumC(numC);
		model.addAttribute("celebrite", listCelebrite.get());
		}catch(Exception e) {
		model.addAttribute("Exception",e);}
		return "findCelebrite";	
	}
	
	
	
	// supprimer une celebrite
	
	@Secured(value = {"ROLE_ADMIN"}) 
	@RequestMapping(value="/deleteCelebrite")
	public String removeCelebrite(@RequestParam  String numC ){
		
		Celebrite deleteCelebrite  = celebriteMetier.getCelebrite(numC);
		if(deleteCelebrite != null) {
			celebriteMetier.removeCelebrite(deleteCelebrite);
		}
		return "celebrite";
	}
	
	
	// modifier une celebrite
	
	@Secured(value = {"ROLE_ADMIN"}) 
	@GetMapping("/editCelebrite")
	public String updateCelebrite(String numC, Model model) {
		Celebrite  celebrite = celebriteMetier.findByNumC(numC).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + numC));
	    model.addAttribute("celebrite", celebrite);
	    return "formCelebrite";
	}
	
	
	
	// afficher les celebrites qui ont realise un monument donne 
	
	
	@Secured(value = { "ROLE_ADMIN","ROLE_USER"}) 
	@RequestMapping(value = "/findCelebriteByMonument")
	public String celebriteByMonument(Model model, String codeM) {
		try {
			Collection<Celebrite> celebriteM = celebriteMetier.getCelebriteByMonument(codeM);
			model.addAttribute("celebriteM", celebriteM );
			System.out.println("il est laaaaaaaaaaaaaaaaaa"+celebriteM);
			
			
			for ( Celebrite c:celebriteM) {
				
				System.out.println("il est laaaaaaaaaaaaaaaaaa le nom "+c.getNom());
			}
		}catch(Exception e) {
			model.addAttribute("Exception",e);}
				

		return "findCelebriteByMonument";
	}
	
	
	


}
