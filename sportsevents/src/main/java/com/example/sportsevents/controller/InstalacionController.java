// src/main/java/com/example/sportsevents/controller/InstalacionController.java
package com.example.sportsevents.controller;

import com.example.sportsevents.model.Instalacion;
import com.example.sportsevents.repository.InstalacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.time.LocalDate;

@RestController
@RequestMapping("/instalaciones")
public class InstalacionController {

    @Autowired
    private InstalacionRepository instalacionRepository;

    // Registro de una nueva instalación
    @PostMapping
    public Instalacion createInstalacion(@RequestBody Instalacion instalacion) {
        return instalacionRepository.save(instalacion);
    }

    // Listado de instalaciones
    @GetMapping
    public List<Instalacion> getInstalaciones() {
        return instalacionRepository.findAll();
    }

    // Eliminación de una instalación
    @DeleteMapping("/{id}")
    public void deleteInstalacion(@PathVariable Long id) {
        instalacionRepository.deleteById(id);
    }

    // Consulta: Listar instalaciones disponibles en una fecha específica.
    // Ejemplo: GET /instalaciones/disponibles?fecha=2025-05-10
    @GetMapping("/disponibles")
    public List<Instalacion> getInstalacionesDisponibles(@RequestParam String fecha) {
        LocalDate localDate = LocalDate.parse(fecha);
        return instalacionRepository.findAvailableOnDate(localDate);
    }
}
