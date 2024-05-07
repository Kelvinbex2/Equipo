package Modelo;

public abstract class Jugador {

    private String nombre;
    private int dorsal;
    private int habilidad;
    private int altura;
    private int puntos;
    private int faltas;
    private int cantidadJugadores = 0;

    public Jugador() {
    }

    public Jugador(String nombre, int dorsal, int habilidad, int altura, int puntos) {
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.habilidad = habilidad;
        this.altura = altura;
        this.puntos = puntos;
        this.faltas = (int) (1 + (Math.random() * (5 - 1 + 1)));
        cantidadJugadores++;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public int getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(int habilidad) {
        this.habilidad = habilidad;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    private void validarCantidadJugadores() {
        if (cantidadJugadores >= 15) {
            throw new IllegalArgumentException(
                    "Se ha superado el límite de jugadores por equipo (15), no admite mas de 15");
        }
    }

    public void anotarPuntos(int puntos) {
        this.puntos += puntos;
    }

    public void incrementarFaltas(int faltas) {
        this.faltas += faltas;
    }

    public void informacion() {

    }

}