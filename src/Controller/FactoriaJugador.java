package Controller;

import Modelo.AlaPitot;
import Modelo.Alero;
import Modelo.Base;
import Modelo.Escota;
import Modelo.Jugador;
import Modelo.Pivot;

public class FactoriaJugador {
    private static final int MAX_POR_TIPO = 3;

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
