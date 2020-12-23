package org.glsid.services;

import java.util.List;

import org.glsid.entite.Celebrite;
import org.glsid.entite.Departement;
import org.glsid.metier.CelebriteMetier;
import org.glsid.metier.DepartementMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CelebriteRestService {
	@Autowired
	private CelebriteMetier celebriteMetier;
	@RequestMapping(value="/celebrites",method=RequestMethod.POST)
	public Celebrite saveCelebrite(@RequestBody Celebrite c) {
		return celebriteMetier.saveCelebrite(c);
	}
	@RequestMapping(value="/celebrites",method=RequestMethod.GET)
	public List<Celebrite> listCelebrite() {
		return celebriteMetier.listCelebrite();
	}

}
