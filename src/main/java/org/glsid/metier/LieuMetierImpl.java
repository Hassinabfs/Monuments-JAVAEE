package org.glsid.metier;

import java.util.List;
import java.util.Optional;

import org.glsid.dao.LieuRepository;
import org.glsid.entite.Departement;
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

	@Override
	public Lieu getLieu(String codeInsee) {
		// TODO Auto-generated method stub
		return lieuRepository.getOne(codeInsee);
	}
	

	@Override
	public Optional<Lieu> findByCodeInsee(String codeInsee) {
		// TODO Auto-generated method stub
		return lieuRepository.findById(codeInsee);
	}

	@Override
	public boolean removeLieu(Lieu l) {
		// TODO Auto-generated method stub
		try {
			lieuRepository.delete(l);
			return true;
		} catch (IllegalArgumentException e) {
			System.out.print("erreur lors de la suppression ");
		}
		;
		return false;
	}

	@Override
	public Lieu updateLieu(Lieu l) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
