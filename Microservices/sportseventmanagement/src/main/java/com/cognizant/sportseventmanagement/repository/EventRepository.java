package com.cognizant.sportseventmanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.sportseventmanagement.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

    Optional<Event> findEventByEventId(Long eventId);
    Optional<Event> findEventByEventName(String eventName);
}
