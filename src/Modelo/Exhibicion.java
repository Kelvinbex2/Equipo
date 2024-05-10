package Modelo;

import java.time.LocalDate;
import java.util.Random;

public class Exhibicion extends Partidos {


    public Exhibicion() {
    }

    public Exhibicion(LocalDate fecha) {
        super(fecha);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void ganador() {
        Random r = new Random();
        int probabilidad = r.nextInt(10) + 1;

        if (probabilidad <= 5 ) {
            this.ganado = true;
        } else {
            this.ganado = false;
        }

    }

    @Override
    public String toString() {
        return "Exhibicion\n" + "HaGanado:" + isGanado() + ", fecha:" + getFecha() + ", Puntos:" + getPuntos();
    }

}
