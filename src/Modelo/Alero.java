package Modelo;

public class Alero extends Jugador {
    public static final String TIPO = "Alero";
    public Alero(){
        
    }

    public Alero(String nombre, int dorsal, int habilidad, int altura) {
        super(nombre, dorsal, habilidad, altura);
    }

    @Override
    public void informacion() {
        System.out.println("Soy un " + TIPO + " llamado " + getNombre() + " y tengo " + getDorsal() + " dorsal, "
                + getHabilidad() + " de habilidad, " + getAltura() + " de altura y " + getPuntos() + " de puntos.");
    }

}
