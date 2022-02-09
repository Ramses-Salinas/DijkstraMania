
package GUI;

import Clases.Historial;
import Clases.Jugador;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;


public class Inicio extends javax.swing.JPanel{

    Principal frame;
    Jugar jugar;
    static Historial historial=new Historial();
    DefaultTableModel tabla=new DefaultTableModel();
    
    public Inicio(Principal frame) {
        initComponents();
        this.frame=frame;
        tabla.addColumn("Jugador");
        tabla.addColumn("Puntaje");
        tabla.addColumn("Nivel alcanzado");
        tablePuntajes.setModel(tabla);
        actualizaTabla();
        jTA_Instruc.setText(historial.getInstrucciones());
        
    }
    
    public boolean iniciaJuego(){
        String nombreJ;
        nombreJ=JOptionPane.showInputDialog(null, "Nombre del jugador: ", "Registrate", 1);
        if(nombreJ!=null){
            jugar=new Jugar(nombreJ,frame,this);
            Principal.IniciaPanel(jugar);
            return true;
        }else{
            return false;
        }
    }
    
    public static void guardaPuntaje(){
        historial.guardarHistorial();
    }
    public void agregaHistoria(Jugador player){
        historial.nuevaHistoria(player);
        actualizaTabla();
    }
    private void actualizaTabla(){
        String [] player=new String [3];;
        int [] orden=historial.ordenAscendente();
        int max=tabla.getRowCount();
        for(int i=max-1; i>=0;i--){
            tabla.removeRow(i);
        }
        
        for(int i=0; i<historial.getJugadores().size();i++){
            player[0]=historial.getJugadores().get(orden[i]).getNombre();
            player[1]=historial.getJugadores().get(orden[i]).getPuntajeTotal().toString();
            player[2]=historial.getJugadores().get(orden[i]).getNivelAlcanzado().toString();
            tabla.addRow(player);
        }    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFOpciones = new javax.swing.JFrame();
        jTPPuntajes = new javax.swing.JTabbedPane();
        jPInstruc = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTA_Instruc = new javax.swing.JTextArea();
        jPPuntajes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePuntajes = new javax.swing.JTable();
        jBPuntajeDet = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jBJugar = new javax.swing.JButton();
        jBPuntajes = new javax.swing.JButton();
        jBCreditos = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        jBInstruc = new javax.swing.JButton();
        Solucion = new javax.swing.JLabel();

        jFOpciones.setBackground(new java.awt.Color(0, 0, 0));

        jTPPuntajes.setBackground(new java.awt.Color(0, 204, 204));
        jTPPuntajes.setForeground(new java.awt.Color(0, 0, 0));

        jPInstruc.setBackground(new java.awt.Color(102, 0, 153));

        jTA_Instruc.setEditable(false);
        jTA_Instruc.setBackground(new java.awt.Color(51, 51, 51));
        jTA_Instruc.setColumns(20);
        jTA_Instruc.setForeground(new java.awt.Color(255, 255, 255));
        jTA_Instruc.setRows(5);
        jScrollPane2.setViewportView(jTA_Instruc);

        javax.swing.GroupLayout jPInstrucLayout = new javax.swing.GroupLayout(jPInstruc);
        jPInstruc.setLayout(jPInstrucLayout);
        jPInstrucLayout.setHorizontalGroup(
            jPInstrucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPInstrucLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPInstrucLayout.setVerticalGroup(
            jPInstrucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPInstrucLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTPPuntajes.addTab("Instrucciones", jPInstruc);

        jPPuntajes.setBackground(new java.awt.Color(102, 0, 153));
        jPPuntajes.setForeground(new java.awt.Color(0, 0, 0));

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setForeground(new java.awt.Color(0, 255, 204));

        tablePuntajes.setBackground(new java.awt.Color(0, 0, 0));
        tablePuntajes.setForeground(new java.awt.Color(0, 255, 204));
        tablePuntajes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Jugador", "Puntaje", "Nivel alcanzado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePuntajes.setGridColor(new java.awt.Color(0, 255, 204));
        tablePuntajes.setSelectionBackground(new java.awt.Color(0, 102, 102));
        tablePuntajes.setSelectionForeground(new java.awt.Color(0, 255, 204));
        jScrollPane1.setViewportView(tablePuntajes);

        jBPuntajeDet.setBackground(new java.awt.Color(102, 102, 102));
        jBPuntajeDet.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 18)); // NOI18N
        jBPuntajeDet.setForeground(new java.awt.Color(0, 0, 0));
        jBPuntajeDet.setText("Ver puntaje detallado");
        jBPuntajeDet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPuntajeDetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPPuntajesLayout = new javax.swing.GroupLayout(jPPuntajes);
        jPPuntajes.setLayout(jPPuntajesLayout);
        jPPuntajesLayout.setHorizontalGroup(
            jPPuntajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
            .addGroup(jPPuntajesLayout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jBPuntajeDet)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPPuntajesLayout.setVerticalGroup(
            jPPuntajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPuntajesLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBPuntajeDet)
                .addGap(9, 9, 9))
        );

        jTPPuntajes.addTab("Puntajes", jPPuntajes);

        javax.swing.GroupLayout jFOpcionesLayout = new javax.swing.GroupLayout(jFOpciones.getContentPane());
        jFOpciones.getContentPane().setLayout(jFOpcionesLayout);
        jFOpcionesLayout.setHorizontalGroup(
            jFOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTPPuntajes)
        );
        jFOpcionesLayout.setVerticalGroup(
            jFOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTPPuntajes)
        );

        setBackground(new java.awt.Color(51, 51, 255));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setPreferredSize(new java.awt.Dimension(883, 576));

        jLabel1.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 0));
        jLabel1.setText("Dijkstra-Mania");

        jBJugar.setBackground(new java.awt.Color(51, 51, 255));
        jBJugar.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 24)); // NOI18N
        jBJugar.setForeground(new java.awt.Color(0, 255, 0));
        jBJugar.setText("Jugar");
        jBJugar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBJugarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBJugarMouseExited(evt);
            }
        });
        jBJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBJugarActionPerformed(evt);
            }
        });

        jBPuntajes.setBackground(new java.awt.Color(51, 51, 255));
        jBPuntajes.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 24)); // NOI18N
        jBPuntajes.setForeground(new java.awt.Color(0, 255, 0));
        jBPuntajes.setText("Puntajes");
        jBPuntajes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBPuntajesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBPuntajesMouseExited(evt);
            }
        });
        jBPuntajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPuntajesActionPerformed(evt);
            }
        });

        jBCreditos.setBackground(new java.awt.Color(51, 51, 255));
        jBCreditos.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 24)); // NOI18N
        jBCreditos.setForeground(new java.awt.Color(0, 255, 0));
        jBCreditos.setText("Créditos");
        jBCreditos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBCreditosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBCreditosMouseExited(evt);
            }
        });
        jBCreditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCreditosActionPerformed(evt);
            }
        });

        jBSalir.setBackground(new java.awt.Color(51, 51, 255));
        jBSalir.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 24)); // NOI18N
        jBSalir.setForeground(new java.awt.Color(0, 255, 0));
        jBSalir.setText("Salir");
        jBSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBSalirMouseExited(evt);
            }
        });
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        jBInstruc.setBackground(new java.awt.Color(51, 51, 255));
        jBInstruc.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 24)); // NOI18N
        jBInstruc.setForeground(new java.awt.Color(0, 255, 0));
        jBInstruc.setText("Instrucciones");
        jBInstruc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBInstrucMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBInstrucMouseExited(evt);
            }
        });
        jBInstruc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBInstrucActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(362, 362, 362)
                        .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(Solucion, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBJugar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBInstruc, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                            .addComponent(jBPuntajes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBCreditos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(jLabel1)))
                .addContainerGap(274, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(Solucion, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jBJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBInstruc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBPuntajes, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBJugarActionPerformed
        iniciaJuego();
    }//GEN-LAST:event_jBJugarActionPerformed

    private void jBPuntajeDetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPuntajeDetActionPerformed
        int jugador=tablePuntajes.getSelectedRow();
        String nombre;
        if(jugador==-1){
            JOptionPane.showMessageDialog(null, "Primero seleccione un jugador para ver su puntaje detallado.");
        }else{
            nombre=tablePuntajes.getValueAt(jugador,0).toString();
            for( Jugador j: historial.getJugadores()){
                if(j.getNombre().equals(nombre)){
                    JOptionPane.showMessageDialog(null, j.mostrarJugador());
                }else{
                    System.out.println("f");
                }
            }
        }
    }//GEN-LAST:event_jBPuntajeDetActionPerformed
    
    private void iniciaVentana(int i){
        jFOpciones.setSize(567, 450);
        jFOpciones.setVisible(true);
        jFOpciones.setLocationRelativeTo(null);
        jFOpciones.setResizable(false);
        jTPPuntajes.setSelectedIndex(i);
    }
    
    private void jBPuntajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPuntajesActionPerformed
        iniciaVentana(1);
    }//GEN-LAST:event_jBPuntajesActionPerformed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        int seguro=JOptionPane.showConfirmDialog(null, "¿Seguro que quieres salir?", "Salir",2);
        switch(seguro){
            case 0: 
                historial.guardarHistorial();
                System.exit(0);
                break;
        }
        
    }//GEN-LAST:event_jBSalirActionPerformed

    private void cambiaColor(int opcion, JButton boton){
        Color color1=new Color(51,51,255);
        Color color2=new Color(0,255,0);
        switch(opcion){
            case 1:
                boton.setBackground(color2);
                boton.setForeground(color1);
                break;
            case 2:
                boton.setBackground(color1);
                boton.setForeground(color2);
                break;
        }
    }
    
    private void jBJugarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBJugarMouseEntered
        cambiaColor(1,jBJugar);
    }//GEN-LAST:event_jBJugarMouseEntered

    private void jBJugarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBJugarMouseExited
        cambiaColor(2,jBJugar);
    }//GEN-LAST:event_jBJugarMouseExited

    private void jBInstrucMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBInstrucMouseEntered
        cambiaColor(1,jBInstruc);
    }//GEN-LAST:event_jBInstrucMouseEntered

    private void jBInstrucMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBInstrucMouseExited
        cambiaColor(2,jBInstruc);
    }//GEN-LAST:event_jBInstrucMouseExited

    private void jBPuntajesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBPuntajesMouseEntered
        cambiaColor(1,jBPuntajes);
    }//GEN-LAST:event_jBPuntajesMouseEntered

    private void jBPuntajesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBPuntajesMouseExited
        cambiaColor(2,jBPuntajes);
    }//GEN-LAST:event_jBPuntajesMouseExited

    private void jBCreditosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBCreditosMouseEntered
        cambiaColor(1,jBCreditos);
    }//GEN-LAST:event_jBCreditosMouseEntered

    private void jBCreditosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBCreditosMouseExited
        cambiaColor(2,jBCreditos);
    }//GEN-LAST:event_jBCreditosMouseExited

    private void jBSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBSalirMouseEntered
        cambiaColor(1,jBSalir);
    }//GEN-LAST:event_jBSalirMouseEntered

    private void jBSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBSalirMouseExited
        cambiaColor(2,jBSalir);
    }//GEN-LAST:event_jBSalirMouseExited

    private void jBCreditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCreditosActionPerformed
        String mensaje;
        mensaje="Salinas Mejías, Ramsés Alfonzo.\n";
        mensaje+="Ortiz Urbai, Sebastian.\n";
        mensaje+="Alvarez Huarsaya, Richard Saul.\n";
        mensaje+="Cano Carbajo, Yeyson Samir.\n";
        mensaje+="Chavez Campos, Jean Piere.\n";
        mensaje+="@UNMSM @FISI @2022";
        JOptionPane.showMessageDialog(null, mensaje, "Créditos:", 1);
    }//GEN-LAST:event_jBCreditosActionPerformed

    private void jBInstrucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBInstrucActionPerformed
        iniciaVentana(0);
    }//GEN-LAST:event_jBInstrucActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Solucion;
    private javax.swing.JButton jBCreditos;
    private javax.swing.JButton jBInstruc;
    private javax.swing.JButton jBJugar;
    private javax.swing.JButton jBPuntajeDet;
    private javax.swing.JButton jBPuntajes;
    private javax.swing.JButton jBSalir;
    private javax.swing.JFrame jFOpciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPInstruc;
    private javax.swing.JPanel jPPuntajes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTA_Instruc;
    private javax.swing.JTabbedPane jTPPuntajes;
    private javax.swing.JTable tablePuntajes;
    // End of variables declaration//GEN-END:variables
    
    private Image imagen;
     
    @Override
    public void paint(Graphics g){
        imagen=new ImageIcon(getClass().getResource("/Imagenes/estrellas.jpg")).getImage();
        g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
        setOpaque(false);
        super.paint(g);
    }
}
