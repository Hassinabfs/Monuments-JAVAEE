package org.glsid.metier;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.glsid.entite.Celebrite;
import org.glsid.entite.Lieu;

public interface CelebriteMetier {
	
		public Celebrite saveCelebrite(Celebrite c);
		
		public List<Celebrite>listCelebrite();
		
		public Celebrite getCelebrite( String numC) ;
		
		public Optional<Celebrite> findByNumC( String numC);

		public boolean removeCelebrite(Celebrite c);
		
		public Celebrite updateCelebrite(Celebrite c);
		
		public Collection<Celebrite> getCelebriteByMonument(String codeM);

}
