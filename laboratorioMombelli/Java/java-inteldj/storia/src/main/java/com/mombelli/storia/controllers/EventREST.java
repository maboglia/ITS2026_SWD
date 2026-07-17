package com.mombelli.storia.controllers;

import com.mombelli.storia.entities.Event;
import com.mombelli.storia.services.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventREST {

    private final EventService eventService;

    public EventREST(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("")
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Event>> getAllEvents(@PathVariable Long id) {
        List<Event> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }

    @PostMapping("")
    public ResponseEntity<Event> postMethodName(Event entity){
        Event createdEvent = eventService.saveEvent(entity);
        return ResponseEntity.status(201).body(createdEvent);

    }

    @PostMapping("/multiple")
    public ResponseEntity<List<Event>> postMethodName(List<Event> entities){
        // Assuming you want to save all events in the list
        entities.forEach(eventService::saveEvent);
        return ResponseEntity.status(201).body(entities);
    }

}
