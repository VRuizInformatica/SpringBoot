// src/main/java/com/example/sportsevents/model/Reserva.java
package com.example.sportsevents.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;

    // La franja horaria se puede representar como String (por ejemplo, "08:00-10:00")
    private String franjaHoraria;

    // Cada reserva se asocia a una instalación
    @ManyToOne
    @JoinColumn(name = "instalacion_id")
    private Instalacion instalacion;

    // Opcionalmente, la reserva puede estar asociada a un evento
    @OneToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getFranjaHoraria() {
        return franjaHoraria;
    }

    public void setFranjaHoraria(String franjaHoraria) {
        this.franjaHoraria = franjaHoraria;
    }

    public Instalacion getInstalacion() {
        return instalacion;
    }

    public void setInstalacion(Instalacion instalacion) {
        this.instalacion = instalacion;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
