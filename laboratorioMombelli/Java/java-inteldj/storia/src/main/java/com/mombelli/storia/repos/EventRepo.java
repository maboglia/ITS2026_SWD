package com.mombelli.storia.repos;

import com.mombelli.storia.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepo extends JpaRepository<Event, Long> {
}
