// src/main/java/com/example/sportsevents/repository/InstalacionRepository.java
package com.example.sportsevents.repository;

import com.example.sportsevents.model.Instalacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface InstalacionRepository extends JpaRepository<Instalacion, Long> {

    @Query("SELECT i FROM Instalacion i WHERE i.id NOT IN (SELECT r.instalacion.id FROM Reserva r WHERE r.fecha = :fecha)")
    List<Instalacion> findAvailableOnDate(@Param("fecha") LocalDate fecha);
}
