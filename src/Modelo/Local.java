package Modelo;

public class Local extends Equipo {
    private boolean esLocal;

    public Local(boolean esLocal) {
        this.esLocal = esLocal;
    }

    public Local(String nombre, String tipo) {
        super(nombre, tipo);
        this.esLocal = true;
    }

    public boolean isEsLocal() {
        return esLocal;
    }

    public void setEsLocal(boolean esLocal) {
        this.esLocal = esLocal;
    }
}
