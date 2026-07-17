package com.maboglia.storia.services;

import com.maboglia.storia.entities.Event;

import java.util.List;

public interface EventService {

    Event getEventById(Long id);
    List<Event> getEvents();

    Event updateEvent(Long id, Event event);
    Event saveEvent(Event event);
    void deleteEvent(Event event);
}
