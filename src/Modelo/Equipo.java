package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import Modelo.Entrada.Entrada;
import Modelo.Factoria.Equipable;
import Modelo.Factoria.FactoriaJugador;
import Modelo.Factoria.FactoryPartidos;

public class Equipo implements Equipable {

    private String nombre;
    private List<Jugador> jugadores;
    private Stack<Partidos> partidos;

    public Equipo() {
    }

    public Equipo(String nombre) {
        this.nombre = nombre;

        this.jugadores = new ArrayList<>();
        this.partidos = new Stack<>();

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

    public Stack<Partidos> getPartidos() {
        return partidos;
    }

    public void setPartidos(Stack<Partidos> partidos) {
        this.partidos = partidos;
    }

    public void comprobar(String nombre) {
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equals(nombre)) {
                throw new IllegalArgumentException("El nombre ya existe");
            }
        }
    }

    @Override
    public void agregarJugador(Jugador jugador) {

        if (jugadores.size() < 15) {

            Jugador j = FactoriaJugador.crearJugador(jugador.getNombre(), jugador.getDorsal(), jugador.getHabilidad(),
                    jugador.getAltura());
            jugadores.add(j);

        } else {
            throw new IllegalArgumentException(
                    "Se ha superado el límite de jugadores por equipo (15), no admite mas de 15");
        }
    }

    @Override
    public void eliminarJugador(Jugador jugador) {
        jugadores.remove(jugador);
    }

    @Override
    public void jugarPartido() {
        System.out.println("¿Quieres jugar un partido? (S/N)");
        String op = Entrada.leerString();

        if (op.equalsIgnoreCase("S")) {
            System.out.println("Oficial ? (S/N)");
            String op2 = Entrada.leerString();
            if (op2.equalsIgnoreCase("S")) {
                Oficial p = new Oficial();
                if (p != null && getJugadores().size() > 5) {
                    System.out.println("¿Somos equipo local? (S/N)");
                    String op3 = Entrada.leerString();
                    if (op3.equalsIgnoreCase("S")) {
                        p.setEsLocal(true);
                        p.jugar();
                        p.ganador();
                    } else {
                        p.setEsLocal(false);
                        p.jugar();
                        p.ganador();
                    }
                    actualizarPuntosJugadores(p.getPuntos());
                } else {
                    System.out.println("No hay suficientes jugadores para jugar un partido oficial");
                }
            } else {
                Exhibicion p = new Exhibicion();
                if (p != null && getJugadores().size() > 5) {
                    System.out.println("¿Somos equipo local? (S/N)");
                    String op3 = Entrada.leerString();
                    if (op3.equalsIgnoreCase("S")) {
                        p.jugar();
                    } else {
                        p.jugar();
                    }
                } else {
                    System.out.println("No hay suficientes jugadores para jugar un partido de exhibición");
                }
            }
        } else {
            System.out.println("Hasta luego");
        }
    }

    @Override
    public void obtenerResumen() {
        for (Partidos partido : partidos) {
            if (partidos.isEmpty()) {
                System.out.println("\nNo hay parditos hoy\n");
            } else if (partido instanceof Oficial) {
                System.out.println(((Oficial) partidos.peek()).toString());
            }
        }

    }

    @Override
    public void obtenerHistoricoTemporada() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerHistoricoTemporada'");
    }

    @Override
    public void obtenerResumenJugador() {
        if (jugadores.isEmpty()) {
            System.out.println("\nNo hay jugadores disponibles\n");
        }

        System.out.print("\n1.Nombre \n2.Lista \nQuieres buscar por nombre or quieres la lista de los jugadores: ");
        int opc = Entrada.leerEntero();
        boolean found = false;
        if (opc == 1) {
            System.out.print("\nEscribe el nombre a Mostrar:");
            String nombre = Entrada.leerString();
            for (Jugador j : jugadores) {

                if (j instanceof AlaPitot && j.getNombre().equalsIgnoreCase(nombre)) {
                    ((AlaPitot) j).informacion();
                    found = true;
                } else if (j instanceof Alero && j.getNombre().equalsIgnoreCase(nombre)) {
                    ((Alero) j).informacion();
                    found = true;
                } else if (j instanceof Pivot && j.getNombre().equalsIgnoreCase(nombre)) {
                    ((Pivot) j).informacion();
                    found = true;
                } else if (j instanceof Base && j.getNombre().equalsIgnoreCase(nombre)) {
                    ((Base) j).informacion();
                    found = true;
                } else if (j instanceof Escota && j.getNombre().equalsIgnoreCase(nombre)) {
                    ((Escota) j).informacion();
                    found = true;
                }

            }
            if (!found) {
                System.out.println("\nEl nombre " + nombre + " no existe.\n");
            }
        } else {
            for (Jugador jugador : jugadores) {
                jugador.informacion();
            }
        }

    }

    public void agregarPartido(Partidos partido) {
        partidos.add(partido);
    }

    public LocalDate crearDate() {
        System.out.print("Anio:");
        int anio = Entrada.leerEntero();
        System.out.print("Mes:");
        int mes = Entrada.leerEntero();
        System.out.print("Dia:");
        int dia = Entrada.leerEntero();

        return LocalDate.of(anio, mes, dia);
    }

    //////// metodos para Jugar un partido

    public int crearPartido() {
        System.out.println("1. Oficial");
        System.out.println("2. Exhibición");
        System.out.print("Elige una opción: ");
        int tipo = Entrada.leerEntero();

        Partidos p = FactoryPartidos.crearPartido(tipo);
        agregarPartido(p);

        LocalDate date = crearDate();
        p.setFecha(date);

        return tipo;
    }

    private void mostrarResumenJugadores(LocalDate localDate) {
        System.out.println("Resumen de puntos y faltas por jugador:");
        for (Jugador jugador : jugadores) {
            System.out.println("Nombre: " + jugador.getNombre() + ", Puntos " + jugador.getPuntos() + ", Faltas: "
                    + jugador.getFaltas());
        }

    }

    private void actualizarPuntosJugadores(int resultadoSimulado) {
        for (Jugador jugador : jugadores) {
            jugador.setPuntos(jugador.getPuntos() + resultadoSimulado);
        }
    }

    ////////////////////////////////////////////////

}
