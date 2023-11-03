package com.nbagmsimulator.springmvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.nbagmsimulator.springmvc.model.Player;

public class PlayerDaoImpl implements PlayerDao{
	
	@Autowired
    SessionFactory sessionFactory;

    @Autowired
    HibernateTemplate hibernateTemplate;

	@Override
	public Player findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player signNewPlayer(Player player) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player signExistingPlayer(Player player) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long releasePlayer(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long deletePlayerById(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Player> getAllPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> clearRoster() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPlayerExist(Player player) {
		// TODO Auto-generated method stub
		return false;
	}

}
