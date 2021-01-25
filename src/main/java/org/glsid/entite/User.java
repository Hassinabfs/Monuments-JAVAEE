package org.glsid.entite;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity

public class User {
 
	@Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
 
    private String username;
    private String email;
    private String password;
    private boolean enabled = true ;
     
    
    private String roles = "ROLE_USER" ;
    
    public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(int id, String username, String email, String password, boolean enabled, String roles) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.roles = roles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String  getRoles() {
		return roles;
	}

	
    
    
    
    
}