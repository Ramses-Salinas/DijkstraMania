package Clases;

public class Dijkstra {
    private static int numVertices;  // numero de vertices del grafo
    private static int matrizPesos[][];  //matriz que almacena las distancias entre nodos
    private static int nodosSecuencia[];  ////matriz que alamacena por posicion la secuencia de nodos que conforman un camino minimo
    private static int distancias[];  //matriz que almacena las menores distancias a cada nodo desde el inicial
    private static boolean nodosValidos[];  //matriz que mantiene registro de los nodos ya recorridos
    
    private static void hallarCaminoSecuencia(){ //Halla el camino más corto y lo almacena como secuencia de vertices
        //Instanciamos los vectores a usar
        nodosSecuencia=new int[numVertices];
        distancias=new int[numVertices];
        nodosValidos=new boolean[numVertices];
        //Establecemos valores iniciales
        for (int i = 0; i < numVertices; i++) {
            nodosSecuencia[i]=0;
            distancias[i]=matrizPesos[0][i];
            nodosValidos[i]=false;
        }
        nodosValidos[0]=true;
        for (int i = 0; i < numVertices; i++) {
            int sv = posMinimo();  //Se evalua en cada ciclo el menor camino que se haya registrado previamente
            nodosValidos[sv]=true;  
            for (int j = 1; j < numVertices; j++) {
                if(!nodosValidos[j]){
                    if(distancias[sv]+matrizPesos[sv][j]<distancias[j]){  //Se comparan las nuevas opciones de menor camino
                       distancias[j]= distancias[sv]+matrizPesos[sv][j];  //Se asigna un nuevo camino menor
                       nodosSecuencia[j]=sv;  //Se almacena la secuencia de nodos necesarios para llegar a un nodo con distancia minima
                    }
                }
            }
        }
        
    }
    private static int posMinimo(){  //Devuelve la posicion del nodo a menor distancia
        int minPos = 0;
        int max = 1000;  //Valor maximo que representa los nodos no conectados
        for (int i = 0; i < numVertices; i++) {
            if (!nodosValidos[i]) {
                if (distancias[i]<max) {
                    max=distancias[i];
                    minPos=i;
                }
            }
        }
        return minPos;
    }
    public static String obtenerCaminoMinimo(int nvert, int pesos[][], Vertice ver[]){//Devuelve el camino mínimo
        String solucion="";
        int nodo=0;
        numVertices=nvert;
        matrizPesos=pesos;
        hallarCaminoSecuencia();
        //Ordenando la secuencia en un string
        nodo=numVertices-1;
        solucion=ver[nodo].caracterAsociado;
        while (nodo!=0) {
            nodo = nodosSecuencia[nodo];
            solucion=ver[nodo].caracterAsociado+"-"+solucion;
        }
        return solucion;
    }
}
