package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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

    public void agregarPartido(Partidos partido) {
        partidos.add(partido);
    }

    @Override
    public void jugarPartido() {
        System.out.println("¿Quieres jugar un partido? (S/N)");
        String op = Entrada.leerString();
        LocalDate date = crearDate();

        if (op.equalsIgnoreCase("S")) {
            System.out.println("1. Oficial\n2. Exhibicion\nElige una opción: ");
            int op2 = Entrada.leerEntero();

            if (op2 != 1 && op2 != 2) {
                System.out.println("Opción de partido inválida");
                return;
            }

            Partidos p = FactoryPartidos.crearPartido(op2);

            if (p != null) {
                agregarPartido(p); // Agregar el partido creado a la lista de partidos

                if (getJugadores().size() >= 4 && op2 == 1 && p instanceof Oficial) {
                    System.out.println("¿Somos equipo local? (S/N)");
                    String op3 = Entrada.leerString();
                    Oficial oficial = (Oficial) p;
                    oficial.setEsLocal(op3.equalsIgnoreCase("s"));
                    oficial.setFecha(date);
                    p.jugar();
                    oficial.ganador();
                    System.out.println("Resumen de puntos y faltas por jugador:");
                    int puntosRestantes = p.getPuntos();

                    //el for es para repartir los putos a jugador
                    for (int i = 0; i < getJugadores().size(); i++) {
                        Jugador jugador = getJugadores().get(i);
                        int faltas = (int) (Math.random() * 3);
                        int puntos;
                        if (i == getJugadores().size() - 1) {
                            puntos = puntosRestantes;
                        } else {
                            puntos = (int) (Math.random() * puntosRestantes);
                        }
                        puntosRestantes -= puntos;
                        System.out.println(
                                "Nombre: " + jugador.getNombre() + ", Puntos " + puntos + ", Faltas: " + faltas);
                        actualizarPuntosJugadores(puntos, jugador);
                        jugador.setFaltas(jugador.getFaltas() + faltas);
                    }
                } else if (getJugadores().size() >= 4 && op2 == 2 && p instanceof Exhibicion) {
                    Exhibicion exhibicion = (Exhibicion) p;

                    exhibicion.setFecha(date);
                    p.jugar();
                    exhibicion.ganador();
                    System.out.println("Resumen de puntos y faltas por jugador:");
                    int puntosRestantes = p.getPuntos();
                    for (int i = 0; i < getJugadores().size(); i++) {
                        Jugador jugador = getJugadores().get(i);
                        int faltas = (int) (Math.random() * 3);
                        int puntos;
                        if (i == getJugadores().size() - 1) {
                            puntos = puntosRestantes;
                        } else {
                            puntos = (int) (Math.random() * puntosRestantes);
                        }
                        puntosRestantes -= puntos;
                        System.out.println(
                                "Nombre: " + jugador.getNombre() + ", Puntos " + puntos + ", Faltas: " + faltas);
                        actualizarPuntosJugadores(puntos, jugador);
                        jugador.setFaltas(jugador.getFaltas() + faltas);
                    }

                }
            } else {
                System.out.println("Tipo de partido no reconocido");
            }
        } else {
            System.out.println("Hasta luego");
        }
    }

    @Override
    public void obtenerResumen() {
        Partidos partido = partidos.peek();
        if (partidos.isEmpty()) {
            System.out.println("\nNo hay parditos hoy\n");
        } else if (partido instanceof Oficial) {
            System.out.println(((Oficial) partido).toString());
        } else if (partido instanceof Exhibicion) {
            System.out.println(((Exhibicion) partido).toString());
        }

    }

    @Override
    public void obtenerHistoricoTemporada() {
        for (Partidos partido : partidos) {
            if (partido instanceof Oficial) {
                System.out.println(((Oficial) partido).toString());
            } else if (partido instanceof Exhibicion) {
                System.out.println(((Exhibicion) partido).toString());
            }
        }
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

   

    private void actualizarPuntosJugadores(int puntos, Jugador jugador) {

        jugador.setPuntos(jugador.getPuntos() + puntos);

    }

    ////////////////////////////////////////////////

}
