package org.glsid.services;

import java.util.List;

import org.glsid.dao.UserRepository;
import org.glsid.entite.Lieu;
import org.glsid.entite.Monument;
import org.glsid.entite.User;
import org.glsid.metier.MonumentMetier;
import org.glsid.metier.UserMetier;
import org.glsid.metier.UserMetierImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthentificationController {
	
	@Autowired
	private UserMetierImpl userMetier;
	@Autowired
	UserRepository userRepository;
	
	@GetMapping(value = {"/login"})
	public String login() {
		return "login";
	}
	
	
	@RequestMapping(value = {"/relogin"}, method = RequestMethod.GET)
	public String relogin() {
		return "login";
	}
	
	@Secured(value = {"ROLE_ADMIN"}) 
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public String listUser(Model model) {
		List<User> users = userMetier.listUser();
		model.addAttribute("users",users);
		return "users";
	}
	
	
	@GetMapping(value="/formUser")
	public String formUser(Model model) {
		model.addAttribute("user",new User());
		return "formInscription";
	}
	
	@Secured(value = { "ROLE_ADMIN","ROLE_USER"}) 
	@RequestMapping(value="/addUser")
	public String ajoutUser(User u) {
		userMetier.saveUser(u);
		return "login";
	}
	
	@Secured(value = { "ROLE_ADMIN"}) 
	@RequestMapping(value="/deleteUser")
	public String removeUser(@RequestParam int id ){
		
		User deleteUser  = userMetier.getUser(id);
		if(deleteUser != null) {
			userMetier.removeUser(deleteUser);
		}
		return "users";
		
		
	}
	
	@Secured(value = { "ROLE_ADMIN"}) 
	@GetMapping("/editUser")
	public String updateUser(String username, Model model) {
		User user = userRepository.findByUsername(username).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + username));
	    model.addAttribute("user", user);
	    return "formUser";
	
	}	
	

}
