package Modelo;

import java.time.LocalDate;
import java.util.Random;

public class Exhibicion extends Partidos{
    private boolean esLocal;
   

    public Exhibicion(){}

    public Exhibicion(LocalDate fecha) {
        super(fecha);
        //TODO Auto-generated constructor stub
    }

    public boolean isEsLocal() {
        return esLocal;
    }

    public void setEsLocal(boolean esLocal) {
        this.esLocal = esLocal;
    }

    @Override
    public void ganador() {
        Random r = new Random();
        int probabilidad = r.nextInt(10) + 1;
        if (this.esLocal) {
            if (probabilidad == 5) {
                this.ganado = true;
            } else {
                this.ganado = false;
            }
        } else {
            if (probabilidad == 5) {
                this.ganado = true;
            }else{
                this.ganado = false;
            }
        }
    }

    @Override
    public String toString() {
        return "Exhibicion\n" + "HaGanado:" + isGanado() + ", fecha:" + getFecha() + ", Puntos:" + getPuntos();
    }
    
}
