package com.mombelli.storia.services;

import com.mombelli.storia.entities.Event;
import com.mombelli.storia.repos.EventRepo;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService{

    private final EventRepo eventRepo;

    public EventServiceImpl(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }


    @Override
    public Event getEventById(Long id) {
        return eventRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with id " + id));
    }

    @Override
    public Event updateEvent(Long id, Event event) {
        return eventRepo.findById(id)
                .map(existingEvent -> {
                    existingEvent.setId(event.getId());
                    return eventRepo.save(existingEvent);
                })
                .orElseThrow(() -> new RuntimeException("Event not found with id " + id));
    }

    @Override
    public Event saveEvent(Event event) {
        return eventRepo.save(event);
    }

    @Override
    public void deleteEvent(Event event) {


    }
}
