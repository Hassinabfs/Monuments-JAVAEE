package org.glsid.metier;

import java.util.List;

import org.glsid.entite.Celebrite;

public interface CelebriteMetier {
	
		public Celebrite saveCelebrite(Celebrite c);
		
		public List<Celebrite>listCelebrite();

}
