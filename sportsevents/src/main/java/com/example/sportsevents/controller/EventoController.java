// src/main/java/com/example/sportsevents/controller/EventoController.java
package com.example.sportsevents.controller;

import com.example.sportsevents.model.Evento;
import com.example.sportsevents.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.time.LocalDate;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoRepository eventoRepository;

    // Creación de un evento
    @PostMapping
    public Evento createEvento(@RequestBody Evento evento) {
        return eventoRepository.save(evento);
    }

    // Listado de eventos disponibles con filtrado opcional
    // Ejemplos de uso:
    // - GET /eventos
    // - GET /eventos?fecha=2025-05-10
    // - GET /eventos?fecha=2025-05-10&ubicacion=Zaragoza
    // - GET /eventos?fecha=2025-05-10&tipo=pista
    @GetMapping
    public List<Evento> getEventos(@RequestParam(required = false) String fecha,
                                   @RequestParam(required = false) String ubicacion,
                                   @RequestParam(required = false) String tipo) {
        if (fecha != null) {
            LocalDate localDate = LocalDate.parse(fecha);
            if (ubicacion != null) {
                return eventoRepository.findByFechaAndUbicacion(localDate, ubicacion);
            } else if (tipo != null) {
                return eventoRepository.findByFechaAndTipo(localDate, tipo);
            } else {
                return eventoRepository.findByFecha(localDate);
            }
        }
        return eventoRepository.findAll();
    }

    // Modificación de eventos
    @PutMapping("/{id}")
    public Evento updateEvento(@PathVariable Long id, @RequestBody Evento eventoDetails) {
        Evento evento = eventoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento no encontrado"));
        evento.setNombre(eventoDetails.getNombre());
        evento.setDescripcion(eventoDetails.getDescripcion());
        evento.setFecha(eventoDetails.getFecha());
        evento.setHora(eventoDetails.getHora());
        evento.setDuracion(eventoDetails.getDuracion());
        // Nota: La actualización de participantes o la asociación de reserva se puede implementar aparte
        return eventoRepository.save(evento);
    }

    // Borrado de eventos
    @DeleteMapping("/{id}")
    public void deleteEvento(@PathVariable Long id) {
        eventoRepository.deleteById(id);
    }
}
