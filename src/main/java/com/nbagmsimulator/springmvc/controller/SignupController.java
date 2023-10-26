package com.nbagmsimulator.springmvc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nbagmsimulator.springmvc.model.User;
import com.nbagmsimulator.springmvc.service.AccountService;

@RestController
public class SignupController {

	@Autowired
	AccountService accountService; 
	private static Logger logger = LoggerFactory.getLogger(SignupController.class);

	// -------------------- Retrieve All Users ---------------------------------
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = accountService.findAllUsers();
		if (users.isEmpty())
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	// ------------------------- Retrieve A User By Id-----------------------------
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUserById(@RequestParam("id") Long id) {
		User user = accountService.findById(id);
		if (user == null) {
            logger.debug("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
        }
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
