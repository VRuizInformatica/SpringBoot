package com.salesianos.spring.victorRuiz.springboot2jdbcwithh2.controllers;

import com.salesianos.spring.victorRuiz.springboot2jdbcwithh2.models.Ajedrecistas;
import com.salesianos.spring.victorRuiz.springboot2jdbcwithh2.services.AjedrezService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ajedrecistas")
public class AjedrezController {

    @Autowired
    private AjedrezService service;

    // Obtener todos los ajedrecistas
    @GetMapping
    public ResponseEntity<List<Ajedrecistas>> getAll() {
        List<Ajedrecistas> ajedrecistas = service.findAll();
        if (ajedrecistas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ajedrecistas);
    }

    // Obtener un ajedrecista por ID
    @GetMapping("/{id}")
    public ResponseEntity<Ajedrecistas> getById(@PathVariable Long id) {
        Ajedrecistas ajedrecista = service.findById(id);
        if (ajedrecista == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ajedrecista);
    }

    // Crear un nuevo ajedrecista
    @PostMapping
    public ResponseEntity<Ajedrecistas> create(@RequestBody Ajedrecistas ajedrecista) {
        if (ajedrecista.getName() == null || ajedrecista.getName().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        Ajedrecistas newAjedrecista = service.save(ajedrecista);
        return ResponseEntity.ok(newAjedrecista);
    }

    // Actualizar un ajedrecista existente
    @PutMapping("/{id}")
    public ResponseEntity<Ajedrecistas> update(@PathVariable Long id, @RequestBody Ajedrecistas ajedrecista) {
        if (service.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        ajedrecista.    setId(id);
        Ajedrecistas updatedAjedrecista = service.save(ajedrecista);
        return ResponseEntity.ok(updatedAjedrecista);
    }

    // Eliminar un ajedrecista por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

/*
1. Obtener Todos los Ajedrecistas
Invoke-WebRequest -Uri "http://localhost:8080/ajedrecistas" -Method GET


Devuelve la lista completa de ajedrecistas.

2. Obtener un Ajedrecista por ID
Invoke-WebRequest -Uri "http://localhost:8080/ajedrecistas/1" -Method GET


Devuelve los detalles del ajedrecista con el ID especificado.

3. Crear un Nuevo Ajedrecista
Invoke-WebRequest -Uri "http://localhost:8080/ajedrecistas" `
  -Method POST `
  -Body '{"name": "Magnus Carlsen", "victorias": 100, "derrotas": 10}' `
  -ContentType "application/json"


Crea un nuevo ajedrecista con los datos proporcionados en el cuerpo de la solicitud.

4. Actualizar un Ajedrecista Existente
Invoke-WebRequest -Uri "http://localhost:8080/ajedrecistas/1" `
  -Method PUT `
  -Body '{"name": "Magnus Updated", "victorias": 120, "derrotas": 5}' `
  -ContentType "application/json"

Actualiza los datos del ajedrecista con el ID especificado.


5. Eliminar un Ajedrecista por ID
Invoke-WebRequest -Uri "http://localhost:8080/ajedrecistas/1" -Method DELETE


Elimina el ajedrecista con el ID especificado.

 */
