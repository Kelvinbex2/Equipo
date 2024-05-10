package Modelo.Factoria;

import Modelo.AlaPitot;
import Modelo.Alero;
import Modelo.Base;
import Modelo.Escota;
import Modelo.Jugador;
import Modelo.Pivot;

public class FactoriaJugador {
    private static final int MAX_POR_TIPO = 3;
    static int base = 0;
    static int escota = 0;
    static int alero = 0;
    static int alapivot = 0;
    static int pivot = 0;

    public static Jugador crearJugador(String nombre, int dorsal, int habilidad, int altura) {
        if (altura <=180 && habilidad >= 5 && base < MAX_POR_TIPO) {
            base++;
            return new Base(nombre,dorsal,habilidad,altura);
        } else if (altura < 185 && habilidad >= 4 && escota < MAX_POR_TIPO) {
            escota++;
            return new Escota(nombre,dorsal,habilidad,altura);
        } else if (altura < 190 && habilidad >= 3 && alero < MAX_POR_TIPO) {
            alero++;
            return new Alero(nombre,dorsal,habilidad,altura);
        } else if (altura < 195 && habilidad >= 2 && alapivot < MAX_POR_TIPO) {
            alapivot++;
            return new AlaPitot(nombre,dorsal,habilidad,altura);
        } else if (altura < 200 && habilidad >= 1 && alapivot < MAX_POR_TIPO) {
            return new Pivot(nombre,dorsal,habilidad,altura);
        } else {
            if (base < MAX_POR_TIPO) {
                return new Base(nombre,dorsal,habilidad,altura);
            } else if (escota < MAX_POR_TIPO) {
                return new Escota(nombre,dorsal,habilidad,altura);
            } else if (alero < MAX_POR_TIPO) {
                return new Alero(nombre,dorsal,habilidad,altura);
            } else if (alapivot < MAX_POR_TIPO) {
                return new AlaPitot(nombre,dorsal,habilidad,altura);
            } else {
                return new Pivot(nombre,dorsal,habilidad,altura);
            }
        }

    }
}
