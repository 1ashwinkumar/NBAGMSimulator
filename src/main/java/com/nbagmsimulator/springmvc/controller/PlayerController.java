package com.nbagmsimulator.springmvc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nbagmsimulator.springmvc.model.Player;
import com.nbagmsimulator.springmvc.service.PlayerService;

@RequestMapping(value="/players")
@RestController
public class PlayerController {
	@Autowired
	private PlayerService playerService;

	private static Logger logger = LoggerFactory.getLogger(PlayerController.class);



	// -------------------Retrieve All Players------

	@RequestMapping(value = "/all", method=RequestMethod.GET)
	public ResponseEntity<?> getPlayers() {
		List<Player> players = playerService.getAllPlayers();
		if (players.isEmpty()) {
			return new ResponseEntity<List<Player>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Player>>(players, HttpStatus.OK);
	}

	// -------------------Retrieve One Player------

	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> getPlayer(@PathVariable("id") Long id) {
		if (playerService.getAllPlayers().isEmpty()) {
			return new ResponseEntity<Player>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Player>(playerService.findById(id), HttpStatus.OK);
	}

	// -------------------Delete All Players------

	@RequestMapping(value = "/all", method=RequestMethod.DELETE)
	public ResponseEntity<List<Player>> deletePlayers() {
		return new ResponseEntity<List<Player>>(playerService.clearRoster(), HttpStatus.OK);
	}

	// -------------------Delete One Player------

	@RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deletePlayer(@PathVariable("id") Long id) {
		return new ResponseEntity<Long>(playerService.deletePlayer(id), HttpStatus.OK);
	}
	
	// ----- Create Player and Sign to a team -------
	
	@RequestMapping(value = "/", method=RequestMethod.POST)
	public ResponseEntity<?> createAndSignNewPlayer(@RequestBody Player player) {
		if (playerService.findById(player.getId())==null) {
			return new ResponseEntity<Player>(playerService.signPlayer(player), HttpStatus.OK);
		}
		return new ResponseEntity<Player>(HttpStatus.BAD_REQUEST);
	}

	// ------ Sign Existing Player -------
	
	@RequestMapping(value = "/", method=RequestMethod.PUT)
	public ResponseEntity<?> signExistingPlayer(@RequestBody Player player) {
		if (playerService.findById(player.getId())!=null) {
			return new ResponseEntity<Player>(playerService.signPlayer(player), HttpStatus.OK);
		}
		return new ResponseEntity<Player>(HttpStatus.BAD_REQUEST);
	}

	
	// ----- Release Player ----
	@RequestMapping(value = "/{id}", method=RequestMethod.PUT)
	public ResponseEntity<?> releasePlayer(@PathVariable("id") Long id) {
		return new ResponseEntity<Player>(playerService.releasePlayer(id), HttpStatus.OK);
	}

}
