package com.salesianos.spring.victorRuiz.springboot2jdbcwithh2.repositories;

import com.salesianos.spring.victorRuiz.springboot2jdbcwithh2.models.Ajedrecistas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AjedrezRepository extends JpaRepository<Ajedrecistas, Long> {
}
