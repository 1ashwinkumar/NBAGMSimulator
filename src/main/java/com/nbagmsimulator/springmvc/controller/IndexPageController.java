package com.nbagmsimulator.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nbagmsimulator.springmvc.model.Login;

@Controller
public class IndexPageController {
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value="/player", method = RequestMethod.GET)
	public String player() {
		return "player";
	}
	
	@RequestMapping(value="/coach", method = RequestMethod.GET)
	public String coach() {
		return "coach";
	}

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("login", new Login());
		return "login";
	}

	@RequestMapping(value="/signup", method = RequestMethod.GET)
	public String signup() {
		return "signup";
	}

}
