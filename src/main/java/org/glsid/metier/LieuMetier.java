package org.glsid.metier;

import java.util.List;
import java.util.Optional;

import org.glsid.entite.Departement;
import org.glsid.entite.Lieu;

public interface LieuMetier {
	//implimenter operations 
	// une methode pour ajouter un lieu
	public Lieu saveLieu(Lieu l);
	//une methode pour consulter les lieus
	public List<Lieu> listLieu();
	
	public Lieu getLieu(String codeInsee) ;
	
	public Optional<Lieu> findByCodeInsee(String codeInsee);

	public boolean removeLieu(Lieu l);
	
	public Lieu updateLieu(Lieu l);
	

	

}
