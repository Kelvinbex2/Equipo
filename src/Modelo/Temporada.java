package Modelo;

import java.util.Stack;

import Entrada.Entrada;

public class Temporada {
    Stack <Partidos> partido = new Stack<>();

    public Stack<Partidos> getPartido() {
        return partido;
    }

    public void setPartido(Stack<Partidos> partido) {
        this.partido = partido;
    }

    
}
