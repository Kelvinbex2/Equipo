package Modelo.Factoria;

import Modelo.Exhibicion;
import Modelo.Oficial;
import Modelo.Partidos;

public class FactoryPartidos {

    public static Partidos crearPartido(int opc) {
        switch (opc) {
            case 1:
                return new Oficial(); // Crear partido oficial
            case 2:
                return new Exhibicion(); // Crear partido de exhibición
            default:
                throw new IllegalArgumentException("Opción de partido no válida");
        }
    }
}
