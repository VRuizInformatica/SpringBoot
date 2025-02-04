package PracticaAvionesVictorRuiz.rutas_aviones.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Ciudad")
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private int poblacion;
    private double km2;

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getPoblacion() { return poblacion; }
    public void setPoblacion(int poblacion) { this.poblacion = poblacion; }

    public double getKm2() { return km2; }
    public void setKm2(double km2) { this.km2 = km2; }
}
