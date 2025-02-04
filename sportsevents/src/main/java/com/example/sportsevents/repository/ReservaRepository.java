// src/main/java/com/example/sportsevents/repository/ReservaRepository.java
package com.example.sportsevents.repository;

import com.example.sportsevents.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    // Lista las reservas para una instalación dada (utilizando el id de la instalación)
    List<Reserva> findByInstalacion_Id(Long instalacionId);

    List<Reserva> findByFecha(LocalDate fecha);
}
