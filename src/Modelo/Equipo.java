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
        // Verificar si hay jugadores disponibles
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores en el equipo para jugar el partido.");
            return;
        }

        // Confirmar si se desea jugar el partido
        System.out.print("¿Quieres jugar el partido? (S/N): ");
        String respuesta = Entrada.leerString();
        if (!respuesta.equalsIgnoreCase("S")) {
            System.out.println("No se jugará el partido. Hasta luego.");
            return;
        }

        // Seleccionar equipo (Local o Visitante)
        System.out.print("Selecciona tu equipo (Local/Visitante): ");
        String equipoSeleccionado = Entrada.leerString();

        // Simular el partido
        System.out.println("¡El partido ha comenzado entre " + this.nombre + " y " + equipoSeleccionado + "!");
        simularPartido();
    }

    private void simularPartido() {

        for (Jugador jugador : jugadores) {
            int puntos = jugador.getPuntos();
            int faltas = jugador.getFaltas();
            jugador.anotarPuntos(puntos);
            jugador.incrementarFaltas(faltas);
        }

        System.out.println("¡El partido ha finalizado!");

        // Mostrar resumen del partido
        mostrarResumenPartido();
    }

    private void mostrarResumenPartido() {
        System.out.println("Resumen del partido:");

        for (Jugador jugador : jugadores) {
            System.out.println("- Jugador: " + jugador.getNombre());
            System.out.println("  Puntos: " + jugador.getPuntos());
            System.out.println("  Faltas: " + jugador.getFaltas());
        }
        System.out.println("-------------------------");
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
    public void obtenerResumenJugador(int dorsal) {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores disponibles");
        }
        for (Jugador jugador : jugadores) {
            System.out.println("- Nombre: " + jugador.getNombre());
            System.out.println("  Tipo  : " + jugador.getTipos());
            System.out.println("  Dorsal  : " + jugador.getDorsal());
            System.out.println("  Altura  : " + jugador.getAltura());
            System.out.println("  Puntos  : " + jugador.getPuntos());
            System.out.println("  habilidad  : " + jugador.getHabilidad());
            System.out.println("  Puntos total de temporada  : " + jugador.getPuntos());

        }
    }

    public void agregarPartido(Partidos partido) {
        partidos.add(partido);
    }
}
