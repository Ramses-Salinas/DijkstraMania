package Clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Historial {

    //Atributo
    ArrayList<Jugador> jugadores = new ArrayList<>();
    String instrucciones="";
    
    //Métodos
    public Historial() {
        try {
            FileInputStream archivo = null;
            ObjectInputStream lectorObjetos = null;

            archivo = new FileInputStream("Historial.txt");
            lectorObjetos = new ObjectInputStream(archivo);
            
            jugadores=(ArrayList<Jugador>) lectorObjetos.readObject();
            lectorObjetos.close();
            
            

        } catch (Exception ex) {
            System.out.println("Error en historial: " + ex);
        }

        try {
            
            File archivo2=new File("instrucciones.txt");
            FileReader lector=new FileReader(archivo2);
            BufferedReader lectura= new BufferedReader(lector);
            String cadena;
            cadena=lectura.readLine();
            while(cadena!=null){
                instrucciones+=cadena+"\r\n";
                cadena=lectura.readLine();
            }
            

        } catch (Exception ex) {
            System.out.println("Error en historial: " + ex);
        }
    }
    
    public void nuevaHistoria(Jugador juegador){
        jugadores.add(juegador);
    }
    
    public void guardarHistorial(){
        FileOutputStream archivo=null;
        ObjectOutputStream escritorObjetos=null;
        
        try {
            archivo=new FileOutputStream("Historial.txt");
            escritorObjetos=new ObjectOutputStream(archivo);
            
            escritorObjetos.writeObject(jugadores);
            escritorObjetos.close();
        } catch (Exception ex) {
            System.out.println("Error en historial: " + ex);
        }
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public String getInstrucciones() {
        return instrucciones;
    }
    
    public int[] ordenAscendente(){
        int [] orden;;
        int k=0;
        orden=new int [jugadores.size()];
        Jugador players[]=new Jugador[jugadores.size()];
        for(Jugador j: this.getJugadores()){
            players[k]=j;
            orden[k]=k;
            k++;
        }
        k=0;
        for(int i=0; i<jugadores.size(); i++){
            for(int j=1; j<jugadores.size(); j++){
                if(players[j-1].getPuntajeTotal()<players[j].getPuntajeTotal()){
                    Jugador aux;
                    int auxI;
                    aux=players[j-1];
                    players[j-1]=players[j];
                    players[j]=aux;
                    auxI=orden[j-1];
                    orden[j-1]=orden[j];
                    orden[j]=auxI;
                }
            }
        }
        return orden;
    }
    
}
