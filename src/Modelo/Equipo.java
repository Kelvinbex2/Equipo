package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
        System.out.println("Quiers jugar: S/N");
        String op = Entrada.leerString();
        int valid = crearPartido();

        if (op.equalsIgnoreCase("S")) {

            if (valid == 1) {
                System.out.println("somos equipo local: < S/N> : ");
                String op2 = Entrada.leerString();
                if (op2.equalsIgnoreCase("S")) {
                    simularPartido();

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
            }else if(partido instanceof Oficial){
                    ((Oficial)partido).toString();
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

    public int crearPartido() {
        Partidos p;
        System.out.print("Elegir opcion: \n1.Oficial  \n2.Exhibicion ");
        int tipo = Entrada.leerEntero();
        if (tipo == 1) {
            p = FactoryPartidos.crearPartido(tipo);
            agregarPartido(p);
        } else {
            p = FactoryPartidos.crearPartido(tipo);
            agregarPartido(p);
        }
        LocalDate date = crearDate();

        p.setFecha(date);
        return tipo;

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

    public void simularPartido() {
        Partidos p = new Partidos() {
        };
        p.posibilidad();
    }

    

}
