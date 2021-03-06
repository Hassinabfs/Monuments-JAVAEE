package org.glsid.dao;

import java.util.List;
import java.util.Optional;

import org.glsid.entite.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, Integer>  {
	
	Optional<User> findByUsername(String username); 
	public User save(User u);
	


	
}
