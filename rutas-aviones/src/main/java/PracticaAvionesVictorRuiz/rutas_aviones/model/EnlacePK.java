package PracticaAvionesVictorRuiz.rutas_aviones.model;

import java.io.Serializable;
import java.util.Objects;

public class EnlacePK implements Serializable {
    private Integer idOrigen;
    private Integer idDestino;

    // equals, hashCode, getters y setters
    
    public EnlacePK() {}

    public EnlacePK(Integer idOrigen, Integer idDestino) {
        this.idOrigen = idOrigen;
        this.idDestino = idDestino;
    }

    public Integer getIdOrigen() { return idOrigen; }
    public void setIdOrigen(Integer idOrigen) { this.idOrigen = idOrigen; }

    public Integer getIdDestino() { return idDestino; }
    public void setIdDestino(Integer idDestino) { this.idDestino = idDestino; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EnlacePK)) return false;
        EnlacePK that = (EnlacePK) o;
        return Objects.equals(idOrigen, that.idOrigen) && 
            Objects.equals(idDestino, that.idDestino);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrigen, idDestino);
    }
}
