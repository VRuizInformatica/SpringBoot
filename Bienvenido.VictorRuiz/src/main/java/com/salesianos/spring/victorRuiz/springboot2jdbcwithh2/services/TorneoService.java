package com.salesianos.spring.victorRuiz.springboot2jdbcwithh2.services;

import com.salesianos.spring.victorRuiz.springboot2jdbcwithh2.models.Ajedrecistas;
import com.salesianos.spring.victorRuiz.springboot2jdbcwithh2.models.Patrocinador;
import com.salesianos.spring.victorRuiz.springboot2jdbcwithh2.models.Torneo;
import com.salesianos.spring.victorRuiz.springboot2jdbcwithh2.repositories.TorneoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TorneoService {

    private final TorneoRepository repository;

    public TorneoService(TorneoRepository repository) {
        this.repository = repository;
    }

    public Torneo save(Torneo t) {
        return repository.save(t);
    }

    public Optional<Torneo> findById(Long id) {
        return repository.findById(id);
    }

    public List<Torneo> findAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Torneo addPatrocinador(Torneo torneo, Patrocinador patrocinador) {
        torneo.setPatrocinador(patrocinador);
        return repository.save(torneo);
    }

    public Torneo addAjedrecista(Torneo torneo, Ajedrecistas ajedrecista) {
        torneo.getAjedrecistas().add(ajedrecista);
        return repository.save(torneo);
    }

    public Torneo update(Long id, Torneo updated) {
        return repository.findById(id)
                .map(torneo -> {
                    torneo.setNombreTorneo(updated.getNombreTorneo());
                    torneo.setFechaInicio(updated.getFechaInicio());
                    return repository.save(torneo);
                })
                .orElseThrow(() -> new RuntimeException("Torneo no encontrado"));
    }
}
