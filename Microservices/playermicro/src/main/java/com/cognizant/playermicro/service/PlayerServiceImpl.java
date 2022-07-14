package com.cognizant.playermicro.service;

import java.util.Optional;
import java.util.List;

import com.cognizant.playermicro.exception.PlayerAdditionException;
import com.cognizant.playermicro.exception.PlayerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.playermicro.entity.Player;
import com.cognizant.playermicro.repository.PlayerRepository;

//import antlr.collections.List;
import java.util.*;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerRepository playerRepository;

	@Override
	public Player addPlayer(Player newplayer) {

		if (newplayer.getPlayerId() == null || newplayer.getPlayerName() == null || newplayer.getAge() <= 0
				|| newplayer.getContactNumber() <= 100000000 || newplayer.getEmail() == null
				|| newplayer.getGender() == null || newplayer.getSportsName() == null)
			throw new PlayerAdditionException(" Fields Cannot be empty!!");

		playerRepository.findPlayerByPlayerId(newplayer.getPlayerId()).ifPresent(u -> {
			throw new PlayerAdditionException("Player with id: " + newplayer.getPlayerId() + " already exists!");
		});

		// Player player=new Player( playerId, playerName, age, contactNumber, email,
		// gender,sportsName);
		return playerRepository.save(newplayer);

	}

	@Override
	public void deletePlayer(Long playerId) {
		Optional<Player> player = playerRepository.findPlayerByPlayerId(playerId);
		player.ifPresent(value -> playerRepository.delete(value));
		player.orElseThrow(() -> new PlayerNotFoundException("Event with Id " + playerId + " is not found!"));
	}

	@Override
	public List<Player> findAllPlayer() {
		return playerRepository.findAll();
	}

}
