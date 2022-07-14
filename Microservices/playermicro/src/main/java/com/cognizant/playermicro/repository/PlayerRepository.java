package com.cognizant.playermicro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.playermicro.entity.Player;

public interface PlayerRepository  extends JpaRepository<Player, Long>{

	 Optional<Player> findPlayerByPlayerId(Long playerId);
	    Optional<Player> findPlayerByPlayerName(String playerName);

}
