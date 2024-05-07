package Vista;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Controller.FactoriaJugador;
import Controller.FactoryPartidos;
import Entrada.Entrada;
import Modelo.AlaPitot;
import Modelo.Alero;
import Modelo.Base;
import Modelo.Equipo;
import Modelo.Escota;
import Modelo.Exhibicion;
import Modelo.Jugador;
import Modelo.Oficial;
import Modelo.Partidos;
import Modelo.Pivot;

public class App {
    static List<Equipo> equipos = new ArrayList<>();
    static Jugador j;
    static Equipo e;
   // static Partidos p;

    public static void crearMenu() {

        int op = 0;

        do {
            System.out.println("1. Agregar Jugador");
            System.out.println("2. Eliminar Jugador");
            System.out.println("3. Jugar Partido");
            System.out.println("4. Crear Partidp");
            System.out.println("5. Mostrar resumen del  partido");
            System.out.println("6. Obtener Resumen");
            System.out.println("7. Mostrar resumen Jugador");
            System.out.println("0. Salir");

            System.out.print("Elegir una opcion: ");
            op = Entrada.leerEntero();

            switch (op) {
                case 1:
                    addJugador();
                    break;

                case 2:
                    eliminarJugador();
                    break;

                case 3:
                    e.jugarPartido();
                    break;

                case 4:
                   e.obtenerResumen();

                    break;
                case 5:

                    break;
                case 6:
                    e.obtenerResumenJugador();
                    break;
                case 0:
                    System.out.println("Saliendo.....");
                    break;

                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        } while (op != 0);

    }

    public static void main(String[] args) throws Exception {

        e = new Equipo("kelvin", "Local");
        j = new Base("kelvin", 1, 1, 1, 1);
       // p = new Oficial(crearDate());
       // e.agregarPartido(p);
        e.agregarJugador(j);
        addEquipo(e);
        crearMenu();

    }

    public static void addEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    public static void addJugador() {

        System.out.print("Nombre: ");
        String nombre = Entrada.leerString();
        System.out.print("Dorsal: ");
        int dors = Entrada.leerEntero();
        System.out.print("Puntos: ");
        int puntos = Entrada.leerEntero();
        System.out.print("Habilidad: ");
        int habilidad = Entrada.leerEntero();
        while (habilidad < 1 || habilidad > 4) {
            System.out.println("tiene que ser de un rango 1 a 5 ");
            System.out.print("Habilidad: ");
            habilidad = Entrada.leerEntero();
        }
        System.out.print("Altura: ");
        int altura = Entrada.leerEntero();

        Jugador jugador = FactoriaJugador.crearJugador(habilidad, altura);
        jugador.setNombre(nombre);
        jugador.setDorsal(dors);
        jugador.setPuntos(puntos);
        jugador.setAltura(altura);
        jugador.setHabilidad(habilidad);
        e.agregarJugador(jugador);

    }

    public static void eliminarJugador() {
        if (e.getJugadores().isEmpty()) {
            System.out.println("No hay jugadores en el equipo.");
            return;
        }

        System.out.print("Nombre de jugador a eliminar: ");
        String nombre = Entrada.leerString();
        boolean exist = false;

        for (Jugador jug : e.getJugadores()) {
            if (nombre.equalsIgnoreCase(jug.getNombre()) && jug instanceof AlaPitot) {
                e.eliminarJugador(jug);
                exist = true;
                break;

            } else if (nombre.equalsIgnoreCase(jug.getNombre()) && jug instanceof Alero) {
                e.eliminarJugador(jug);
                exist = true;
                break;

            } else if (nombre.equalsIgnoreCase(jug.getNombre()) && jug instanceof Base) {
                e.eliminarJugador(jug);
                exist = true;
                break;

            } else if (nombre.equalsIgnoreCase(jug.getNombre()) && jug instanceof Escota) {
                e.eliminarJugador(jug);
                exist = true;
                break;

            } else if (nombre.equalsIgnoreCase(jug.getNombre()) && jug instanceof Pivot) {
                e.eliminarJugador(jug);
                exist = true;
                break;

            }

        }

        if (!exist) {
            System.out.println("No exite" + nombre + "en el array jugador");
        }

    }

  

   

}
