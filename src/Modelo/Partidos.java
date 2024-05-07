package Modelo;

import java.time.LocalDate;

public abstract class Partidos {

    protected int puntos;
    protected LocalDate fecha;
    protected boolean ganado;


    public Partidos() {
        this.puntos = (int) (35 + (Math.random() * (150 - 35 + 1)));
        this.ganado=true;
    }

    public Partidos(LocalDate fecha) {
        this.puntos = (int) (35 + (Math.random() * (150 - 35 + 1)));
        this.ganado=true;
    }

    public int getPuntos() {

        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    
    public boolean isGanado() {
        return ganado;
    }

    public void setGanado(boolean ganado) {
        this.ganado = ganado;
    }

   

}