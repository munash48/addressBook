package com.kalima.addressbook.address;

import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kalima.addressbook.users.User;
import com.kalima.addressbook.users.UserService;
import com.kalima.addressbook.utils.ErrorUtils;



@Controller
@RequestMapping("/address")
public class AddressController {
	@Autowired
	private AddressService addressService;
	@Autowired
	private UserService userService;

	@GetMapping("/list")
	public String getAllAddresses(Model model) {
		model.addAttribute("addresses",addressService.getAllAddresses());
		return "/address/list";
		
	}
//	@GetMapping("/form")
//	public String addressForm (Model model) {
//		model.addAttribute("addressForm",new Address());
//		return "address/form";
//	}
	
	@GetMapping("/form")
	public String register(Model model) {
		model.addAttribute("isNew", true);
		model.addAttribute("address", new Address());
		model.addAttribute("addresses", userService.getAllUsers());


		return "address/form";
	}
	
	@PostMapping(value="/add", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String registerAddress(@Valid @RequestBody Address address, BindingResult results) {
		if (results.hasErrors()) {

			return ErrorUtils.customErrors(results.getAllErrors());
			
		}else {
			return addressService.addAddress(address);
		}
	
			      	 
			
	}
	

	@GetMapping("/edit/{addressid}")
	public String editUser(@PathVariable int addressid, Model model) {
		model.addAttribute("isNew", false);
		model.addAttribute("address", addressService.getAddress(addressid));
		model.addAttribute("message", "Edit Address Form");
	
		return "address/form";
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value= "/address")
	public void addAddress(@RequestBody Address address) {
		addressService.addAddress(address);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value= "/adit/{id}")
	public void updateAddress(@RequestBody Address address, @PathVariable int id) {
		addressService.updateAddress(id, address);
		
	}
	@GetMapping( value="/delete/{addressid}", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String deleteAddress(@PathVariable int addressid) {
	
		 return addressService.deleteAddress(addressid);
		
	}
	
	@ModelAttribute("users")
	private List<User> getUsers() {
		
		
		List<User> users=userService.getAllUsers();

				return users;
		
	}
	
}
