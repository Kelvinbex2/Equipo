package Modelo;

public class Jugador {

    private String tipos;
    private String nombre;
    private int dorsal;
    private int habilidad;
    private int altura;
    private int puntos;
    private int faltas;
    private int[] jugadoresPorTipo = new int[5]; // Array para la cantidad de jugadores por tipo
    private int cantidadJugadores = 0; // Cantidad total de jugadores en el equipo

    public Jugador() {
    }

    public Jugador(String tipos, String nombre, int dorsal, int habilidad, int altura) {
        this.tipos = getTipos();
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.habilidad = habilidad;
        this.altura = altura;
        this.puntos = (int) (2 + (Math.random() * (70 - 35 + 1)));
        this.faltas = (int) (1 + (Math.random() * (5 - 1 + 1)));
        // Inicializar la cantidad total de jugadores y validar
        cantidadJugadores++;
        validarCantidadJugadores();

        // Incrementar la cantidad de jugadores del tipo correspondiente
        jugadoresPorTipo[getIndiceTipo(tipos)]++;
    }

    public String getTipos() {
        return tipos;
    }

    public void setTipos(String tipos) {
        // Array para los tipos validos
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

        // Verificar si se excede el límite de jugadores por tipo
        if (jugadoresPorTipo[getIndiceTipo(tipos)] >= 3) {
            throw new IllegalArgumentException("Se ha excedido el límite de jugadores para el tipo: " + tipos);
        }

        // Incrementar la cantidad de jugadores del tipo correspondiente
        jugadoresPorTipo[getIndiceTipo(tipos)]++;

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

    private int getIndiceTipo(String tipo) {
        switch (tipo.toLowerCase()) {
            case "base":
                return 0;
            case "escolta":
                return 1;
            case "alero":
                return 2;
            case "ala-pivot":
                return 3;
            case "pivot":
                return 4;
            default:
                throw new IllegalArgumentException("Tipo de jugador no valido: " + tipo);
        }
    }

    private void validarCantidadJugadores() {
        if (cantidadJugadores >= 15) {
            throw new IllegalArgumentException("Se ha superado el límite de jugadores por equipo (15), no admite mas de 15");
        }
    }

    public void anotarPuntos(int puntos) {
        this.puntos += puntos;
    }

    public void incrementarFaltas(int faltas) {
        this.faltas += faltas;
    }

}