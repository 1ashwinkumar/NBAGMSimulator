package com.nbagmsimulator.springmvc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.nbagmsimulator.springmvc.model.Player;

@Service
public class PlayerServiceImpl implements PlayerService{

	private static final AtomicLong counter = new AtomicLong();

	private static List<Player> players;

	static{
		players=populateDummyPlayers();
	}

	@Override
	public Player findById(long id) {
		for(Player player: players)
			if(player.getId() == id)
				return player;
		return null;
	}

	@Override
	public Player findByName(String name) {
		for(Player player: players)
			if(player.getName() == name)
				return player;
		return null;
	}

	@Override
	public Player signPlayer(Player player) {
		if(!isPlayerExist(player) || player.getTeam()==null) {
			player.setId(counter.incrementAndGet());
			players.add(player);
			return player;
		}
		return null;
	}

	@Override
	public Player releasePlayer(long id) {
		if(findById(id)!=null) {
			Player temp=findById(id);
			players.remove(temp);
			temp.setTeam(null);
			players.add(temp);
			return temp;
		}
		return null;
	}

	@Override
	public List<Player> getAllPlayers() {
		return players;
	}

	@Override
	public List<Player> clearRoster() {
		players.clear();
		return players;
	}

	@Override
	public boolean isPlayerExist(Player player) {
		return findByName(player.getName())!=null;
	}

	private static List<Player> populateDummyPlayers(){
		List<Player> values = new ArrayList<Player>();
		values.add(new Player(counter.incrementAndGet(), "Kevin Durant", "SF", "Suns", 35, 4, 45, new double[] {29.1, 7.4, 1.4, 0.7, 5, 3.3}));
		values.add(new Player(counter.incrementAndGet(), "Devin Booker", "SG", "Suns", 27, 1, 32, new double[] {27.8, 4.5, 0.3, 1, 5.5, 2.7}));
		values.add(new Player(counter.incrementAndGet(), "Joel Embiid", "C", "76ers", 29, 5, 35, new double[] {30.6, 11.7, 1.5, 1.1, 4.2, 3.1}));
		return values;
	}

}
