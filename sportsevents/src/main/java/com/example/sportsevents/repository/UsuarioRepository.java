// src/main/java/com/example/sportsevents/repository/UsuarioRepository.java
package com.example.sportsevents.repository;

import com.example.sportsevents.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
