package Vista;

import java.util.ArrayList;
import java.util.List;

import Entrada.Entrada;
import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Partidos;

public class App {
    static List<Equipo> equipos = new ArrayList<>();
    static List<Jugador> jugadores = new ArrayList<>();
    static Jugador j;

    static Equipo e;

    public static void crearMenu() {

        int op = 0;
        
        do {
            System.out.println("1. Agregar Jugador");
            System.out.println("2. Eliminar Jugador");
            System.out.println("3. Crear partido");
            System.out.println("4. Jugar Partido");
            System.out.println("5. Obtener Resumen");
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
                    crearPartido();
                    break;

                case 4:
                    e.jugarPartido();
                
                    break;
                case 5:

                    e.obtenerResumen();
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
        j = new Jugador("ss", "1", 1, 1, 1);
        e.agregarJugador(j);
        addEquipo(e);
        crearMenu();

    }

    public static void addEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    public static void addJugador() {

        System.out.print("Tipo: ");
        String tipo = Entrada.leerString();
        j.setTipos(tipo);
        System.out.print("Nombre: ");
        String nombre = Entrada.leerString();
        System.out.print("Dorsal: ");
        int dors = Entrada.leerEntero();
        System.out.print("Habilidad: ");
        int habilidad = Entrada.leerEntero();
        while (habilidad < 1 || habilidad > 5) {
            System.out.println("tiene que ser de un rango 1 a 5 ");
            System.out.print("Habilidad: ");
            habilidad = Entrada.leerEntero();
        }
        System.out.print("Altura: ");
        int altura = Entrada.leerEntero();

        Jugador jugador = new Jugador(tipo, nombre, dors, habilidad, altura);
        e.agregarJugador(jugador);

    }

    public static void eliminarJugador() {
        if (e.getJugadores().isEmpty()) {
            System.out.println("No hay jugadores en el equipo.");
            return;
        }

        System.out.print("Nombre del jugador a eliminar: ");
        String nombreJugador = Entrada.leerString();

        boolean jugadorEncontrado = false;
        for (Jugador jugador : e.getJugadores()) {
            if (jugador.getNombre().equalsIgnoreCase(nombreJugador)) {
                e.eliminarJugador(jugador); // Llamar al método eliminarJugador()
                System.out.println("Jugador " + nombreJugador + " eliminado del equipo.");
                jugadorEncontrado = true;
                break; // Salir del bucle una vez que se elimina el jugador
            }
        }

        if (!jugadorEncontrado) {
            System.out.println("No se encontró al jugador " + nombreJugador + " en el equipo.");
        }

    }

    public static void crearPartido() {

        
        System.out.print("Tipo : exhibición u oficiale : ");
        String tipo = Entrada.leerString();
        

        Partidos pa = new Partidos(tipo);
        e.agregarPartido(pa);
    }

}
