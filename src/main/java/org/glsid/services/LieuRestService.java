package org.glsid.services;

import java.util.List;
import java.util.Optional;

import org.glsid.entite.Departement;
import org.glsid.entite.Lieu;
import org.glsid.metier.LieuMetier;
import org.glsid.metier.LieuMetierImpl;
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
public class LieuRestService {
	@Autowired
	private LieuMetierImpl lieuMetier;
	
	@RequestMapping(value="/lieux",method=RequestMethod.GET)
	public String listLieu(Model model) {
		List<Lieu> lieux = lieuMetier.listLieu();
		model.addAttribute("lieux",lieux);
		return "lieux";
	}
	
	
	@GetMapping(value="/formLieu")
	public String formLieu(Model model) {
		model.addAttribute("lieu",new Lieu());
		return "formLieu";
	}
	
	@RequestMapping(value="/addLieu")
	public String ajoutLieu(Lieu l) {
		lieuMetier.saveLieu(l);
		return "formLieu";
	}
	
	
	@RequestMapping (value="/findLieu")
	public String getLieuCodeInsee(Model model, String codeInsee){
		try {
	Optional<Lieu> listLieu= lieuMetier.findByCodeInsee(codeInsee);
		model.addAttribute("lieu", listLieu.get());
		}catch(Exception e) {
		model.addAttribute("Exception",e);}
		return "findLieu";	
	}
	
	@RequestMapping(value="/deleteLieu")
	public String removeLieu(@RequestParam String codeInsee ){
		
		Lieu deleteLieu  = lieuMetier.getLieu(codeInsee);
		if(deleteLieu != null) {
			lieuMetier.removeLieu(deleteLieu);
		}
		return "findLieu";
	}
	
	@GetMapping("/editLieu/{codeInsee}")
	public String updateLieu(@PathVariable("codeInsee") String codeInsee, Model model) {
		Lieu  lieu = lieuMetier.findByCodeInsee(codeInsee).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + codeInsee));
	    List<Lieu> lieux = lieuMetier.listLieu();
	    model.addAttribute("lieu", lieu);
	    model.addAttribute("lieux", lieux);
	    return "updateLieu";
	}
	
	
	
	
	
	
	
	
	@RequestMapping(value="/")
	public String index() {
		return "index";
	}

}
