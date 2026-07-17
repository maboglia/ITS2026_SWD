package com.maboglia.storia.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maboglia.storia.entities.Event;
import com.maboglia.storia.services.EventService;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("")
public class EventMVC {

    private final EventService eventService;

    public EventMVC(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("")
    public String home(Model model, @RequestParam(required = false) Long id) {
        model.addAttribute("title", "Eventi storici");
        model.addAttribute("events", eventService.getEvents());
        return "home";
    }

    @GetMapping("/events")
    public String events(Model model, @RequestParam(required = false) Long id) {
        model.addAttribute("title", "Eventi storici");
        model.addAttribute("events", eventService.getEvents());
        return "events";
    }

    @GetMapping("/quiz")
    public String quiz(Model model, @RequestParam(required = false) Long id) {
        model.addAttribute("title", "Quiz");
        List<Event> events = eventService.getEvents()
                .stream()
                .sorted((e1, e2) -> Double.compare(Math.random(), Math.random()))
                .limit(3)
                .toList();
        model.addAttribute("question", events.get(0));
        List<Integer> answers = new ArrayList<>(events.stream().map(e -> e.getAnno()).toList());
        Collections.shuffle(answers);
        model.addAttribute("answers", answers); 
        model.addAttribute("events", events);
        return "quiz";
    }
    

}
