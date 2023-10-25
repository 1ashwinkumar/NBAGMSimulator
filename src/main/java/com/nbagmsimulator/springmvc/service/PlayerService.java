package com.nbagmsimulator.springmvc.service;

import java.util.List;

import com.nbagmsimulator.springmvc.model.Player;

public interface PlayerService {
	
	Player findById(long id);
	
	Player findByName(String name);
	
	Player signPlayer(Player player);

	Player releasePlayer(long id);

	List<Player> getAllPlayers(); 

	List<Player> clearRoster();

	boolean isPlayerExist(Player player);

}
