package org.glsid.metier;

import java.util.List;

import org.glsid.dao.MonumentRepository;
import org.glsid.entite.Monument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MonumentMetierImpl implements MonumentMetier {
	@Autowired
	private MonumentRepository monumentRepository;
	@Override
	public Monument saveMonument(Monument m) {
		// TODO Auto-generated method stub
		return monumentRepository.save(m);
	}

	@Override
	public List<Monument> listMonument() {
		// TODO Auto-generated method stub
		return monumentRepository.findAll();
	}

}
