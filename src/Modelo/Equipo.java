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
        System.out.println("Quieres jugar");
        String op = Entrada.leerString();

        if (op.equalsIgnoreCase("Si")) {
            obtenerResumen();
            
        }else{
            System.out.println("Hasta la vista");
        }
    }

    @Override
    public void obtenerResumen() {
        System.out.println("Tipo de partido (exhibición u oficiales): ");
        String tipoPartido = Entrada.leerString();
        String equipoSeleccionado = seleccionarEquipo();

        boolean encontrado = false;

        // Iterar sobre la lista de partidos para encontrar aquellos del tipo
        // especificado
        for (Partidos partido : partidos) {
            if (partido.getTipo().equalsIgnoreCase(tipoPartido)) {
                // Mostrar detalles del partido solo si coincide con el tipo de partido
                encontrado = true;

                // Mostrar resumen del partido
                System.out.println("Resumen del partido (" + tipoPartido + "):");
                System.out.println("Resultado: " + partido.getResultado());

                // Mostrar detalles de los jugadores que participaron en este partido
                System.out.println("Detalles de los jugadores:");
                for (Jugador jugador : jugadores) {
                    System.out.println("- Jugador: " + jugador.getNombre());
                    System.out.println("  Puntos: " + jugador.getPuntos());
                    System.out.println("  Faltas: " + jugador.getFaltas());
                    System.out.println("Equipo: " + equipoSeleccionado);
                }

                System.out.println("-----------------------------------------");
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron partidos del tipo '" + tipoPartido + "'.");
        }
    }

    private String seleccionarEquipo() {
        System.out.println("Seleccionar equipo:");
        System.out.println("1. Equipo Local");
        System.out.println("2. Equipo Visitante");
        System.out.print("Elegir uno: ");
        String opcion = Entrada.leerString();

        if (opcion.equals("1")) {
            return "Local";
        } else if (opcion.equals("2")) {
            return "Visitante";
        } else {
            System.out.println("Opción inválida.");
            
        }
        return opcion;
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

    public void agregarPartido(Partidos partido) {
        partidos.add(partido);
    }

}
