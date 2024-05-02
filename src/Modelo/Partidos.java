package Modelo;

public class Partidos {
    private String tipo;
    private int resultado;

    public Partidos(String tipo) {
        this.tipo = tipo;
        this.resultado = (int) (35 + (Math.random() * (150 - 35 + 1)));
    }

    public String getTipo() {
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
        return tipo;
    }

    public int getResultado() {

        
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public void setTipo(String tipo) {
        
        this.tipo = tipo;
    }

}