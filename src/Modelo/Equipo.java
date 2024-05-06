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

    public Equipo() {
    }

    public Equipo(String nombre, String tipo) {
        this.nombre = nombre;
        setTipo(tipo);
        this.jugadores = new ArrayList<>();
        this.partidos = new ArrayList<>();
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        String[] tipos = { "Local", "Visitante" };
        System.out.println("Tipo de Equipo");
        boolean hayTipo = false;

        for (String tip : tipos) {
            if (tipo.equalsIgnoreCase(tip)) {
                hayTipo = true;
                break;
            }
        }

        if (!hayTipo) {
            throw new IllegalArgumentException("El tipo de equipo solo puede ser Local o vistante" + tipo);
        }

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

    }

    @Override
    public void obtenerResumen() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerHistoricoTemporada'");
    }

    @Override
    public void obtenerHistoricoTemporada() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerHistoricoTemporada'");
    }

    @Override
    public void obtenerResumenJugador() {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores disponibles");
        }
        for (Jugador j : jugadores) {
            if (j instanceof AlaPitot) {
                ((AlaPitot) j).informacion();
            } else if (j instanceof Alero) {
                ((Alero) j).informacion();
            } else if (j instanceof Pivot) {
                ((Pivot) j).informacion();
            } else if (j instanceof Base) {
                ((Base) j).informacion();
            } else if (j instanceof Escota) {
                ((Escota) j).informacion();
            }
        }
    }

    public void agregarPartido(Partidos partido) {
        partidos.add(partido);
    }
}
