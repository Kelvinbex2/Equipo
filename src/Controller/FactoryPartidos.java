package Controller;

import Modelo.Exhibicion;
import Modelo.Oficial;
import Modelo.Partidos;

public class FactoryPartidos {
    
    public static Partidos crearPartido(int opc){

        if(opc == 1){
            return new Oficial();
        }
        else 
            return new Exhibicion();
        }
      
        

    
}
