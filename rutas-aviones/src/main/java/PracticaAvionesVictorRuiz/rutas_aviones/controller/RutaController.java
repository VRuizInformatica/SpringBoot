package PracticaAvionesVictorRuiz.rutas_aviones.controller;

import PracticaAvionesVictorRuiz.rutas_aviones.model.Ciudad;
import PracticaAvionesVictorRuiz.rutas_aviones.repository.CiudadRepository;
import PracticaAvionesVictorRuiz.rutas_aviones.service.RutaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("")
public class RutaController {

    private final RutaService rutaService;
    private final CiudadRepository ciudadRepository;

    public RutaController(RutaService rutaService, CiudadRepository ciudadRepository) {
        this.rutaService = rutaService;
        this.ciudadRepository = ciudadRepository;
    }

    @GetMapping("/ciudades")
    public List<Ciudad> getCiudades() {
        return ciudadRepository.findAll();
    }

    @GetMapping("/ruta")
    public Map<String, Object> getRuta(
        @RequestParam Integer origen,
        @RequestParam Integer destino,
        @RequestParam(required = false) Integer omit
    ) {
        return rutaService.calcularRuta(origen, destino, omit);
    }
}
