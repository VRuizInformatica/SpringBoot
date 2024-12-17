package com.salesianos.spring.victorRuiz.springboot2jdbcwithh2.services;

import com.salesianos.spring.victorRuiz.springboot2jdbcwithh2.models.Patrocinador;
import com.salesianos.spring.victorRuiz.springboot2jdbcwithh2.repositories.PatrocinadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatrocinadorService {

    private final PatrocinadorRepository repository;

    public PatrocinadorService(PatrocinadorRepository repository) {
        this.repository = repository;
    }

    public Patrocinador save(Patrocinador p) {
        return repository.save(p);
    }

    public List<Patrocinador> findAll(){
        return repository.findAll();
    }

    public Optional<Patrocinador> findById(Long id) {
        return repository.findById(id);
    }

    public Patrocinador update(Long id, Patrocinador updated) {
        return repository.findById(id)
                .map(patrocinador -> {
                    patrocinador.setNombreEmpresa(updated.getNombreEmpresa());
                    patrocinador.setPaisOrigen(updated.getPaisOrigen());
                    return repository.save(patrocinador);
                })
                .orElseThrow(() -> new RuntimeException("Patrocinador no encontrado"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
