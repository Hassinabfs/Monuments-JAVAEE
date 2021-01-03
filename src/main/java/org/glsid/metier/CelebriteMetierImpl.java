package org.glsid.metier;

import java.util.List;
import java.util.Optional;

import org.glsid.dao.CelebriteRepository;
import org.glsid.dao.LieuRepository;
import org.glsid.entite.Celebrite;
import org.glsid.entite.Lieu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CelebriteMetierImpl implements CelebriteMetier{
	@Autowired
	private CelebriteRepository celebriteRepository;

	@Override
	public Celebrite saveCelebrite(Celebrite c) {
		// TODO Auto-generated method stub
		return celebriteRepository.save(c);
	}

	@Override
	public List<Celebrite> listCelebrite() {
		// TODO Auto-generated method stub
		return celebriteRepository.findAll();
	}
	
	@Override
	public Celebrite getCelebrite( String numC) {
		// TODO Auto-generated method stub
		return celebriteRepository.getOne(numC);
	}
	

	@Override
	public Optional<Celebrite> findByNumC( String numC) {
		// TODO Auto-generated method stub
		return celebriteRepository.findById(numC);
	}

	@Override
	public boolean removeCelebrite(Celebrite c) {
		// TODO Auto-generated method stub
		try {
			celebriteRepository.delete(c);
			return true;
		} catch (IllegalArgumentException e) {
			System.out.print("erreur lors de la suppression ");
		}
		;
		return false;
	}
	@Override
	public Celebrite updateCelebrite(Celebrite c) {
		// TODO Auto-generated method stub
		return null;
	}


}
