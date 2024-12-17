package com.salesianos.spring.victorRuiz.springboot2jdbcwithh2.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Torneo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreTorneo;
    private LocalDate fechaInicio;

    @ManyToOne
    @JoinColumn(name = "patrocinador_id")
    private Patrocinador patrocinador;

    @ManyToMany
    @JoinTable(
            name = "torneo_ajedrecista",
            joinColumns = @JoinColumn(name = "torneo_id"),
            inverseJoinColumns = @JoinColumn(name = "ajedrecista_id")
    )
    private Set<Ajedrecistas> ajedrecistas = new HashSet<>();

    public Torneo() {}

    public Torneo(String nombreTorneo, LocalDate fechaInicio) {
        this.nombreTorneo = nombreTorneo;
        this.fechaInicio = fechaInicio;
    }

    public Long getId() {
        return id;
    }

    public String getNombreTorneo() {
        return nombreTorneo;
    }

    public void setNombreTorneo(String nombreTorneo) {
        this.nombreTorneo = nombreTorneo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Patrocinador getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(Patrocinador patrocinador) {
        this.patrocinador = patrocinador;
    }

    public Set<Ajedrecistas> getAjedrecistas() {
        return ajedrecistas;
    }

    public void setAjedrecistas(Set<Ajedrecistas> ajedrecistas) {
        this.ajedrecistas = ajedrecistas;
    }
}
