package org.glsid.metier;

import java.util.List;

import org.glsid.dao.CelebriteRepository;
import org.glsid.dao.LieuRepository;
import org.glsid.entite.Celebrite;
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

}
