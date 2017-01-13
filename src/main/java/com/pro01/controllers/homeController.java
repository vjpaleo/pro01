package com.pro01.controllers;

import java.util.Random;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.pro01.model.Account;

@Controller
@SessionAttributes("aNewAccount")
public class homeController {
	
	private String[] quotes = {
			"If you don't like something, change it. If you can't change it, change your attitude. Don't complain. -- Maya Angelou",
			"Good, better, best. Never let it rest. 'Til your good is better and your better is best. -- St. Jerome",
			"The good life is one inspired by love and guided by knowledge. -- Bertrand Russell",
			"I am as bad as the worst, but, thank God, I am as good as the best. -- Walt Whitman"
			};
	
	@RequestMapping(value="/getQuote")
	public String getRandomQuote(Model model) {
		
		int rand = new Random().nextInt(quotes.length);
		
		String currentQuote = this.quotes[rand];
		
		model.addAttribute("randomQuote", currentQuote);
		
		return "quote";
	}
	
	@RequestMapping(value="/createAccount", method=RequestMethod.GET)
	public String createAccount(@Valid @ModelAttribute ("aNewAccount") Account account, BindingResult result) {
		System.out.println(account.getFirstName() + " " + account.getLastName() + " " + account.getEmail());
		return "createAccount";
	}
	
	@RequestMapping(value="/doCreate", method=RequestMethod.POST)
	public String doCreate(@ModelAttribute ("aNewAccount") Account account) {
		System.out.println("Creating the account:" + account.getFirstName() + " " + account.getLastName() + " " + account.getEmail());
		return "redirect:accountCreated.html";
	}
	
	@RequestMapping(value="accountCreated", method=RequestMethod.GET)
	public String accountCreated(@Valid @ModelAttribute ("aNewAccount") Account account, BindingResult result) {
		
		System.out.println("Welcome " + account.getFirstName() + " " + account.getLastName() + " " + account.getEmail());
		return "success";
	}
	
	
	public void setUserDetails (@RequestParam ("userName") String userName, Model model) {
		
		model.addAttribute("userName", userName);
		
		String userRole = "undefined";
		
		if ( userName == "Vijay") {
			userRole = "Admin";
		} else {
			userRole = "Guest";
		}
		
		model.addAttribute("userRole", userRole);
		
		System.out.println(userName + " " + userRole);
	}
	
	@ModelAttribute
	public void addAccountToModel(Model model) {
		
		if(!model.containsAttribute("aNewAccount")) {
			Account a = new Account();
			model.addAttribute("aNewAccount", a);
		}
		
	}

}
