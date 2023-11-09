package com.nbagmsimulator.springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nbagmsimulator.springmvc.dao.PlayerDao;
import com.nbagmsimulator.springmvc.model.Player;

@Service
public class PlayerServiceImpl implements PlayerService{

	@Autowired
	private PlayerDao playerDao;

	@Override
	public Player findById(Long id) {
		return playerDao.findById(id);
	}

	@Override
	public Player findByName(String name) {
		return playerDao.findByName(name);
	}

	@Override
	@Transactional
	public Player signPlayer(Player player) {
		if(!isPlayerExist(player)) {
			return playerDao.signNewPlayer(player);
		}
		else if(player.getTeam()!=null) {
			return playerDao.signExistingPlayer(player);
		}
		return null;
	}

	@Override
	@Transactional
	public Player releasePlayer(Long id) {
		playerDao.releasePlayer(id);
		return playerDao.findById(id);
	}

	@Override
	public List<Player> getAllPlayers() {
		return playerDao.getAllPlayers();
	}

	@Override
	@Transactional
	public List<Player> clearRoster() {
		return playerDao.clearRoster();
	}

	@Override
	public boolean isPlayerExist(Player player) {
		return findByName(player.getName())!=null;
	}

	@Override
	@Transactional
	public long deletePlayer(Long id) {
		return playerDao.deletePlayerById(id);
	}

}
