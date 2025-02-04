package com.salesianos.spring.victorRuiz.springboot2jdbcwithh2.repositories;

import com.salesianos.spring.victorRuiz.springboot2jdbcwithh2.models.Ajedrecistas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AjedrecistasRepository extends JpaRepository<Ajedrecistas, Long> {
}
