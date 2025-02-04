// src/main/java/com/example/sportsevents/model/Instalacion.java
package com.example.sportsevents.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Instalacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    // Tipo de instalación (por ejemplo, "pista", "gimnasio", etc.)
    private String tipo;
    private String ubicacion;

    // Una instalación puede tener varias reservas
    @OneToMany(mappedBy = "instalacion", cascade = CascadeType.ALL)
    private List<Reserva> reservas;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
