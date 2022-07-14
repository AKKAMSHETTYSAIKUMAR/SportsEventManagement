package com.cognizant.playermicro.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.playermicro.entity.Player;
import com.cognizant.playermicro.service.PlayerService;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("api/v1/Player")
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@PostMapping("/addPlayer")

	public ResponseEntity<Player> addPlayer(@RequestBody Player newplayer) {

		/*
		 * String playerId = (String) playerMap.get("playerId"); String playerName =
		 * (String) playerMap.get("playerName"); String age = (String)
		 * (playerMap.get("age")); String contactNumber = (String)
		 * playerMap.get("contactNumber"); String email = (String)
		 * playerMap.get("email"); String gender = (String) playerMap.get("gender");
		 * String sportsName = (String) playerMap.get("sportsName");
		 */
		Player player = playerService.addPlayer(newplayer);
		return new ResponseEntity<>(player, HttpStatus.OK);
	}

	private Map<String, String> playerAddedSuccessfully(Player player) {
		Map<String, String> map = new HashMap<>();

		map.put("message", "Player Added Successfully");
		map.put("playerId", player.getPlayerId().toString());
		//map.put("age", player.getAge());
		map.put("contactNumber", player.getContactNumber().toString());
		map.put("email", player.getEmail());
		map.put("sportName", player.getSportsName());

		return map;
	}
	@DeleteMapping("/deleteplayer/{playerId}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable("playerId") String playerId)
    {
		 playerService.deletePlayer(Long.parseLong(playerId));
        return new ResponseEntity<>(playerDeletedSuccessfully(playerId),HttpStatus.OK);
    }
	 private Map<String, String> playerDeletedSuccessfully(String playerId)
	    {
	        Map<String, String> map = new HashMap<>();

	        map.put("message", "Event with Id "+playerId+" is deleted Successsfully!");
	        return map;
	    }
	 @GetMapping("/viewAllPlayers")
	    public ResponseEntity<List<Player>> viewAllSports()
	    {
	        List<Player> player = playerService.findAllPlayer();
	        return new ResponseEntity<>(player, HttpStatus.OK);
	    }
}
