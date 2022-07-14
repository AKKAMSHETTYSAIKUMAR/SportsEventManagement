package com.cognizant.playermicro.service;

import java.util.List;

import com.cognizant.playermicro.entity.Player;

public interface PlayerService {

	Player addPlayer(Player newplayer);

	void deletePlayer(Long playerId);

	List<Player> findAllPlayer();

}