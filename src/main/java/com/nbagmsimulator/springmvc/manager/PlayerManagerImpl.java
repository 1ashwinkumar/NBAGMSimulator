package com.nbagmsimulator.springmvc.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.ImmutableList;
import com.nbagmsimulator.springmvc.api.manager.PlayerManager;
import com.nbagmsimulator.springmvc.api.model.Player;
import com.nbagmsimulator.springmvc.model.PlayerImpl;
import com.nbagmsimulator.springmvc.service.PlayerService;
import com.nbagmsimulator.springmvc.view.PlayerView;

@Service
public class PlayerManagerImpl implements PlayerManager{
	@Autowired
	private PlayerService playerService;
	
	public PlayerView convertToView(PlayerImpl playerImpl) {
		PlayerView playerView = new PlayerView();
		BeanUtils.copyProperties(playerImpl, playerView);
		return playerView;
	}

	@Override
	public Player findById(Long id) {
		Player playerImpl = playerService.findById(id);
        return playerImpl;
	}

	@Override
	public Player findByName(String name) {
		Player playerImpl = playerService.findByName(name);
        return playerImpl;
	}

	@Override
	public Player signPlayer(Player player) {
		return playerService.signPlayer(player);
	}

	@Override
	public Player releasePlayer(Long id) {
		return playerService.releasePlayer(id);
	}

	@Override
	public long deletePlayer(Long id) {
		return playerService.deletePlayer(id);
	}

	@Override
	public List<Player> getAllPlayers() {
		List<Player> playerList = playerService.getAllPlayers();
		List<PlayerView> playerViewList = new ArrayList<PlayerView>();
		for (Player player : playerList) {
			playerViewList.add(PlayerView.convert(player));
		}
		return ImmutableList.copyOf(playerViewList);
	}

	@Override
	public List<Player> clearRoster() {
		return playerService.clearRoster();
	}

	@Override
	public boolean isPlayerExist(Player player) {
		return playerService.isPlayerExist(player);
	}

}
