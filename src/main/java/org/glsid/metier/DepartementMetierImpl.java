package org.glsid.metier;

import java.util.List;

import org.glsid.dao.CelebriteRepository;
import org.glsid.dao.DepartementRepository;
import org.glsid.entite.Departement;
import org.glsid.entite.Lieu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DepartementMetierImpl implements DepartementMetier {
	@Autowired
	private DepartementRepository departementRepository;

	@Override
	public Departement saveDepartement(Departement d) {
		// TODO Auto-generated method stub
		return departementRepository.save(d);
	}

	@Override
	public List<Departement> listDepartement() {
		// TODO Auto-generated method stub
		return departementRepository.findAll();
	}

	@Override
	public Departement getDepartement(String dep) {
		// TODO Auto-generated method stub
		return departementRepository.getOne(dep);
	}

	@Override
	public boolean removeDepartement(Departement d) {
		// TODO Auto-generated method stub
		try {
			departementRepository.delete(d);
			return true;
		} catch (IllegalArgumentException e) {
			System.out.print("erreur lors de la suppression ");
		}
		;
		return false;
	}

	@Override
	public Departement updateDepartement(Departement d) {
		// TODO Auto-generated method stub
		return null;
	}


}
