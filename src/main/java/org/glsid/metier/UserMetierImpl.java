package org.glsid.metier;

import java.util.List;
import java.util.Optional;

import org.glsid.dao.MonumentRepository;
import org.glsid.dao.UserRepository;
import org.glsid.entite.Monument;
import org.glsid.entite.Role;
import org.glsid.entite.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserMetierImpl implements UserMetier,UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	public User saveUser(User u) {
		// TODO Auto-generated method stub
		u.setPassword(new BCryptPasswordEncoder().encode(u.getPassword()));
		return userRepository.save(u);
	}
	
	@Override
	public List<User> listUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	
	@Override
	public User getUser(int id) {
	return userRepository.getOne(id);
	}

	@Override
	public boolean removeUser(User u) {
		// TODO Auto-generated method stub
		try {
			userRepository.delete(u);
			return true;
		} catch (IllegalArgumentException e) {
			System.out.print("erreur lors de la suppression ");
		}
		;
		return false;
	}

	
	
	


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findByUsername(username); 
		user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username)); 
		return user.map(Role::new).get(); 
	}

	

	/*@Override
	public User updateUser(User u) {
		// TODO Auto-generated method stub
		return null;
	} */
	

}
