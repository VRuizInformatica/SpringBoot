// src/main/java/com/example/sportsevents/model/Evento.java
package com.example.sportsevents.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private LocalDate fecha;
    private LocalTime hora;

    // Suponemos que la duración se expresa en minutos
    private Integer duracion;

    // Relación many-to-many con Usuario (participantes)
    @ManyToMany
    @JoinTable(
            name = "evento_usuario",
            joinColumns = @JoinColumn(name = "evento_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private Set<Usuario> participantes;

    // Un evento puede tener asociada una reserva (relación one-to-one, opcional)
    @OneToOne(mappedBy = "evento", cascade = CascadeType.ALL)
    private Reserva reserva;

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Set<Usuario> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Set<Usuario> participantes) {
        this.participantes = participantes;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
        // Si se establece la reserva, se vincula también el evento en la reserva
        if (reserva != null) {
            reserva.setEvento(this);
        }
    }
}
