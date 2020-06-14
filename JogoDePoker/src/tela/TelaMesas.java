
package tela;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.MesaDePoker;
import model.Players;

public class TelaMesas extends javax.swing.JFrame {

   
    private MesaDePoker[] mesas= new MesaDePoker[5];
    private Campeonato camp;
    private Campeonato camp2;
    private Campeonato camp3;
    private Campeonato camp4;
    private Campeonato camp5;
    
    
    
    public TelaMesas() {
        initComponents();
        painelMesas.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        painelMesas = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        mesa1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMesa1 = new javax.swing.JTable();
        btnMesa1 = new javax.swing.JButton();
        mesa2 = new javax.swing.JPanel();
        btnMesa2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbMesa2 = new javax.swing.JTable();
        mesa3 = new javax.swing.JPanel();
        btnMesa3 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbMesa3 = new javax.swing.JTable();
        mesa4 = new javax.swing.JPanel();
        btnMesa4 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbMesa4 = new javax.swing.JTable();
        mesa5 = new javax.swing.JPanel();
        btnMesa5 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbMesa5 = new javax.swing.JTable();
        btnIniciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Mesas de Poker");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 22, -1, -1));

        tbMesa1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Jogador", "Stack"
            }
        ));
        jScrollPane1.setViewportView(tbMesa1);

        btnMesa1.setText("Atualizar");
        btnMesa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mesa1Layout = new javax.swing.GroupLayout(mesa1);
        mesa1.setLayout(mesa1Layout);
        mesa1Layout.setHorizontalGroup(
            mesa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mesa1Layout.createSequentialGroup()
                .addGroup(mesa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mesa1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mesa1Layout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addComponent(btnMesa1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        mesa1Layout.setVerticalGroup(
            mesa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mesa1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnMesa1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane2.addTab("Mesa 1", mesa1);

        btnMesa2.setText("Atualizar");
        btnMesa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa2ActionPerformed(evt);
            }
        });

        tbMesa2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Jogador", "Stack"
            }
        ));
        jScrollPane2.setViewportView(tbMesa2);

        javax.swing.GroupLayout mesa2Layout = new javax.swing.GroupLayout(mesa2);
        mesa2.setLayout(mesa2Layout);
        mesa2Layout.setHorizontalGroup(
            mesa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mesa2Layout.createSequentialGroup()
                .addGroup(mesa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mesa2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mesa2Layout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addComponent(btnMesa2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        mesa2Layout.setVerticalGroup(
            mesa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mesa2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnMesa2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane2.addTab("Mesa 2", mesa2);

        btnMesa3.setText("Atualizar");
        btnMesa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa3ActionPerformed(evt);
            }
        });

        tbMesa3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Jogador", "Stack"
            }
        ));
        jScrollPane3.setViewportView(tbMesa3);

        javax.swing.GroupLayout mesa3Layout = new javax.swing.GroupLayout(mesa3);
        mesa3.setLayout(mesa3Layout);
        mesa3Layout.setHorizontalGroup(
            mesa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mesa3Layout.createSequentialGroup()
                .addGroup(mesa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mesa3Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mesa3Layout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addComponent(btnMesa3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        mesa3Layout.setVerticalGroup(
            mesa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mesa3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnMesa3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane2.addTab("Mesa 3", mesa3);

        btnMesa4.setText("Atualizar");
        btnMesa4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa4ActionPerformed(evt);
            }
        });

        tbMesa4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Jogador", "Stack"
            }
        ));
        jScrollPane4.setViewportView(tbMesa4);

        javax.swing.GroupLayout mesa4Layout = new javax.swing.GroupLayout(mesa4);
        mesa4.setLayout(mesa4Layout);
        mesa4Layout.setHorizontalGroup(
            mesa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mesa4Layout.createSequentialGroup()
                .addGroup(mesa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mesa4Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mesa4Layout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addComponent(btnMesa4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        mesa4Layout.setVerticalGroup(
            mesa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mesa4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnMesa4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane2.addTab("Mesa 4", mesa4);

        btnMesa5.setText("Atualizar");
        btnMesa5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa5ActionPerformed(evt);
            }
        });

        tbMesa5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Jogador", "Stack"
            }
        ));
        jScrollPane5.setViewportView(tbMesa5);

        javax.swing.GroupLayout mesa5Layout = new javax.swing.GroupLayout(mesa5);
        mesa5.setLayout(mesa5Layout);
        mesa5Layout.setHorizontalGroup(
            mesa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mesa5Layout.createSequentialGroup()
                .addGroup(mesa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mesa5Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mesa5Layout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addComponent(btnMesa5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        mesa5Layout.setVerticalGroup(
            mesa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mesa5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnMesa5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane2.addTab("Mesa 5", mesa5);

        javax.swing.GroupLayout painelMesasLayout = new javax.swing.GroupLayout(painelMesas);
        painelMesas.setLayout(painelMesasLayout);
        painelMesasLayout.setHorizontalGroup(
            painelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMesasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        painelMesasLayout.setVerticalGroup(
            painelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMesasLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        getContentPane().add(painelMesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 72, -1, -1));

        btnIniciar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnIniciar.setText("Iniciar game");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 11, -1, 55));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
 
    
    
    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed

        mesas[0]= new MesaDePoker();
        mesas[1]= new MesaDePoker();
        mesas[2]= new MesaDePoker();
        mesas[3]= new MesaDePoker();
        mesas[4]= new MesaDePoker();

        camp=new Campeonato(mesas[0], 1);
        camp2=new Campeonato(mesas[1], 2);
        camp3=new Campeonato(mesas[2], 3);
        camp4=new Campeonato(mesas[3], 4);
        camp5=new Campeonato(mesas[4], 5);
        
        
        Thread t1= new Thread(camp);
        t1.start();
         
        Thread t2= new Thread(camp2);
        t2.start(); 
        
        Thread t3= new Thread(camp3);
        t3.start();
        
        Thread t4= new Thread(camp4);
        t4.start();
        
        Thread t5= new Thread(camp5);
        t5.start();
        
        painelMesas.setVisible(true);
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnMesa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa1ActionPerformed
        
        Players p=new Players();
        
        DefaultTableModel modelo = (DefaultTableModel) tbMesa1.getModel();
        modelo.setNumRows(0);
        
        for (int i = 0; i < this.camp.getPlayersNaMesaAtual().size(); i++) {
            p = (Players) this.camp.getPlayersNaMesaAtual().get(i);
            
            Vector linha = new Vector();
            linha.add(p.getNome());
            linha.add(p.getStack());  
            modelo.addRow(linha);
            
            modelo.setColumnCount(2);
        }
        
    }//GEN-LAST:event_btnMesa1ActionPerformed

    private void btnMesa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa2ActionPerformed
         Players p=new Players();
        
        DefaultTableModel modelo = (DefaultTableModel) tbMesa2.getModel();
        modelo.setNumRows(0);
        
        for (int i = 0; i < this.camp2.getPlayersNaMesaAtual().size(); i++) {
            p = (Players) this.camp2.getPlayersNaMesaAtual().get(i);
            
            Vector linha = new Vector();
            linha.add(p.getNome());
            linha.add(p.getStack());  
            modelo.addRow(linha);
            
            modelo.setColumnCount(2);
        }
    }//GEN-LAST:event_btnMesa2ActionPerformed

    private void btnMesa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa3ActionPerformed
         Players p=new Players();
        
        DefaultTableModel modelo = (DefaultTableModel) tbMesa3.getModel();
        modelo.setNumRows(0);
        
        for (int i = 0; i < this.camp3.getPlayersNaMesaAtual().size(); i++) {
            p = (Players) this.camp3.getPlayersNaMesaAtual().get(i);
            
            Vector linha = new Vector();
            linha.add(p.getNome());
            linha.add(p.getStack());  
            modelo.addRow(linha);
            
            modelo.setColumnCount(2);
        }
    }//GEN-LAST:event_btnMesa3ActionPerformed

    private void btnMesa4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa4ActionPerformed
        Players p=new Players();
        
        DefaultTableModel modelo = (DefaultTableModel) tbMesa4.getModel();
        modelo.setNumRows(0);
        
        for (int i = 0; i < this.camp4.getPlayersNaMesaAtual().size(); i++) {
            p = (Players) this.camp4.getPlayersNaMesaAtual().get(i);
            
            Vector linha = new Vector();
            linha.add(p.getNome());
            linha.add(p.getStack());  
            modelo.addRow(linha);
            
            modelo.setColumnCount(2);
        }
    }//GEN-LAST:event_btnMesa4ActionPerformed

    private void btnMesa5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa5ActionPerformed
         Players p;
        
        DefaultTableModel modelo = (DefaultTableModel) tbMesa5.getModel();
        modelo.setNumRows(0);
        
        for (int i = 0; i < this.camp5.getPlayersNaMesaAtual().size(); i++) {
            p = (Players) this.camp5.getPlayersNaMesaAtual().get(i);
            
            Vector linha = new Vector();
            linha.add(p.getNome());
            linha.add(p.getStack());  
            modelo.addRow(linha);
            
            modelo.setColumnCount(2);
        }
    }//GEN-LAST:event_btnMesa5ActionPerformed

 
    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMesas().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnMesa1;
    private javax.swing.JButton btnMesa2;
    private javax.swing.JButton btnMesa3;
    private javax.swing.JButton btnMesa4;
    private javax.swing.JButton btnMesa5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JPanel mesa1;
    private javax.swing.JPanel mesa2;
    private javax.swing.JPanel mesa3;
    private javax.swing.JPanel mesa4;
    private javax.swing.JPanel mesa5;
    private javax.swing.JPanel painelMesas;
    private javax.swing.JTable tbMesa1;
    private javax.swing.JTable tbMesa2;
    private javax.swing.JTable tbMesa3;
    private javax.swing.JTable tbMesa4;
    private javax.swing.JTable tbMesa5;
    // End of variables declaration//GEN-END:variables
}
