package com.cognizant.playermicro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Player {

	@Id
	@Column(nullable = false, updatable = false)
	private Long playerId;
	@Column(nullable = false, updatable = false)
	private String sportsName;
	private String playerName;
	private int age;
	
	private Long contactNumber;
	private String email;
	private String gender;

	public Player() {

	}

	public Player(Long playerId,  String playerName, int age, Long contactNumber, String email,
			String gender,String sportsName) {
		super();
		this.playerId = playerId;
		this.sportsName = sportsName;
		this.playerName = playerName;
		this.age = age;
		this.contactNumber = contactNumber;
		this.email = email;
		this.gender = gender;
	}

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getSportsName() {
		return sportsName;
	}

	public void setSportsName(String sportsName) {
		this.sportsName = sportsName;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", sportsName=" + sportsName + ", playerName=" + playerName + ", age="
				+ age + ", contactNumber=" + contactNumber + ", email=" + email + ", gender=" + gender + "]";
	}


}