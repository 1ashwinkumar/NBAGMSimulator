package com.nbagmsimulator.springmvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.nbagmsimulator.springmvc.service.PlayerService;

@RestController
public class PlayerController {
	@Autowired
    private PlayerService playerService;

    private static Logger logger = LoggerFactory.getLogger(PlayerController.class);

}
