package com.maboglia.storia.repos;

import com.maboglia.storia.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepo extends JpaRepository<Event, Long> {
}
