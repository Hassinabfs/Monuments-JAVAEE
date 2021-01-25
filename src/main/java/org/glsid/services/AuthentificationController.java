package org.glsid.services;

import java.util.List;

import org.glsid.entite.Lieu;
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
	
	@GetMapping(value = {"/login"})
	public String login() {
		//ModelAndView modelAndView = new ModelAndView();
		//modelAndView.setViewName("login");
		return "formLogin";
	}
	
	
	@RequestMapping(value = {"/lo"}, method = RequestMethod.GET)
	public String lo() {
		//ModelAndView modelAndView = new ModelAndView();
		//modelAndView.setViewName("login");
		return "monument";
	}
	
	@Secured(value = {"ROLE_ADMIN"}) 
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public String listUser(Model model) {
		List<User> users = userMetier.listUser();
		model.addAttribute("users",users);
		return "users";
	}
	
	@Secured(value = { "ROLE_ADMIN","ROLE_USER"}) 
	@GetMapping(value="/formUser")
	public String formUser(Model model) {
		model.addAttribute("User",new User());
		return "formUser";
	}
	
	@Secured(value = { "ROLE_ADMIN","ROLE_USER"}) 
	@RequestMapping(value="/addUser")
	public String ajoutUser(User u) {
		userMetier.saveUser(u);
		return "formUser";
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
	
	/*@GetMapping("/editLieu/{username}")
	public String updateUser(@PathVariable("username") String username, Model model) {
		User user = UserMetier.findByUsername(username).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + codeInsee));
	    List<User> Users= UserMetier.listUser();
	    model.addAttribute("User", User);
	    model.addAttribute("Users", Users);
	    return "updateUser";
	}*/
	
	
	
	
	/*@RequestMapping(value = {"/register"}, method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView();
		User user  = new User();
		modelAndView.addObject("user",user);
		modelAndView.setViewName("register");
		return modelAndView;
	}
	
	@RequestMapping(value = {"/home"}, method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		return modelAndView;
	}
	
	
	@RequestMapping(value = {"/register"}, method = RequestMethod.POST)
	public ModelAndView registerUser(@Validated User user,BindingResult bindingResult,ModelMap modelMap ) {
		ModelAndView modelAndView = new ModelAndView();
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("successMessage","svp corriger l'erreur dans le formulaire");
			modelMap.addAttribute("bindingResult",bindingResult);
		}
		else if (userMetier.isUserAlreadyPresent(user)) {
			modelAndView.addObject("successMessage","user already exists!");
		}
		else {
			userMetier.saveUser(user);
			modelAndView.addObject("successMessage","user is regitred successfully!");
			
		}
		modelAndView.addObject("user",new User());
		modelAndView.setViewName("register");
		return modelAndView;
	}
	
	*/
}
