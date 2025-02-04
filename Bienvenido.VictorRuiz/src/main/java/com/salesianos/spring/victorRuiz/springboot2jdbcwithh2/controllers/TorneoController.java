package com.salesianos.spring.victorRuiz.springboot2jdbcwithh2.controllers;

import com.salesianos.spring.victorRuiz.springboot2jdbcwithh2.models.Ajedrecistas;
import com.salesianos.spring.victorRuiz.springboot2jdbcwithh2.models.Patrocinador;
import com.salesianos.spring.victorRuiz.springboot2jdbcwithh2.models.Torneo;
import com.salesianos.spring.victorRuiz.springboot2jdbcwithh2.services.AjedrecistasService;
import com.salesianos.spring.victorRuiz.springboot2jdbcwithh2.services.PatrocinadorService;
import com.salesianos.spring.victorRuiz.springboot2jdbcwithh2.services.TorneoService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/torneos")
public class TorneoController {

    private final TorneoService torneoService;
    private final PatrocinadorService patrocinadorService;
    private final AjedrecistasService ajedrecistasService;

    public TorneoController(TorneoService torneoService,
                            PatrocinadorService patrocinadorService,
                            AjedrecistasService ajedrecistasService) {
        this.torneoService = torneoService;
        this.patrocinadorService = patrocinadorService;
        this.ajedrecistasService = ajedrecistasService;
    }

    @GetMapping
    public List<Torneo> getAllTorneos() {
        return torneoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Torneo> findOne(@PathVariable Long id) {
        return torneoService.findById(id);
    }

    @PostMapping
    public Torneo createTorneo(@RequestBody Torneo torneo) {
        return torneoService.save(torneo);
    }

    @PutMapping("/{id}")
    public Torneo update(@PathVariable Long id, @RequestBody Torneo updated) {
        return torneoService.update(id, updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        torneoService.delete(id);
    }

    @PostMapping("/{torneoId}/patrocinador/{patrocinadorId}")
    public Torneo addPatrocinadorToTorneo(@PathVariable Long torneoId, @PathVariable Long patrocinadorId) {
        Torneo t = torneoService.findById(torneoId)
                .orElseThrow(() -> new RuntimeException("Torneo no encontrado"));
        Patrocinador p = patrocinadorService.findById(patrocinadorId)
                .orElseThrow(() -> new RuntimeException("Patrocinador no encontrado"));
        return torneoService.addPatrocinador(t, p);
    }

    @PostMapping("/{torneoId}/ajedrecista/{ajedrecistaId}")
    public Torneo addAjedrecistaToTorneo(@PathVariable Long torneoId, @PathVariable Long ajedrecistaId) {
        Torneo t = torneoService.findById(torneoId)
                .orElseThrow(() -> new RuntimeException("Torneo no encontrado"));
        Ajedrecistas a = ajedrecistasService.findById(ajedrecistaId)
                .orElseThrow(() -> new RuntimeException("Ajedrecista no encontrado"));
        return torneoService.addAjedrecista(t, a);
    }

    @PostMapping("/initData")
    public String initData() {
        Patrocinador p = new Patrocinador("Empresa X", "España");
        p = patrocinadorService.save(p);

        Torneo t = new Torneo("Open de Madrid", LocalDate.of(2024,5,10));
        t = torneoService.save(t);
        torneoService.addPatrocinador(t, p);

        Ajedrecistas a1 = new Ajedrecistas("Magnus Carlsen", "Noruega");
        Ajedrecistas a2 = new Ajedrecistas("Hikaru Nakamura", "EEUU");
        a1 = ajedrecistasService.save(a1);
        a2 = ajedrecistasService.save(a2);

        torneoService.addAjedrecista(t, a1);
        torneoService.addAjedrecista(t, a2);

        return "Datos iniciales creados";
    }
}
