package org.glsid.metier;

import java.util.List;

import org.glsid.entite.Lieu;

public interface LieuMetier {
	//implimenter 2 operations 
	// une methode pour ajouter un lieu
	public Lieu saveLieu(Lieu l);
	//une methode pour consulter les lieus
	public List<Lieu> listLieu();
	

}
