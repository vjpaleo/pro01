package com.pro01.controllers;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pro01.model.Account;

@Controller
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
	
	@RequestMapping(value="/createAccount")
	public String createAccount(@ModelAttribute ("aNewAccount") Account account) {
		
		System.out.println(account.getFirstName() + " " + account.getLastName());
		return "createAccount";
	}

}
