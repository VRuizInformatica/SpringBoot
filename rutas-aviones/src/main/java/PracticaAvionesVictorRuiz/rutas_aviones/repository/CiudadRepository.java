package PracticaAvionesVictorRuiz.rutas_aviones.repository;

import PracticaAvionesVictorRuiz.rutas_aviones.model.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiudadRepository extends JpaRepository<Ciudad, Integer> {
    // JpaRepository ya incluye métodos como findAll(), findById(), save(), deleteById(), etc.
}
