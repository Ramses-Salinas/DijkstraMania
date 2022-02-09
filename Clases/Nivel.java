
package Clases;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.Random;

public class Nivel implements Serializable{
    //Atributos
    Integer ordenNivel;
    int numVertices;
    int [][] matrizPesos;
    boolean [][] matrizConexion; //Almacena qué vertices se conectan
    String solucion; //Almacena la solución devuelta por el algoritmo de Dijkstra
    String camino;// Almacena el camino trazado por el jugador
    Graphics g;
    Vertice [] ver;//Almacena los datos de cada vertice del grafo
    
    //Métodos
    public Nivel(int ordenNivel, Graphics g){
        this.numVertices=ordenNivel+4;
        this.ordenNivel=ordenNivel;
        this.g=g;
        matrizPesos=new int [numVertices][numVertices];
        matrizConexion=new boolean[numVertices][numVertices];
        ver=new Vertice[numVertices];
    }
    
    private void creaMatrices(){
        Random r= new Random(System.currentTimeMillis());
        int conecta;//0: no conecta; 1: sí concecta;
        for(int i=0; i<numVertices; i++){
            for(int j=0; j<numVertices; j++){
                if(j==i){
                    matrizPesos[i][j]=0;
                    matrizConexion[i][j]=false;
                }else if(j<i){
                    if(j==0||i==numVertices-1){
                        if(j==0&&i==numVertices-1){
                            conecta=0;
                        }else{
                            if(j==0){
                                if(i%2==0){
                                    conecta=1;
                                }else{
                                    conecta=0;
                                }
                            }else{
                                if(j%2==1){
                                    conecta=1;
                                }else{
                                    conecta=0;
                                }
                            }
                            
                        }
                    }else{
                        conecta=r.nextInt(2);
                    }                    
                    if(conecta==0){
                        matrizPesos[i][j]=1000;
                        matrizConexion[i][j]=false;
                    }else if(conecta==1){
                        matrizPesos[i][j]=(int)(r.nextDouble()*51)+1;
                        matrizConexion[i][j]=true;
                    }
                }
            }
        }
        for(int i=0; i<numVertices; i++){
            for(int j=0; j<numVertices; j++){
                if(j>i){
                    matrizPesos[i][j]=matrizPesos[j][i];
                }
            }
        }
    }
    
    public void creaGrafo(){
        Random r=new Random();
        int ordenI;
        int x;
        int y;
        String caracterAsociado;
        creaMatrices();
        //Dibuja vertices
        g.setColor(Color.white);
        for(int i=0; i<numVertices; i++){
            ordenI=i;
            caracterAsociado=Character.toString(65+i);
            boolean cercano;
            do{
                cercano=false;
                if(i==0){
                    x=10;
                    y=225;
                }else if(i==numVertices-1){
                    x=r.nextInt(i*28+20)+(i-1)*28+25;
                    y=225;
                }else{
                    x=r.nextInt(i*28+20)+(i-1)*28+25;
                    y=r.nextInt(200)+50*(1-(i%2))+(i%2)*200;
                    for(int j=0; j<i;j++){
                        int diferenciaY;
                        int diferenciaX;
                        diferenciaY=ver[j].coorY-y;
                        diferenciaX=ver[j].coorX-x;
                        if(20>diferenciaY&&diferenciaY>-20||10>diferenciaX&&diferenciaX>-10){
                            cercano=true;
                        }
                    }
                }
            }while(cercano);
            ver[i]=new Vertice(ordenI,caracterAsociado,x,y);
            g.fillOval(x,y,12,12);
            g.drawString(ver[i].caracterAsociado,x+12,y+12);
        }
        //Dibuja Aristas
        for(int i=0; i<numVertices; i++){
            for(int j=0; j<numVertices; j++){
                if(matrizConexion[i][j]){
                    Color colorL=new Color(0,153,0);
                    Color colorN=new Color(255,51,51);
                    g.setColor(colorL);
                    g.drawLine(ver[i].coorX+5,ver[i].coorY+5,ver[j].coorX+5,ver[j].coorY+5);//Aristas
                    g.setColor(colorN);
                    g.drawString(""+matrizPesos[i][j],(ver[i].coorX+ver[j].coorX+10)/2-1,(ver[i].coorY+ver[j].coorY+10)/2-1);//Pesos
                }
            }
        }
    }

    public void clearRect(int x, int y, int alto, int ancho){
        g.clearRect(x,y,alto,ancho);
    }
    
    public String[] caracterVertices(){
        String [] caracteres= new String [numVertices];
        for(int i=0; i<numVertices; i++){
            caracteres[i]=ver[i].caracterAsociado;
        }
        return caracteres;
    }
    
    public String solucionNivel(){
        return Dijkstra.obtenerCaminoMinimo(numVertices, matrizPesos,ver);
    }
    
}
