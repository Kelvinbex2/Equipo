package Modelo;

import java.time.LocalDate;
import java.util.Random;

public abstract class Partidos {

    protected int puntos;
    protected LocalDate fecha;
    protected boolean ganado;

    public Partidos() {
        this.puntos = 0;
        this.ganado = true;
    }

    public Partidos(LocalDate fecha) {
        this.puntos = 0;
        this.ganado = true;
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

    public void jugar() {
        Random r = new Random();
        int probabilidad = r.nextInt(10) + 1;
            if (probabilidad <= 7) {
                this.puntos = r.nextInt(31) + 70; // Aumenta los puntos si se cumple la probabilidad
            } else {
                this.puntos = r.nextInt(116) + 35; // Otro rango de puntos si no se cumple la probabilidad
            }
        
    }

    public void ganador() {
    }

    @Override
    public String toString() {
        return "Partidos puntos: " + puntos + ", fecha: " + fecha + ", ganado: " + ganado + "]";
    }

}