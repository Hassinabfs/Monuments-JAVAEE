package org.glsid.services;

import java.util.List;
import java.util.Optional;

import org.glsid.entite.Lieu;
import org.glsid.entite.Monument;
import org.glsid.metier.MonumentMetier;
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
public class MonumentRestService {
	@Autowired
	private MonumentMetier monumentMetier;
	
	
	@RequestMapping(value="/monuments",method=RequestMethod.GET)
	public String listMonument(Model model) {
		List<Monument> monuments = monumentMetier.listMonument();
		model.addAttribute("monuments",monuments);
		return "monument";
	}
	
	
	@GetMapping(value="/formMonument")
	public String formMonument(Model model) {
		model.addAttribute("monument",new Monument());
		return "formMonument";
	}
	
	@RequestMapping(value="/addMonument")
	public String ajoutMonument(Monument m) {
		monumentMetier.saveMonument(m);
		return "formMonument";
	}
	
	
	@RequestMapping (value="/findMonument")
	public String getMonumentCodeM(Model model, String codeM){
		try {
	Optional<Monument> listMonument= monumentMetier.findBycodeM(codeM);
		model.addAttribute("monument", listMonument.get());
		}catch(Exception e) {
		model.addAttribute("Exception",e);}
		return "findMonument";	
	}
	
	@RequestMapping(value="/deleteMonument")
	public String removeMonument(@RequestParam String codeM ){
		
		Monument deleteMonument  = monumentMetier.getMonument(codeM);
		if(deleteMonument != null) {
			monumentMetier.removeMonument(deleteMonument);
		}
		return "findMonument";
	}
	
	@GetMapping("/editMonument/{codeInsee}")
	public String updateMonument(@PathVariable("codeInsee") String codeM, Model model) {
		Monument  monument = monumentMetier.findBycodeM(codeM).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + codeM));
	    List<Monument> monuments = monumentMetier.listMonument();
	    model.addAttribute("monument", monument);
	    model.addAttribute("monuments", monuments);
	    return "updateMonument";
	}

}
