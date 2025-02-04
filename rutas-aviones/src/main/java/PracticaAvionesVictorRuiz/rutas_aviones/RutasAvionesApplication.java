package PracticaAvionesVictorRuiz.rutas_aviones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RutasAvionesApplication {
    public static void main(String[] args) {
        SpringApplication.run(RutasAvionesApplication.class, args);
        System.out.println("Servidor Spring Boot corriendo en http://localhost:8080");
    }
}
