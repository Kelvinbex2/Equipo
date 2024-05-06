package Modelo;

public class Partidos {

    private int puntos;

    public Partidos() {
        this.puntos = (int) (35 + (Math.random() * (150 - 35 + 1)));
    }

    public int getPuntos() {

        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

}