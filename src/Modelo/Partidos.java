package Modelo;

public class Partidos {
    private String tipo;
    private int puntos;

    public Partidos(String tipo) {
        this.tipo = getTipo();
        this.puntos = (int) (35 + (Math.random() * (150 - 35 + 1)));
    }

    public String getTipo() {
        
        return tipo;
    }

    public int getPuntos() {

        
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void setTipo(String tipo) {
        boolean tipoValido = false;

        String[] nums = { "Exhibicion", "Oficial" };
        System.out.println("Tipo de partidos: ");

        for (String tipos : nums) {
            if (tipo.equalsIgnoreCase(tipos)) {
                tipoValido = true;
                break;
            }
        }

        if (!tipoValido) {
            throw new IllegalArgumentException("TipoPartido no valido" + tipo);
        }
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Resultado  [tipo=" + tipo + ", puntos=" + puntos + "]";
    }

}