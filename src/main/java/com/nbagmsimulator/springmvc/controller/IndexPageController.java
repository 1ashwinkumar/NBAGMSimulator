package com.nbagmsimulator.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nbagmsimulator.springmvc.model.Login;
import com.nbagmsimulator.springmvc.model.Player;
import com.nbagmsimulator.springmvc.service.PlayerService;

@Controller
public class IndexPageController {
	
	
	@Autowired
	private PlayerService playerService;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value="/player", method = RequestMethod.GET)
	public ModelAndView viewPlayersPage() {
		Player p = new Player();
		ModelAndView mv = new ModelAndView("player", "playerForm", p);
		return mv;
	}
	
	@RequestMapping(value="/playerDetail", method=RequestMethod.POST)
	public ModelAndView getPlayerDetails(@ModelAttribute Player p) {
		Player detail = playerService.signPlayer(p);
		
		ModelAndView mv = new ModelAndView("playerDetail");
		mv.addObject("player", detail);
		return mv;
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
