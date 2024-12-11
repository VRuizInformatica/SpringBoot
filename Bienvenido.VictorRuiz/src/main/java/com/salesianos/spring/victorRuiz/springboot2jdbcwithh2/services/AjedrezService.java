package com.salesianos.spring.victorRuiz.springboot2jdbcwithh2.services;

import com.salesianos.spring.victorRuiz.springboot2jdbcwithh2.models.Ajedrecistas;
import com.salesianos.spring.victorRuiz.springboot2jdbcwithh2.repositories.AjedrezRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AjedrezService {

    @Autowired
    private AjedrezRepository repository;

    // Obtener todos los ajedrecistas
    public List<Ajedrecistas> findAll() {
        return repository.findAll();
    }

    // Obtener un ajedrecista por ID
    public Ajedrecistas findById(Long id) {
        Optional<Ajedrecistas> ajedrecista = repository.findById(id);
        return ajedrecista.orElse(null);
    }

    // Guardar un nuevo ajedrecista o actualizar uno existente
    public Ajedrecistas save(Ajedrecistas ajedrecista) {
        return repository.save(ajedrecista);
    }

    // Eliminar un ajedrecista por ID
    public void deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new IllegalArgumentException("El ajedrecista con ID " + id + " no existe.");
        }
    }
}
