package com.kalima.addressbook.users;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kalima.addressbook.utils.ErrorUtils;




@Controller
@RequestMapping("/user")
public class userController {
	@Autowired
	private UserService userService;

	@GetMapping("/list")
	public String userList(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		return "user/list";
		
	}
//
//	@GetMapping("/form")
//	public String userForm(Model model) {
//		model.addAttribute("userForm", new User());
//		return "user/form";
//
//	}
	
	@GetMapping("/form")
	public String useForm( Model model) {
		
		model.addAttribute("isNew", true);
		model.addAttribute("user", new User());
		return "user/form";
		
	}
	
	@PostMapping(value="/add", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String registerUser(@Valid @RequestBody User user, BindingResult results) {
		if (results.hasErrors()) {

			return ErrorUtils.customErrors(results.getAllErrors());
			
		}else {
			return userService.addUser(user); 
		}
	}
	
	
	
	
	@GetMapping("/edit/{userid}")
	public String editUser(@PathVariable int userid, Model model) {
		model.addAttribute("isNew", false);
		model.addAttribute("user", userService.getUser(userid));
		model.addAttribute("message", "Edit user Form");
	
		return "user/form";
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value= "/user")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
		
	}
	
	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if (error!=null) {
			model.addAttribute("error", "Your userName and password are invalid");
			
		}
		if (logout!=null) {
			model.addAttribute("message", "You have been successfully logged out");
		}
							
		return "/user/login";
		
	}
	
//	@RequestMapping(method=RequestMethod.PUT, value= "/edit/{id}")
//	public void updateUser(@RequestBody User user,@PathVariable int userid) {
//		userService.updateUser(userid, user);
//		
//	}
	@GetMapping( value="/delete/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String deleteUser(@PathVariable int id) {
		 
		
		 return userService.deleteUser(id);
		
	}
}
