package com.nbagmsimulator.springmvc.dao;

import java.util.List;

import com.nbagmsimulator.springmvc.api.model.Player;


public interface PlayerDao {

	Player findById(long id);

	Player findByName(String name);

	Player signNewPlayer(Player player);

	Player signExistingPlayer(Player player);

	long releasePlayer(long id);

	long deletePlayerById(long id);

	List<Player> getAllPlayers(); 

	List<Player> clearRoster();

	boolean isPlayerExist(Player player);

}
