package org.glsid.metier;

import java.util.List;
import java.util.Optional;

import org.glsid.entite.Monument;
import org.glsid.entite.User;

public interface UserMetier {

	
	
	public List<User>listUser();
	
	public User getUser(int id) ;
	
	public boolean removeUser(User u);
	
	
}
