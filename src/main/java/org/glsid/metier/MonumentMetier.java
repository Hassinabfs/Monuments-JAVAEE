package org.glsid.metier;

import java.util.List;
import java.util.Optional;

import org.glsid.entite.Lieu;
import org.glsid.entite.Monument;


public interface MonumentMetier {
	public Monument saveMonument(Monument m);
	
	public List<Monument>listMonument();
	
	public Monument getMonument(String codeM) ;
	
	public Optional<Monument> findBycodeM(String codeM);

	public boolean removeMonument(Monument m);
	
	public Monument updateMonument(Monument m);
	public double distance(String codeMA, String codeMB);
}
