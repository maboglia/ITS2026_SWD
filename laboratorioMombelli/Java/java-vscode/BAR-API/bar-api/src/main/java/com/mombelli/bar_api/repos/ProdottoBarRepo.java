package com.mombelli.bar_api.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mombelli.bar_api.entities.ProdottoBar;

public interface ProdottoBarRepo extends JpaRepository<ProdottoBar, Long> {

    List<ProdottoBar> findBySezione(String sezione); 
}