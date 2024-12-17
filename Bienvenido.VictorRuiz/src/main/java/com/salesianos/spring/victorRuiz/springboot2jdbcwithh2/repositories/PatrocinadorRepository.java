package com.salesianos.spring.victorRuiz.springboot2jdbcwithh2.repositories;

import com.salesianos.spring.victorRuiz.springboot2jdbcwithh2.models.Patrocinador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatrocinadorRepository extends JpaRepository<Patrocinador, Long> {
}
