package Modelo.Factoria;
import Modelo.Jugador;

public interface Equipable {
    public void agregarJugador(Jugador jugador);
    public void eliminarJugador(Jugador jugador);
    public void jugarPartido();
    public void obtenerResumen();
    public void obtenerHistoricoTemporada();
    public void  obtenerResumenJugador();
    


    

    
}
