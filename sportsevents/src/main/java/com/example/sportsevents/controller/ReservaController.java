// src/main/java/com/example/sportsevents/controller/ReservaController.java
package com.example.sportsevents.controller;

import com.example.sportsevents.model.Reserva;
import com.example.sportsevents.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    // Creación de una reserva
    @PostMapping
    public Reserva createReserva(@RequestBody Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    // Listado de reservas por instalación (usando el id de la instalación)
    @GetMapping("/instalacion/{id}")
    public List<Reserva> getReservasByInstalacion(@PathVariable Long id) {
        return reservaRepository.findByInstalacion_Id(id);
    }

    // Eliminación de una reserva
    @DeleteMapping("/{id}")
    public void deleteReserva(@PathVariable Long id) {
        reservaRepository.deleteById(id);
    }
}
