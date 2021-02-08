package org.glsid.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.glsid.entite.Celebrite;
import org.glsid.entite.Lieu;
import org.glsid.entite.Monument;
import org.glsid.metier.MonumentMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
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
public class MonumentRestService {
	@Autowired
	private MonumentMetier monumentMetier;
	
	//afficher  la liste des monuments
	
	@Secured(value = { "ROLE_ADMIN","ROLE_USER"}) 
	@RequestMapping(value="/monuments",method=RequestMethod.GET)
	public String listMonument(Model model) {
		List<Monument> monuments = monumentMetier.listMonument();
		model.addAttribute("monuments",monuments);
		return "monument";
	}
	
	//formulaire d'ajout d'une celebrite
	
	@Secured(value = { "ROLE_ADMIN"}) 
	@GetMapping(value="/formMonument")
	public String formMonument(Model model) {
		model.addAttribute("monument",new Monument());
		return "formMonument";
	}
	
	// la methode d'ajout d'un monument dans la base (sauvegarder)
	
	@Secured(value = { "ROLE_ADMIN"}) 
	@RequestMapping(value="/addMonument")
	public String ajoutMonument(Monument m) {
		monumentMetier.saveMonument(m);
		return "monument";
	}
	
	
	// trouver un monumet par son code  (cle primaire)
	
	
	@Secured(value = { "ROLE_ADMIN","ROLE_USER"}) 
	@RequestMapping (value="/findMonument")
	public String getMonumentCodeM(Model model, String codeM){
		try {
	Optional<Monument> listMonument= monumentMetier.findBycodeM(codeM);
		model.addAttribute("monument", listMonument.get());
		}catch(Exception e) {
		model.addAttribute("Exception",e);}
		return "findMonument";	
	}
	
	
	// supprimer un monument
	
	
	@Secured(value = { "ROLE_ADMIN"}) 
	@RequestMapping(value="/deleteMonument")
	public String removeMonument(@RequestParam String codeM ){
		
		Monument deleteMonument  = monumentMetier.getMonument(codeM);
		if(deleteMonument != null) {
			monumentMetier.removeMonument(deleteMonument);
		}
		return "monument";
	}
	
	
	
	// modifier un monument
	
	
	@Secured(value = { "ROLE_ADMIN"}) 
	@GetMapping("/editMonument")
	public String updateMonument(String codeM, Model model) {
		Monument  monument = monumentMetier.findBycodeM(codeM).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + codeM));
	    model.addAttribute("monument", monument);
	    return "monument";
	}
	
	
	// formulaire de distance 
	
	@Secured(value = { "ROLE_ADMIN","ROLE_USER"}) 
	@GetMapping(value="/formMonumentDistance")
	public String formMonumentDistance() {
		return "distance";
	}
	
	
	// calcul de distance entre deux monument
	
	
	@Secured(value = { "ROLE_ADMIN","ROLE_USER"}) 
	@RequestMapping(value = "/distance", method = RequestMethod.GET)
	public String distance(Model model , String codeMA, String codeMB) {
		Monument m1 = monumentMetier.getMonument(codeMA);
		Monument m2 = monumentMetier.getMonument(codeMB);
		double distance = monumentMetier.distance(codeMA, codeMB);
		model.addAttribute("distance", distance);
	
	     return "distance"; 
	     
	}
	
	
	// formulaire de d'associer un monument a une celebrite
	
	@Secured(value = { "ROLE_ADMIN"}) 
	@GetMapping(value="/formAssocie")
	public String formAssocie() {
		return "formAssocie";
	}
	
	
	
	// alimenter la table associe ,associer un monument a une celebrite
	
	@Secured(value = { "ROLE_ADMIN"}) 
	@RequestMapping(value = "/associer")
	public String AddCelebriteToMonument(String numC, String codeM) {
      monumentMetier.associe(numC, codeM);
	
		return "formAssocie";
	}
	
	
	// afficher les monument qui sont realises par une celebrite
	
		
	@Secured(value = { "ROLE_ADMIN","ROLE_USER"}) 
	@RequestMapping(value = "/findMonumentByCelebrite")
	public String MonumentByCelebrite(Model model, String numC) {
		try {
			Collection<Monument> monumentC = monumentMetier.getMonumentByCelebrite(numC);
			model.addAttribute("monumentC", monumentC);
		
		}catch(Exception e) {
			model.addAttribute("Exception",e);}
				
		return "findMonumentByCelebrite";
	}
	
	
	
	
	
	

}
