package leadmyteam;

public class Szczegoly extends javax.swing.JFrame {

    private LeadMyTeam leadMyTeam;
    
    public Szczegoly(LeadMyTeam lmt) {
        this.leadMyTeam = lmt;
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        //setAlwaysOnTop(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        CloseButton = new javax.swing.JButton();
        AddButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        jComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Szczegóły");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Pesel", "Nazwisko"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        CloseButton.setText("Zamknij");
        CloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseButtonActionPerformed(evt);
            }
        });

        AddButton.setText("Dodaj uczestnika");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        DeleteButton.setText("Usuń uczestnika");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        jComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "PESEL", "Nazwisko" }));
        jComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setText(" Sortowanie :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(AddButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DeleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CloseButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(AddButton)
                        .addGap(18, 18, 18)
                        .addComponent(DeleteButton)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CloseButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseButtonActionPerformed
        dispose();
    }//GEN-LAST:event_CloseButtonActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        // TODO
    }//GEN-LAST:event_AddButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void jComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxActionPerformed
        switch (jComboBox.getSelectedItem().toString()) {
            case "PESEL":
                //TODO:
                //Odswiezanie
                //Sortowanie
                break;

            case "Nazwisko":
                //TODO:
                //Odswiezanie
                //Sortowanie
                break;
        }
    }//GEN-LAST:event_jComboBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Szczegoly.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Szczegoly.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Szczegoly.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Szczegoly.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton CloseButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JComboBox<String> jComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
