
package tela;

import model.MesaDePoker;

public class TelaMesas extends javax.swing.JFrame {

   
    private MesaDePoker[] mesas= new MesaDePoker[5];
    
    
    
    public TelaMesas() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        mesa1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        mesa2 = new javax.swing.JPanel();
        mesa3 = new javax.swing.JPanel();
        mesa4 = new javax.swing.JPanel();
        mesa5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Mesas de Poker");

        btnIniciar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnIniciar.setText("Iniciar game");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table1);

        javax.swing.GroupLayout mesa1Layout = new javax.swing.GroupLayout(mesa1);
        mesa1.setLayout(mesa1Layout);
        mesa1Layout.setHorizontalGroup(
            mesa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mesa1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        mesa1Layout.setVerticalGroup(
            mesa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mesa1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Mesa 1", mesa1);

        javax.swing.GroupLayout mesa2Layout = new javax.swing.GroupLayout(mesa2);
        mesa2.setLayout(mesa2Layout);
        mesa2Layout.setHorizontalGroup(
            mesa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 664, Short.MAX_VALUE)
        );
        mesa2Layout.setVerticalGroup(
            mesa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 243, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Mesa 2", mesa2);

        javax.swing.GroupLayout mesa3Layout = new javax.swing.GroupLayout(mesa3);
        mesa3.setLayout(mesa3Layout);
        mesa3Layout.setHorizontalGroup(
            mesa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 664, Short.MAX_VALUE)
        );
        mesa3Layout.setVerticalGroup(
            mesa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 243, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Mesa 3", mesa3);

        javax.swing.GroupLayout mesa4Layout = new javax.swing.GroupLayout(mesa4);
        mesa4.setLayout(mesa4Layout);
        mesa4Layout.setHorizontalGroup(
            mesa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 664, Short.MAX_VALUE)
        );
        mesa4Layout.setVerticalGroup(
            mesa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 243, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Mesa 4", mesa4);

        javax.swing.GroupLayout mesa5Layout = new javax.swing.GroupLayout(mesa5);
        mesa5.setLayout(mesa5Layout);
        mesa5Layout.setHorizontalGroup(
            mesa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 664, Short.MAX_VALUE)
        );
        mesa5Layout.setVerticalGroup(
            mesa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 243, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Mesa 5", mesa5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnIniciar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
 
    
    
    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        
        
        mesas[0]= new MesaDePoker();
        mesas[1]= new MesaDePoker();
        mesas[2]= new MesaDePoker();
        mesas[3]= new MesaDePoker();
        mesas[4]= new MesaDePoker();
        
        
        
        Campeonato camp=new Campeonato(mesas[0], 1);
        Thread t1= new Thread(camp);
        t1.start();
        
        Campeonato camp2=new Campeonato(mesas[1], 2);
        Thread t2= new Thread(camp2);
        t2.start();
        
         Campeonato camp3=new Campeonato(mesas[2], 3);
        Thread t3= new Thread(camp3);
        t3.start();
        
        Campeonato camp4=new Campeonato(mesas[3], 4);
        Thread t4= new Thread(camp4);
        t4.start();
        
        Campeonato camp5=new Campeonato(mesas[4], 5);
        Thread t5= new Thread(camp5);
        t5.start();
         
         
        
    }//GEN-LAST:event_btnIniciarActionPerformed

 
    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMesas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JPanel mesa1;
    private javax.swing.JPanel mesa2;
    private javax.swing.JPanel mesa3;
    private javax.swing.JPanel mesa4;
    private javax.swing.JPanel mesa5;
    private javax.swing.JTable table1;
    // End of variables declaration//GEN-END:variables
}
