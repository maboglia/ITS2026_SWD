package com.mombelli.storia.services;

import com.mombelli.storia.entities.Event;

import java.util.List;

public interface EventService {

    Event getEventById(Long id);
    Event updateEvent(Long id, Event event);
    Event saveEvent(Event event);
    void deleteEvent(Event event);
    List<Event> getEventById(Long id);
}
