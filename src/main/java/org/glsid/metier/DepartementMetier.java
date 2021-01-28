package org.glsid.metier;

import java.util.List;
import java.util.Optional;


import org.glsid.entite.Departement;
import org.glsid.entite.Lieu;



public interface DepartementMetier {
	public Departement saveDepartement(Departement d);
	
	public Departement getDepartement(String dep) ;
	
	public List<Departement>listDepartement();
	
	//public List<Departement> findByNomDep(String nomDep);
	
	public Optional<Departement> findByDep(String dep);
	public Optional<Departement> findByNomDep(String dep);

	public boolean removeDepartement(Departement d);
	
	public Departement updateDepartement(Departement d);

}