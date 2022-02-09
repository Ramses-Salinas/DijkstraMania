
package GUI;

import Clases.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Jugar extends javax.swing.JPanel implements ActionListener{

    Nivel nivel;
    String respuesta="";
    int ordenNivel=1;
    Timer timer;
    int tiempo=0;
    boolean pasaNivel=false;
    Jugador player;
    Principal frame;
    Inicio inicio;
    int intentos=3;
    int nivelMax=26;
    
    public Jugar(String nombreJugador, Principal frame, Inicio inicio) {
        initComponents();
        this.frame=frame;
        this.inicio=inicio;
        timer=new Timer(1000,this);
        jBSiguienteN.setVisible(false);
        jBComprobar.setVisible(false);
        jBRedibujar.setVisible(false);
        player=new Jugador(nombreJugador);
        jLNJugador.setText("Jugador: "+nombreJugador);
        
    }
    
    
    public void actionPerformed(ActionEvent e) {
        int segundos;
        int minutos;
        tiempo++;
        segundos=tiempo%60;
        minutos=tiempo/60;
        jLCronometro.setText(minutos+" : "+segundos);
    }
    
    private void dibujar(){
        nivel.clearRect(0,25,640,425);
        nivel.creaGrafo();
        jCB_Orden.removeAllItems();
        for(String caracter: nivel.caracterVertices()){
            if(!caracter.equals("A")){
                jCB_Orden.addItem(caracter);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFTerminarP = new javax.swing.JFrame();
        jBVolverM = new javax.swing.JButton();
        jBSalirJ = new javax.swing.JButton();
        jBIniciarNV = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLONivel = new javax.swing.JLabel();
        jLCronometro = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jCB_Orden = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTRespuesta = new javax.swing.JTextField();
        jBTerminar = new javax.swing.JButton();
        jBSiguienteN = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLPuntaje = new javax.swing.JLabel();
        papel = new javax.swing.JPanel();
        jLNJugador = new javax.swing.JLabel();
        jBComprobar = new javax.swing.JButton();
        jBEmpezar = new javax.swing.JButton();
        jBRedibujar = new javax.swing.JButton();

        jFTerminarP.setUndecorated(true);
        jFTerminarP.getContentPane().setLayout(null);

        jBVolverM.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 18)); // NOI18N
        jBVolverM.setText("Volver al menú");
        jBVolverM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVolverMActionPerformed(evt);
            }
        });
        jFTerminarP.getContentPane().add(jBVolverM);
        jBVolverM.setBounds(60, 60, 170, 31);

        jBSalirJ.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 18)); // NOI18N
        jBSalirJ.setText("Salir del juego");
        jBSalirJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirJActionPerformed(evt);
            }
        });
        jFTerminarP.getContentPane().add(jBSalirJ);
        jBSalirJ.setBounds(60, 110, 170, 31);

        jBIniciarNV.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 18)); // NOI18N
        jBIniciarNV.setText("Iniciar nueva partida");
        jBIniciarNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBIniciarNVActionPerformed(evt);
            }
        });
        jFTerminarP.getContentPane().add(jBIniciarNV);
        jBIniciarNV.setBounds(31, 166, 220, 31);

        jBCancelar.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 18)); // NOI18N
        jBCancelar.setText("Cancelar");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });
        jFTerminarP.getContentPane().add(jBCancelar);
        jBCancelar.setBounds(100, 240, 100, 31);

        jLabel1.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Terminar y...");
        jFTerminarP.getContentPane().add(jLabel1);
        jLabel1.setBounds(82, 15, 156, 30);

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jFTerminarP.getContentPane().add(jSeparator1);
        jSeparator1.setBounds(260, 10, 20, 210);

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jFTerminarP.getContentPane().add(jSeparator2);
        jSeparator2.setBounds(20, 10, 240, 10);

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jFTerminarP.getContentPane().add(jSeparator3);
        jSeparator3.setBounds(20, 10, 20, 210);

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jFTerminarP.getContentPane().add(jSeparator4);
        jSeparator4.setBounds(20, 220, 240, 10);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 286, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 286, Short.MAX_VALUE)
        );

        jFTerminarP.getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 290, 290);

        setBackground(new java.awt.Color(255, 204, 204));
        setLayout(null);

        jLONivel.setBackground(new java.awt.Color(0, 0, 0));
        jLONivel.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 24)); // NOI18N
        jLONivel.setForeground(new java.awt.Color(0, 204, 0));
        jLONivel.setText("1");
        add(jLONivel);
        jLONivel.setBounds(789, 29, 39, 30);

        jLCronometro.setBackground(new java.awt.Color(0, 0, 0));
        jLCronometro.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 24)); // NOI18N
        jLCronometro.setForeground(new java.awt.Color(0, 204, 0));
        jLCronometro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(jLCronometro);
        jLCronometro.setBounds(682, 164, 160, 40);

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 0));
        jLabel3.setText("Nivel: ");
        add(jLabel3);
        jLabel3.setBounds(685, 30, 84, 30);

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 204, 0));
        jLabel4.setText("Escoger orden:");
        add(jLabel4);
        jLabel4.setBounds(700, 220, 140, 23);

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 204, 0));
        jLabel5.setText("Crónometro:");
        add(jLabel5);
        jLabel5.setBounds(708, 132, 120, 23);

        jCB_Orden.setBackground(new java.awt.Color(51, 0, 255));
        jCB_Orden.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 18)); // NOI18N
        jCB_Orden.setForeground(new java.awt.Color(0, 204, 0));
        add(jCB_Orden);
        jCB_Orden.setBounds(690, 260, 154, 34);

        jButton1.setBackground(new java.awt.Color(51, 0, 255));
        jButton1.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 204, 0));
        jButton1.setText("Seleccionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(710, 300, 120, 26);

        jButton2.setBackground(new java.awt.Color(51, 0, 255));
        jButton2.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 204, 0));
        jButton2.setText("Borrar selección");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(690, 340, 160, 26);

        jTRespuesta.setEditable(false);
        jTRespuesta.setBackground(new java.awt.Color(51, 0, 255));
        jTRespuesta.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 18)); // NOI18N
        jTRespuesta.setForeground(new java.awt.Color(0, 204, 0));
        jTRespuesta.setText("A-...-Z");
        add(jTRespuesta);
        jTRespuesta.setBounds(680, 380, 185, 31);

        jBTerminar.setBackground(new java.awt.Color(51, 0, 255));
        jBTerminar.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 18)); // NOI18N
        jBTerminar.setForeground(new java.awt.Color(0, 204, 0));
        jBTerminar.setText("Terminar partida");
        jBTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTerminarActionPerformed(evt);
            }
        });
        add(jBTerminar);
        jBTerminar.setBounds(14, 493, 190, 57);

        jBSiguienteN.setBackground(new java.awt.Color(51, 0, 255));
        jBSiguienteN.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 18)); // NOI18N
        jBSiguienteN.setForeground(new java.awt.Color(0, 204, 0));
        jBSiguienteN.setText("Siguiente Nivel");
        jBSiguienteN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSiguienteNActionPerformed(evt);
            }
        });
        add(jBSiguienteN);
        jBSiguienteN.setBounds(660, 490, 198, 57);

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 204, 0));
        jLabel6.setText("Puntaje acumulado:");
        add(jLabel6);
        jLabel6.setBounds(364, 480, 190, 23);

        jLPuntaje.setBackground(new java.awt.Color(0, 0, 0));
        jLPuntaje.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 18)); // NOI18N
        jLPuntaje.setForeground(new java.awt.Color(0, 204, 0));
        jLPuntaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLPuntaje.setText("0");
        add(jLPuntaje);
        jLPuntaje.setBounds(364, 509, 162, 23);

        papel.setBackground(new java.awt.Color(0, 0, 0));
        papel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLNJugador.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 18)); // NOI18N
        jLNJugador.setForeground(new java.awt.Color(255, 255, 255));
        jLNJugador.setText("Jugador: ");

        javax.swing.GroupLayout papelLayout = new javax.swing.GroupLayout(papel);
        papel.setLayout(papelLayout);
        papelLayout.setHorizontalGroup(
            papelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(papelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLNJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        papelLayout.setVerticalGroup(
            papelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(papelLayout.createSequentialGroup()
                .addComponent(jLNJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(415, Short.MAX_VALUE))
        );

        add(papel);
        papel.setBounds(6, 6, 640, 450);

        jBComprobar.setBackground(new java.awt.Color(51, 0, 255));
        jBComprobar.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 14)); // NOI18N
        jBComprobar.setForeground(new java.awt.Color(0, 204, 0));
        jBComprobar.setText("Listo!");
        jBComprobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBComprobarActionPerformed(evt);
            }
        });
        add(jBComprobar);
        jBComprobar.setBounds(710, 430, 120, 26);

        jBEmpezar.setBackground(new java.awt.Color(51, 0, 255));
        jBEmpezar.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 18)); // NOI18N
        jBEmpezar.setForeground(new java.awt.Color(0, 204, 0));
        jBEmpezar.setText("Empezar");
        jBEmpezar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEmpezarActionPerformed(evt);
            }
        });
        add(jBEmpezar);
        jBEmpezar.setBounds(650, 70, 110, 51);

        jBRedibujar.setBackground(new java.awt.Color(51, 0, 255));
        jBRedibujar.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 18)); // NOI18N
        jBRedibujar.setForeground(new java.awt.Color(0, 204, 0));
        jBRedibujar.setText("Redibujar");
        jBRedibujar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRedibujarActionPerformed(evt);
            }
        });
        add(jBRedibujar);
        jBRedibujar.setBounds(770, 70, 120, 51);
    }// </editor-fold>//GEN-END:initComponents

    private void jBSiguienteNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSiguienteNActionPerformed
        nivel.clearRect(0,25,640,425);
        ordenNivel++;
        respuesta="";
        tiempo=0;
        jLONivel.setText(ordenNivel+"");
        jBEmpezar.setVisible(true);
        jBRedibujar.setVisible(false);
        jBSiguienteN.setVisible(false);
        jTRespuesta.setText("A-...-Z");
    }//GEN-LAST:event_jBSiguienteNActionPerformed

    private void jBEmpezarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEmpezarActionPerformed
        Nivel nivelAc=new Nivel(ordenNivel,papel.getGraphics());
        nivel=nivelAc;
        dibujar();
        jBRedibujar.setVisible(true);
        jBEmpezar.setVisible(false);
        jBComprobar.setVisible(true);
        timer.start();
    }//GEN-LAST:event_jBEmpezarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(!jTRespuesta.getText().equals("A-...-Z")){
            respuesta=jTRespuesta.getText();
        }else{
            respuesta="A";
        }
        respuesta+="-"+jCB_Orden.getSelectedItem();
        jTRespuesta.setText(respuesta);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTRespuesta.setText("A-...-Z");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jBComprobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBComprobarActionPerformed
        String solucion=nivel.solucionNivel();
        if(respuesta.equals(solucion)){
            timer.stop();
            JOptionPane.showMessageDialog(null, "Correcto!\nRespuesta correcta: "+solucion+"\nRespuesta dada: "+respuesta);
            jBSiguienteN.setVisible(true);
            jBRedibujar.setVisible(false);
            jBComprobar.setVisible(false);
            PuntajeNivel puntaje=new PuntajeNivel(nivel,tiempo);
            player.agregarPuntajeDeNivel(puntaje);
            jLPuntaje.setText(""+player.calculaPuntajeAcumulado());
        }else{
            intentos--;
            JOptionPane.showMessageDialog(null, "Incorrecto! "+
                                            "\nRespuesta dada: "+respuesta+
                                            "\nIntentos restantes: "+intentos);
        }
        if(intentos==0){
            JOptionPane.showMessageDialog(null,"PERDISTEEEEEEE :CCCCCCCC\n"+
                                            "A ver ese puntaje 0.0\n"+
                                            "Jugador: "+player.getNombre()+".\n"+
                                            "Puntaje total: "+player.getPuntajeTotal()+".\n"+
                                            "Último nivel superado: "+player.getNivelAlcanzado()+".\n");
            terminar(true);
        }
        if(ordenNivel==nivelMax){
            JOptionPane.showMessageDialog(null,"Que grande, ya no hay más niveles\n"+
                                            "Veamos tu puntaje, crack\n"+
                                            "Jugador: "+player.getNombre()+".\n"+
                                            "Puntaje total: "+player.getPuntajeTotal()+".\n"+
                                            "Último nivel superado: "+player.getNivelAlcanzado()+".\n");
            terminar(true);
        }
        jTRespuesta.setText("A-...-Z");
    }//GEN-LAST:event_jBComprobarActionPerformed

    private void jBRedibujarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRedibujarActionPerformed
        dibujar();
    }//GEN-LAST:event_jBRedibujarActionPerformed

    private void jBTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTerminarActionPerformed
        terminar(false);        
    }//GEN-LAST:event_jBTerminarActionPerformed

    private void terminar(boolean perdiste){
        for(int i=0; i<2;i++){
            frame.bloquear(true);
            jFTerminarP.setLocationRelativeTo(null);
            jFTerminarP.setSize(286, 290);
            jFTerminarP.setVisible(false);
            jFTerminarP.setVisible(true);
        }
        if(perdiste){
            jBCancelar.setEnabled(false);
        }
    }
    
    private void jBVolverMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVolverMActionPerformed
        guardaPartida();
        Principal.IniciaPanel(inicio);
        jFTerminarP.setVisible(false);
        frame.bloquear(false);
    }//GEN-LAST:event_jBVolverMActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        jFTerminarP.setVisible(false);
        frame.bloquear(false);
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jBSalirJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirJActionPerformed
        guardaPartida();
        Inicio.guardaPuntaje();
        System.exit(0);
    }//GEN-LAST:event_jBSalirJActionPerformed

    private void jBIniciarNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBIniciarNVActionPerformed
        boolean confirma;
        guardaPartida();
        jFTerminarP.setVisible(false);
        frame.bloquear(false);
        confirma=inicio.iniciaJuego();
        if(!confirma){
            frame.bloquear(true);
            jFTerminarP.setVisible(true);
        }
    }//GEN-LAST:event_jBIniciarNVActionPerformed
    
    private void guardaPartida(){
        int puntaje;
        puntaje=player.calculaPuntajeAcumulado();
        if(puntaje>0){
            inicio.agregaHistoria(player);
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBComprobar;
    private javax.swing.JButton jBEmpezar;
    private javax.swing.JButton jBIniciarNV;
    private javax.swing.JButton jBRedibujar;
    private javax.swing.JButton jBSalirJ;
    private javax.swing.JButton jBSiguienteN;
    private javax.swing.JButton jBTerminar;
    private javax.swing.JButton jBVolverM;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jCB_Orden;
    private javax.swing.JFrame jFTerminarP;
    private javax.swing.JLabel jLCronometro;
    private javax.swing.JLabel jLNJugador;
    private javax.swing.JLabel jLONivel;
    private javax.swing.JLabel jLPuntaje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField jTRespuesta;
    private javax.swing.JPanel papel;
    // End of variables declaration//GEN-END:variables

    private Image imagen;
     
    @Override
    public void paint(Graphics g){
        imagen=new ImageIcon(getClass().getResource("/Imagenes/estrellas2.jpg")).getImage();
        g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
        setOpaque(false);
        super.paint(g);
    }
}
