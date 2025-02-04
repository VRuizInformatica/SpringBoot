package com.salesianos.spring.victorRuiz.springboot2jdbcwithh2.controllers;

import com.salesianos.spring.victorRuiz.springboot2jdbcwithh2.models.Patrocinador;
import com.salesianos.spring.victorRuiz.springboot2jdbcwithh2.services.PatrocinadorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patrocinadores")
public class PatrocinadorController {

    private final PatrocinadorService service;

    public PatrocinadorController(PatrocinadorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Patrocinador> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Patrocinador> findOne(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Patrocinador create(@RequestBody Patrocinador patrocinador) {
        return service.save(patrocinador);
    }

    @PutMapping("/{id}")
    public Patrocinador update(@PathVariable Long id, @RequestBody Patrocinador updated) {
        return service.update(id, updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
