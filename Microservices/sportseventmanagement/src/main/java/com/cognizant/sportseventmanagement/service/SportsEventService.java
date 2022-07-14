package com.cognizant.sportseventmanagement.service;

import java.util.List;

import com.cognizant.sportseventmanagement.entity.Event;
import com.cognizant.sportseventmanagement.entity.Sports;
import com.cognizant.sportseventmanagement.exception.EventGenerationException;
import com.cognizant.sportseventmanagement.exception.SportInsertionException;

public interface SportsEventService {

	Sports addSport(Sports newsports) throws SportInsertionException;

	List<Sports> findAllSports();

	Sports findSportBySportsName(String sportsName);

	Event addEvent(Event newevent) throws EventGenerationException;

	List<Event> findAllEvents();

	Event findByEventName(String eventName);

	void deleteEvent(Long eventId);

}