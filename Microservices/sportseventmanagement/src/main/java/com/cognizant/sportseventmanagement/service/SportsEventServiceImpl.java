package com.cognizant.sportseventmanagement.service;

import com.cognizant.sportseventmanagement.entity.Event;
import com.cognizant.sportseventmanagement.entity.Sports;
import com.cognizant.sportseventmanagement.exception.EventGenerationException;
import com.cognizant.sportseventmanagement.exception.EventNotFoundException;
import com.cognizant.sportseventmanagement.exception.SportInsertionException;
import com.cognizant.sportseventmanagement.exception.SportNotFoundException;
import com.cognizant.sportseventmanagement.repository.EventRepository;
import com.cognizant.sportseventmanagement.repository.SportsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SportsEventServiceImpl implements SportsEventService {

    @Autowired
    private SportsRepository sportsRepository;

    @Autowired
    private EventRepository eventRepository;

    @Override
	public Sports addSport(Sports newsports) throws SportInsertionException
    {
        if(newsports.getSportsId() == null || newsports.getNoOfPlayers() <= 0  || newsports.getSportsName() == null || newsports.getSportsType() == null)
            throw new SportInsertionException("Fields cannot be empty!");

        sportsRepository.findSportBySportsId(newsports.getSportsId())
                .ifPresent(u -> {
                    throw new SportInsertionException("Sport already Exist!");
                });

        sportsRepository.findSportBySportsName(newsports.getSportsName())
                .ifPresent(u -> {
                    throw new SportInsertionException("Sport Id already Exist!");
                });

        //Sports sports = new Sports(sportsId, noOfPlayers, sportsName, sportsType);
        return sportsRepository.save(newsports);
    }

    @Override
	public List<Sports> findAllSports()
    {
        return sportsRepository.findAll();
    }

    @Override
	public Sports findSportBySportsName(String sportsName)
    {
        return sportsRepository.findSportBySportsName(sportsName).orElseThrow(() -> new SportNotFoundException("Sport named "+sportsName+" not found!"));
    }

    @Override
	public Event addEvent(Event newevent) throws EventGenerationException
    {
        if(newevent.getEventId() == null || newevent.getEventDate() == null || newevent.getEventName() == null || newevent.getNoofSlots() < 0 || newevent.getSportsName() == null)
            throw new EventGenerationException("Fields cannot be empty!");

        eventRepository.findEventByEventId(newevent.getEventId())
                .ifPresent(p -> {
                    throw new EventGenerationException("Event with Id "+newevent.getEventId()+" already Exist!");
                });

        sportsRepository.findSportBySportsName(newevent.getSportsName())
                .orElseThrow(() -> new SportNotFoundException("Event cant be generated since Sport "+newevent.getSportsName()+" doesnt exist in DB!"));

           // Event event = new Event(eventId, eventDate, eventName, noofSlots, sportsName);
            return eventRepository.save(newevent);
    }

    @Override
	public List<Event> findAllEvents()
    {
        return eventRepository.findAll();
    }

    @Override
	public Event findByEventName(String eventName)
    {
        return eventRepository.findEventByEventName(eventName).orElseThrow(() -> new EventNotFoundException("Event named "+eventName+" does not exist!"));
    }

    @Override
	public void deleteEvent(Long eventId)
    {
        Optional<Event> event = eventRepository.findEventByEventId(eventId);
        event.ifPresent(value -> eventRepository.delete(value));
        event.orElseThrow(() -> new EventNotFoundException("Event with Id "+eventId+" is not found!"));
    }

    

}
