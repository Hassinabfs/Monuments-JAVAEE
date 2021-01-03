package org.glsid.metier;

import java.util.List;
import java.util.Optional;

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

}
