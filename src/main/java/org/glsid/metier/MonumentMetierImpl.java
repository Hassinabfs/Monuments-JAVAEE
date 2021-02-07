package org.glsid.metier;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.glsid.dao.CelebriteRepository;
import org.glsid.dao.MonumentRepository;
import org.glsid.entite.Celebrite;
import org.glsid.entite.Monument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.lucene.util.SloppyMath;

@Service
@Transactional
public class MonumentMetierImpl implements MonumentMetier {
	
	
	@Autowired
	private MonumentRepository monumentRepository;
	@Autowired
	private CelebriteRepository celebriteRepository;
	
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

	@Override
	public Monument getMonument(String codeM) {
		// TODO Auto-generated method stub
		return monumentRepository.getOne(codeM);
	}

	@Override
	public Optional<Monument> findBycodeM(String codeM) {
		// TODO Auto-generated method stub
		return monumentRepository.findById(codeM);
	}

	@Override
	public boolean removeMonument(Monument m) {
		// TODO Auto-generated method stub
		try {
			monumentRepository.delete(m);
			return true;
		} catch (IllegalArgumentException e) {
			System.out.print("erreur lors de la suppression ");
		}
		;
		return false;
	}

	@Override
	public Monument updateMonument(Monument m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double distance(String codeMA, String codeMB) {
		// TODO Auto-generated method stub
			double latitudeMA = monumentRepository.getOne(codeMA).getLatitude();
			double longitudeMA=monumentRepository.getOne(codeMA).getLongitude();
			double latitudeMB=monumentRepository.getOne(codeMB).getLatitude();
			double longitudeMB = monumentRepository.getOne(codeMB).getLongitude();
			double distance = SloppyMath.haversinKilometers(latitudeMA, longitudeMA, latitudeMB, longitudeMB);
			return distance;
		
	}


	
	@Override
	public void associe(String numC, String codeM) {
		Monument monument= monumentRepository.getOne(codeM);
		Celebrite celebrite = celebriteRepository.getOne(numC);
		monument.getCelebriteS().add(celebrite);
		celebrite.getOeuvreDe().add(monument);
	}
	


}
