package com.nbagmsimulator.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nbagmsimulator.springmvc.model.Coach;
import com.nbagmsimulator.springmvc.model.Login;
import com.nbagmsimulator.springmvc.model.Player;
import com.nbagmsimulator.springmvc.service.CoachService;
import com.nbagmsimulator.springmvc.service.PlayerService;

@Controller
public class IndexPageController {
	
	
	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private CoachService coachService;
	
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
	
	@PostMapping(value="/playerDetail")
	public ModelAndView getPlayerDetails(@ModelAttribute Player p) {
		Player detail = playerService.signPlayer(p);
		
		ModelAndView mv = new ModelAndView("playerDetail");
		mv.addObject("player", detail);
		return mv;
	}
	
	@RequestMapping(value="/coach", method = RequestMethod.GET)
	public ModelAndView viewCoachesPage() {
		Coach c = new Coach();
		ModelAndView mv = new ModelAndView("coach", "coachForm", c);
		return mv;
	}
	
	@PostMapping(value="/coachDetail")
	public ModelAndView getCoachDetails(@ModelAttribute Coach c) {
		Coach detail = coachService.hireCoach(c);
		
		ModelAndView mv = new ModelAndView("coachDetail");
		mv.addObject("coach", detail);
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
