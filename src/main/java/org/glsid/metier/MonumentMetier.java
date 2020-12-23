package org.glsid.metier;

import java.util.List;

import org.glsid.entite.Monument;


public interface MonumentMetier {
	public Monument saveMonument(Monument m);
	
	public List<Monument>listMonument();
}
