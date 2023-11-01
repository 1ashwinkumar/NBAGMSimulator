package com.nbagmsimulator.springmvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.nbagmsimulator.springmvc.model.Login;
import com.nbagmsimulator.springmvc.model.User;
import com.nbagmsimulator.springmvc.service.AccountService;

@RestController
public class SignupController {

	private static final Logger logger = LoggerFactory.getLogger(SignupController.class);
	
	@Autowired
	private AccountService accountService; 

	// -------------------- Retrieve All Users ---------------------------------
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<?> getAllUsers() {
		List<User> users = accountService.findAllUsers();
		if (users.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	// ------------------------- Retrieve A User By Id-----------------------------
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUserById(@RequestParam("id") Long id) {
		User user = accountService.findById(id);
		if (user == null) {
            logger.debug("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
        }
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	//-----------New User Signup---------
	@RequestMapping(value = "/users/signup", method = RequestMethod.POST)
	public ResponseEntity<?> register(@RequestBody @Valid User form) {
		logger.info("register success {}", form);
		accountService.saveUser(form);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	//------Login Flow-----
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView login(@Valid @ModelAttribute("login") Login form, BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView();
		if(bindingResult.hasErrors()) {
			bindingResult
			.getFieldErrors()
			.stream()
			.forEach(f -> mv.addObject("errors", f.getField() + ": " + f.getDefaultMessage()));
			 mv.setViewName("login");
			return mv;
		}else {
			Login newUser = new Login();
			newUser.setUserName(form.getUserName());
			newUser.setPassword(form.getPassword());

			logger.info("Log in success {}", form);
			mv.setViewName("login");
			mv.addObject("user", newUser.getUserName());

			return mv;			
		}

	}

}
