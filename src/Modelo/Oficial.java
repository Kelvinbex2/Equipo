package Modelo;

import java.time.LocalDate;
import java.util.Random;

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
        return "Oficial\n" + "esLocal:" + esLocal + ", fecha:" + getFecha() + " Puntos:" + getPuntos();
    }

    public void ganador() {
        Random r = new Random();
        int probabilidad = r.nextInt(10) + 1;
        if (this.esLocal) {
            if (probabilidad <= 7) {
                this.ganado = true;
            } else {
                this.ganado = false;
            }
        } else {
            if (probabilidad <= 3) {
                this.ganado = true;
            }else{
                this.ganado = false;
            }
        }
    }

<<<<<<< HEAD
}
=======
}
>>>>>>> d529df1363a306e4bac801fdcc3ed89d911cf9af
