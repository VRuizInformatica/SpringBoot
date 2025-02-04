package com.salesianos.spring.victorRuiz.springboot2jdbcwithh2.controllers;

import com.salesianos.spring.victorRuiz.springboot2jdbcwithh2.models.Ajedrecistas;
import com.salesianos.spring.victorRuiz.springboot2jdbcwithh2.services.AjedrecistasService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ajedrecistas")
public class AjedrecistasController {

    private final AjedrecistasService service;

    public AjedrecistasController(AjedrecistasService service) {
        this.service = service;
    }
    
    @GetMapping
    public List<Ajedrecistas> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Ajedrecistas> findOne(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Ajedrecistas create(@RequestBody Ajedrecistas ajedrecista) {
        return service.save(ajedrecista);
    }

    @PutMapping("/{id}")
    public Ajedrecistas update(@PathVariable Long id, @RequestBody Ajedrecistas updated) {
        return service.update(id, updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
