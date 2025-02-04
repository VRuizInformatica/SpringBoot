package com.salesianos.spring.victorRuiz.springboot2jdbcwithh2.services;

import com.salesianos.spring.victorRuiz.springboot2jdbcwithh2.models.Ajedrecistas;
import com.salesianos.spring.victorRuiz.springboot2jdbcwithh2.repositories.AjedrecistasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AjedrecistasService {

    private final AjedrecistasRepository repository;

    public AjedrecistasService(AjedrecistasRepository repository) {
        this.repository = repository;
    }

    public Ajedrecistas save(Ajedrecistas a) {
        return repository.save(a);
    }

    public List<Ajedrecistas> findAll() {
        return repository.findAll();
    }

    public Optional<Ajedrecistas> findById(Long id) {
        return repository.findById(id);
    }

    public Ajedrecistas update(Long id, Ajedrecistas updated) {
        return repository.findById(id)
                .map(ajedrecista -> {
                    ajedrecista.setNombre(updated.getNombre());
                    ajedrecista.setNacionalidad(updated.getNacionalidad());
                    return repository.save(ajedrecista);
                })
                .orElseThrow(() -> new RuntimeException("Ajedrecista no encontrado"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
