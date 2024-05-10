package Modelo;

import java.time.LocalDate;
import java.util.Random;

public abstract class Partidos {

    protected int puntos;
    protected LocalDate fecha;
    protected boolean ganado;


    public Partidos() {
        this.puntos = getPuntos();
        this.ganado=true;
    }

    public Partidos(LocalDate fecha) {
        this.puntos = getPuntos();
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

    public void jugar(){
        Random r = new Random();
        int probabilidad = r.nextInt(10) + 1;
        int puntos =0;
        if(this.ganado){
            puntos = r.nextInt(116) + 35;
            if(probabilidad <= 7){
                puntos = r.nextInt(31) + 70; 
                this.puntos = puntos;
            }else{
                this.puntos = puntos;
            }
        }
    }



   

}