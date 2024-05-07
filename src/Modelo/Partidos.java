package Modelo;

import java.time.LocalDate;

public abstract class Partidos {

    protected int puntos;
    protected LocalDate fecha;

    public Partidos() {
    }

    public Partidos(LocalDate fecha) {
        this.puntos = (int) (35 + (Math.random() * (150 - 35 + 1)));
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

    public void posibilidad() {
        if ((this.getPuntos() >= 70) && this.getPuntos() <= 100) {
            this.setPuntos(this.getPuntos() + 10);
        } else {
            this.setPuntos(this.getPuntos() - 1);
        }

    }

    @Override
    public String toString() {
        return "Puntos=" + puntos +  ", Fecha=" + fecha ;
    }
}