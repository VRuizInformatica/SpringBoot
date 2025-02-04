// src/main/java/com/example/sportsevents/repository/EventoRepository.java
package com.example.sportsevents.repository;

import com.example.sportsevents.model.Evento;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EventoRepository extends JpaRepository<Evento, Long> {

    List<Evento> findByFecha(LocalDate fecha);

    @Query("SELECT e FROM Evento e JOIN e.reserva r JOIN r.instalacion i WHERE e.fecha = :fecha AND i.ubicacion = :ubicacion")
    List<Evento> findByFechaAndUbicacion(@Param("fecha") LocalDate fecha, @Param("ubicacion") String ubicacion);

    @Query("SELECT e FROM Evento e JOIN e.reserva r JOIN r.instalacion i WHERE e.fecha = :fecha AND i.tipo = :tipo")
    List<Evento> findByFechaAndTipo(@Param("fecha") LocalDate fecha, @Param("tipo") String tipo);
}
