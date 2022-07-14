package com.cognizant.participation.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Participation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long participationId;

    @Column(nullable = false, updatable = false)
    private Long playerId;
    private String playerName;

    @Column(nullable = false, updatable = false)
    private Long eventId;

    private String eventName;

    @Column(nullable = false, updatable = false)
    private Long sportsId;

    private String sportsName;
    private String status;

    public Participation() {
    }

    public Participation(Long playerId, String playerName, Long eventId, String eventName, Long sportsId, String sportsName, String status) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.eventId = eventId;
        this.eventName = eventName;
        this.sportsId = sportsId;
        this.sportsName = sportsName;
        this.status = status;
    }

    public Long getParticipationId() {
        return participationId;
    }

    public void setParticipationId(Long participationId) {
        this.participationId = participationId;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Long getSportsId() {
        return sportsId;
    }

    public void setSportsId(Long sportsId) {
        this.sportsId = sportsId;
    }

    public String getSportsName() {
        return sportsName;
    }

    public void setSportsName(String sportsName) {
        this.sportsName = sportsName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
