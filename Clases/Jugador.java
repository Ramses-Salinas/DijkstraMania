
package Clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Jugador implements Serializable{
    
    //Atributos
    String nombre;
    List <PuntajeNivel> puntajes=new ArrayList<>();
    Integer nivelAlcanzado;
    Integer puntajeTotal=0;
    
    // Metodo Constructor
    public Jugador(String nombre){
    this.nombre =nombre;
    }
    
    public void agregarPuntajeDeNivel(PuntajeNivel puntaje){
        puntajes.add(puntaje);
        nivelAlcanzado=puntaje.getNivelCompletado();
    }
    
    public int calculaPuntajeAcumulado(){
        puntajeTotal=0;
        for(PuntajeNivel punto: puntajes){
            puntajeTotal+=punto.getPuntaje();
        }
        return puntajeTotal;
    }
    //Metodo para mostrar al jugador
    public String mostrarJugador(){
        String mensaje;
        mensaje="__________________________________\n";
        mensaje+="Resumen de jugador:\n";
        mensaje+="Nombre: "+nombre+".\nNivel alcanzado: "+nivelAlcanzado+".\nPuntuacion: "+puntajeTotal+".\n\n";
        mensaje+="Puntaje por nivel:\n";
        for(PuntajeNivel punto: puntajes){
            mensaje+=punto.mostrarPuntajeDetallado();
        }
        mensaje+="__________________________________";
        return mensaje;
    }
   
    //Metodo para devolver el nombre
    public String getNombre(){   
    return nombre;
    }

    public Integer getNivelAlcanzado() {
        return nivelAlcanzado;
    }

    public Integer getPuntajeTotal() {
        calculaPuntajeAcumulado();
        return puntajeTotal;
    }
}
