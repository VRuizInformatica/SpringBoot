package PracticaAvionesVictorRuiz.rutas_aviones.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Enlace")
@IdClass(EnlacePK.class)
public class Enlace {

    @Id
    private Integer idOrigen;

    @Id
    private Integer idDestino;

    private Integer tiempo;

    // getters y setters

    public Integer getIdOrigen() { return idOrigen; }
    public void setIdOrigen(Integer idOrigen) { this.idOrigen = idOrigen; }

    public Integer getIdDestino() { return idDestino; }
    public void setIdDestino(Integer idDestino) { this.idDestino = idDestino; }

    public Integer getTiempo() { return tiempo; }
    public void setTiempo(Integer tiempo) { this.tiempo = tiempo; }
}
