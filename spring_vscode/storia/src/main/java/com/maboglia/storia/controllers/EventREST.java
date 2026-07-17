package com.maboglia.storia.controllers;

import com.maboglia.storia.entities.Event;
import com.maboglia.storia.services.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventREST {

    private final EventService eventService;

    public EventREST(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("")
    public ResponseEntity<List<Event>> getEvents() {
        List<Event> events = eventService.getEvents();
        return ResponseEntity.ok(events);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEvent(@PathVariable Long id) {
        Event event = eventService.getEventById(id);
        return ResponseEntity.ok(event);
    }

    @PostMapping("")
    public ResponseEntity<Event> postMethodName(Event entity){
        Event createdEvent = eventService.saveEvent(entity);
        return ResponseEntity.status(201).body(createdEvent);

    }

    @PostMapping("/multiple")
    public ResponseEntity<List<Event>> postMethodName(List<Event> entities){
        // Assuming you want to save  events in the list
        entities.forEach(eventService::saveEvent);
        return ResponseEntity.status(201).body(entities);
    }

}
