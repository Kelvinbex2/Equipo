package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Controller.Equipable;
import Controller.FactoryPartidos;
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
        System.out.println("¿Quieres jugar un partido? (S/N)");
        String op = Entrada.leerString();

        if (op.equalsIgnoreCase("S")) {
            int valid = crearPartido();
            Partidos p = obtPartidos(valid);

            if (p != null) {
                System.out.println("¿Somos equipo local? (S/N)");
                String op2 = Entrada.leerString();

                if (op2.equalsIgnoreCase("S")) {
                    // Validar el puntaje del partido para simulación local
                    int puntosPartido = p.getPuntos();
                    if (puntosPartido >= 35 && puntosPartido <= 150) {
                        int resultadoSimulado = simularLocal();

                        System.out.println("Resultado simulado del partido: " + resultadoSimulado);

                        // Actualizar puntos de los jugadores basados en el resultado simulado
                        actualizarPuntosJugadores(resultadoSimulado);

                        System.out.println("----------------");
                        mostrarResumenJugadores(p.getFecha());
                    } else {
                        System.out.println("El puntaje del partido no es adecuado para simular como equipo local.");
                    }
                } else {
                    
                    System.out.println("Simulación como equipo visitante (a implementar).");
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
                System.out.println("No hay parditos hoy");
            } else if (partido instanceof Oficial) {
                System.out.println(((Oficial) partido).toString());
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


    private Partidos obtPartidos(int opc) {
        return FactoryPartidos.crearPartido(opc);
    }

    private void mostrarResumenJugadores(LocalDate localDate) {
        System.out.println("Resumen de puntos y faltas por jugador:");
        for (Jugador jugador : jugadores) {
            System.out.println("Nombre: " + jugador.getNombre() + ", Puntos " + jugador.getPuntos() + ", Faltas: "
                    + jugador.getFaltas());
        }

    }

    private int simularLocal() {
        Random random = new Random();

        if (random.nextDouble() < 0.7) {
            return random.nextInt(31) + 70;
        } else {
            return random.nextInt(16) + 35;
        }
    }


    private void actualizarPuntosJugadores(int resultadoSimulado) {
        for (Jugador jugador : jugadores) {
            jugador.setPuntos(jugador.getPuntos() + resultadoSimulado);
        }
    }

    ////////////////////////////////////////////////

}
