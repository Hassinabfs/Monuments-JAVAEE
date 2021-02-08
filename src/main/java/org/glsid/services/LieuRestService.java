package org.glsid.services;

import java.util.List;
import java.util.Optional;

import org.glsid.entite.Departement;
import org.glsid.entite.Lieu;
import org.glsid.metier.LieuMetier;
import org.glsid.metier.LieuMetierImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LieuRestService {
	@Autowired
	private LieuMetierImpl lieuMetier;
	
	
	//afficher  la liste des lieux
	
	@Secured(value = { "ROLE_ADMIN","ROLE_USER"}) 
	@RequestMapping(value="/lieux",method=RequestMethod.GET)
	public String listLieu(Model model) {
		List<Lieu> lieux = lieuMetier.listLieu();
		model.addAttribute("lieux",lieux);
		return "lieux";
	}
	
	//// formulaire d'ajout d'un  lieu
	
	@Secured(value = { "ROLE_ADMIN"}) 
	@GetMapping(value="/formLieu")
	public String formLieu(Model model) {
		model.addAttribute("lieu",new Lieu());
		return "formLieu";
	}
	
	// la methode d'ajout d'un lieu dans la base (sauvegarder)
	
	@Secured(value = {"ROLE_ADMIN"}) 
	@RequestMapping(value="/addLieu")
	public String ajoutLieu(Lieu l) {
		lieuMetier.saveLieu(l);
		return "lieux";
	}
	
	
	// trouver un lieu par son code Insee (cle primaire)
	
	@Secured(value = { "ROLE_ADMIN","ROLE_USER"}) 
	@RequestMapping (value="/findLieu")
	public String getLieuCodeInsee(Model model, String codeInsee){
		try {
	Optional<Lieu> listLieu= lieuMetier.findByCodeInsee(codeInsee);
		model.addAttribute("lieu", listLieu.get());
		}catch(Exception e) {
		model.addAttribute("Exception",e);}
		return "findLieu";	
	}
	
	
	// supprimer un lieu
	
	@Secured(value = {"ROLE_ADMIN"}) 
	@RequestMapping(value="/deleteLieu")
	public String removeLieu(@RequestParam String codeInsee ){
		
		Lieu deleteLieu  = lieuMetier.getLieu(codeInsee);
		if(deleteLieu != null) {
			lieuMetier.removeLieu(deleteLieu);
		}
		return "lieux";
	}
	
	
	// modifier un lieu
	
	@Secured(value = {"ROLE_ADMIN"}) 
	@GetMapping("/editLieu")
	public String updateLieu( String codeInsee, Model model) {
		Lieu  lieu = lieuMetier.findByCodeInsee(codeInsee).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + codeInsee));
	    model.addAttribute("lieu", lieu);
	    return "lieux";
	}
	
	
	


}
