package com.salesianos.spring.victorRuiz.springboot2jdbcwithh2.repositories;

import com.salesianos.spring.victorRuiz.springboot2jdbcwithh2.models.Torneo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TorneoRepository extends JpaRepository<Torneo, Long> {
}
