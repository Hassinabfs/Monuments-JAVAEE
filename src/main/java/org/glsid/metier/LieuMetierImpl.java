package org.glsid.metier;

import java.util.List;

import org.glsid.dao.LieuRepository;
import org.glsid.entite.Lieu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class LieuMetierImpl implements LieuMetier {
	@Autowired
	private LieuRepository lieuRepository;
	@Override
	public Lieu saveLieu(Lieu l) {
		// TODO Auto-generated method stub
		return lieuRepository.save(l);
	}
 
	@Override
	public List<Lieu> listLieu() {
		// TODO Auto-generated method stub
		return lieuRepository.findAll();
	}

}
