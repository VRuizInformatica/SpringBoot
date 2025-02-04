package PracticaAvionesVictorRuiz.rutas_aviones.repository;

import PracticaAvionesVictorRuiz.rutas_aviones.model.Enlace;
import PracticaAvionesVictorRuiz.rutas_aviones.model.EnlacePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnlaceRepository extends JpaRepository<Enlace, EnlacePK> {
    // JpaRepository ya incluye métodos como findAll(), findById(), save(), deleteById(), etc.
}
