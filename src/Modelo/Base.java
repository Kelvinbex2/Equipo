package Modelo;

public class Base extends Jugador {
    public static final String TIPO = "Base";
    public Base(){
        
    }

    public Base(String nombre, int dorsal, int habilidad, int altura, int puntos) {
        super(nombre, dorsal, habilidad, altura, puntos);
    }

    @Override
    public void informacion() {
        System.out.println("Soy un " + TIPO + " llamado " + getNombre() + " y tengo " + getDorsal() + " dorsal, "
                + getHabilidad() + " de habilidad, " + getAltura() + " de altura y " + getPuntos() + " de puntos.");
    }

}
