package Modelo;

public class Escota extends Jugador {
    public static final String TIPO = "Escota";
    public Escota(){
        
    }

    public Escota(String nombre, int dorsal, int habilidad, int altura) {
        super(nombre, dorsal, habilidad, altura );
    }

    @Override
    public void informacion() {
        System.out.println("Soy un " + TIPO + " llamado " + getNombre() + " y tengo " + getDorsal() + " dorsal, "
                + getHabilidad() + " de habilidad, " + getAltura() + " de altura y " + getPuntos() + " de puntos.");
    }

}
