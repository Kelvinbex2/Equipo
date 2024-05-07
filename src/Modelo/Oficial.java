package Modelo;

import java.time.LocalDate;

public class Oficial extends Partidos {
    private boolean esLocal;

    public Oficial() {
        
    }

    public Oficial(LocalDate fecha) {

        super(fecha);
        this.esLocal = true;

    }

    // crear constructor vacio

    public boolean isEsLocal() {
        return esLocal;
    }

    public void setEsLocal(boolean esLocal) {
        this.esLocal = esLocal;
    }

    @Override
    public String toString() {
        return "Oficial{" + "esLocal=" + esLocal + ", fecha=" + getFecha() + "Puntos" + getPuntos();
    }

}
