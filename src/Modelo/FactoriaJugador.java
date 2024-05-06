package Modelo;

public class FactoriaJugador {
    static int base = 0;
    static int escota = 0;
    static int alero = 0;
    static int pivot = 0;
    static int alaPitot = 0;

    public static Jugador crearJugador(int habilidad, int altura) {
        if (altura < 180 && habilidad >= 4) {
            return new Base();
        } else if (altura < 185 && habilidad >= 3) {
            return new Escota();
        } else if (altura < 190 && habilidad >= 2) {
            return new Alero();
        } else if (altura < 195 && habilidad >= 1) {
            return new AlaPitot();
        } else {
            return new Pivot();
        }

    }
}
