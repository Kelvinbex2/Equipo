package Modelo;

public class Visitante extends Equipo {
    private boolean esVisitante;

    public boolean isEsVisitante() {
        return esVisitante;
    }

    public void setEsVisitante(boolean esVisitante) {
        this.esVisitante = esVisitante;
    }

    public Visitante(String nombre, String tipo, boolean esVisitante) {
        super(nombre, tipo);
        this.esVisitante = true;
    }

}
