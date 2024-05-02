package Modelo;

public class Jugador {
    private String tipos;
    private String nombre;
    private int dorsal;
    private int habilidad;
    private int altura;
    private int puntos;
    private int faltas;

    public Jugador() {
    }

    public Jugador(String tipos, String nombre, int dorsal, int habilidad, int altura) {
        this.tipos = getTipos();
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.habilidad = habilidad;
        this.altura = altura;
        this.puntos = (int) (35 + (Math.random() * (150 - 35 + 1)));
        this.faltas = (int) (1 + (Math.random() * (5 - 1 + 1)));
    }

    public String getTipos() {

        return tipos;
    }

    public void setTipos(String tipos) {
        // array para los tipos
        String[] tiposValidos = { "base", "escolta", "alero", "ala-pivot", "pivot" };

        // Verificar si el tipo del jugador es válido
        boolean tipoValido = false;
        for (String tipo : tiposValidos) {
            if (tipos.equalsIgnoreCase(tipo)) {
                tipoValido = true;
                break;
            }
        }

        // Si el tipo no es valido, se lanza una excepcion
        if (!tipoValido) {
            throw new IllegalArgumentException("Tipo de jugador no valido: " + tipos);
        }
        this.tipos = tipos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public int getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(int habilidad) {
        this.habilidad = habilidad;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

}