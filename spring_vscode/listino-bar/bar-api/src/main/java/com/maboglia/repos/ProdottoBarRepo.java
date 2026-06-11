package com.maboglia.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maboglia.entities.ProdottoBar;

public interface ProdottoBarRepo extends JpaRepository<ProdottoBar, Long> {

    List<ProdottoBar> findBySezione(String sezione);

}
