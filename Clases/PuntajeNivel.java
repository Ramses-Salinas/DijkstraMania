
package Clases;

import java.io.Serializable;


public class PuntajeNivel implements Serializable{
    private int nivelCompletado; 
    private int tiempo;
    private int puntaje;
    private String tiem;

    public PuntajeNivel(Nivel nivelCompletado, int tiempo) {
        this.tiempo = tiempo;
        this.nivelCompletado = nivelCompletado.ordenNivel;
        calculaPuntaje();
        tiem=""+(tiempo%60);
        tiem=((int)tiempo/60)+" : "+tiem;
    }
    
    private void calculaPuntaje(){
        if((nivelCompletado*30-tiempo)<0){
            puntaje=nivelCompletado*10;
        }
        else{
            puntaje= nivelCompletado*10+(nivelCompletado*30-tiempo)*5;
        }
    }
    
    public int getPuntaje(){
        return puntaje;
    }

    public Integer getNivelCompletado() {
        return nivelCompletado;
    }

    public int getTiempo() {
        return tiempo;
    }
    
    
    public String mostrarPuntajeDetallado(){
        return "\nNivel completado: "+nivelCompletado+".\nTiempo transcurrido: "+tiem+" minutos.\nPuntaje obtenido: "+puntaje+".\n";
    }
   
}
