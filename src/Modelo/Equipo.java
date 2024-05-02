package Modelo;

import java.util.ArrayList;
import java.util.List;
import Controller.Equipable;
import Entrada.Entrada;

public class Equipo implements Equipable {
    private String nombre;
    private String tipo;
    private List<Jugador> jugadores;
    private List<Partidos> partidos;
    private boolean jugarPartido;

    public Equipo() {
    }

    public Equipo(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.jugadores = new ArrayList<>();
        this.partidos = new ArrayList<>();
        this.jugarPartido = true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public List<Partidos> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partidos> partidos) {
        this.partidos = partidos;
    }

    public boolean isJugarPartido() {
        return jugarPartido;
    }

    public void setJugarPartido(boolean jugarPartido) {
        this.jugarPartido = jugarPartido;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public void agregarJugador(Jugador jugador) {

        jugadores.add(jugador);

    }

    @Override
    public void eliminarJugador(Jugador jugador) {
        jugadores.remove(jugador);
    }

    @Override
    public void jugarPartido() {

        if (jugarPartido) {
            elegir();
            if (elegir().equalsIgnoreCase("1")) {

            } else if (elegir().equalsIgnoreCase("2")) {
                System.out.println("Asigna los putos: ");
                String puntos = Entrada.leerString();
            }

        }
    }

    @Override
    public void obtenerResumen() {
        for (Jugador jugador : jugadores) {
            jugador.getPuntos();
        }

    }

    @Override
    public void obtenerHistoricoTemporada() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerHistoricoTemporada'");
    }

    @Override
    public void obtenerResumenJugador(int dorsal) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerResumenJugador'");
    }

    public String elegir() {
        String num = "";
        System.out.println("1. Equipo Local");
        System.out.println("2. Equipo Visitante");
        System.out.print("Elegir uno");
        num = Entrada.leerString();
        return num;
    }

}
