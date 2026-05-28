package com.mombelli.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mombelli.entities.Automobile;

@Repository
public interface AutomobiliRepo extends JpaRepository<Automobile, Integer> {

}
