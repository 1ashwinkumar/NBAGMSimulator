package com.nbagmsimulator.springmvc.service;

import java.util.List;

import com.nbagmsimulator.springmvc.model.Player;

public interface PlayerService {
	
	Player findById(Long id);
	
	Player findByName(String name);
	
	Player signPlayer(Player player);

	Player releasePlayer(Long id);
	
	long deletePlayer(Long id);

	List<Player> getAllPlayers(); 

	List<Player> clearRoster();

	boolean isPlayerExist(Player player);

}
