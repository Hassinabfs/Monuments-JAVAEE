package org.glsid.services;

import java.util.List;

import org.glsid.entite.Monument;
import org.glsid.metier.MonumentMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonumentRestService {
	@Autowired
	private MonumentMetier monumentMetier;
	@RequestMapping(value="/monuments",method=RequestMethod.POST)
	public Monument saveMonument(@RequestBody Monument m) {
		return monumentMetier.saveMonument(m);
	}
	@RequestMapping(value="/monuments",method=RequestMethod.GET)
	public List<Monument> listMonument() {
		return monumentMetier.listMonument();
	}

}
