package org.glsid.metier;

import java.util.List;

import org.glsid.entite.Departement;
import org.glsid.entite.Lieu;

public interface DepartementMetier {
	public Departement saveDepartement(Departement d);
	
	public List<Departement>listDepartement();
	
	public Departement getDepartement(String dep);
	
	public boolean removeDepartement(Departement d);
	
	public Departement updateDepartement(Departement d);
}