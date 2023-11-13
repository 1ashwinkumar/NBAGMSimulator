package com.nbagmsimulator.springmvc.api.manager;

import java.util.List;

import com.nbagmsimulator.springmvc.api.model.Player;

public interface PlayerManager {
	Player findById(Long id);

	Player findByName(String name);

	Player signPlayer(Player player);

	Player releasePlayer(Long id);

	long deletePlayer(Long id);

	List<Player> getAllPlayers(); 

	List<Player> clearRoster();

	boolean isPlayerExist(Player player);
}
