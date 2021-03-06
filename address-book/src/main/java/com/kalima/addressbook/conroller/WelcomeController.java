package com.kalima.addressbook.conroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class WelcomeController {
	
	@RequestMapping ("/")
	public String welcome (Model model){
		model.addAttribute("heading", "The AddressBook by Fiona Davis");
		model.addAttribute("message", "After a failed apprenticeship, working her way up to head housekeeper of a posh London hotel is more than Sara Smythe ever thought she’d make of herself. But when a chance encounter with Theodore Camden, one of the architects of the grand New York apartment house The Dakota, leads to a job offer, her world is suddenly awash in possibility—no mean feat for a servant in 1884. The opportunity to move to America, where a person can rise above one’s station. The opportunity to be the female manager of The Dakota, which promises to be the greatest apartment house in the world. And the opportunity to see more of Theo, who understands Sara like no one else...and is living in The Dakota with his wife and three young children.");
		return "welcome";
		
	}

}
