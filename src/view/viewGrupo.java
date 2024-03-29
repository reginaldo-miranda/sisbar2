
package view;

import controle.GrupoControle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MoGrupo;


public class viewGrupo extends javax.swing.JFrame {

    GrupoControle controle = new GrupoControle();
    MoGrupo mogrupo = new MoGrupo();
    Integer recebeId;
    String idexistente = "";

    public viewGrupo() {
        initComponents();
        carregarDados();
        jTextField1.setEditable(false);
    }

    public void carregarDados() {
        DefaultTableModel modelo = (DefaultTableModel) jTableViewGrupo.getModel();
        modelo.setRowCount(0);
        for (MoGrupo grupo : controle.carregaGrupo()) {
            modelo.addRow(new Object[]{grupo.getId(), grupo.getDESCRICAO(), grupo.getDESCONTO()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButtonSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNomeGrupo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldDesconto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableViewGrupo = new javax.swing.JTable();
        jButtonGravar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Grupo");

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jLabel1.setText("Grupo");

        jTextFieldNomeGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeGrupoActionPerformed(evt);
            }
        });

        jLabel2.setText("Desconto ");

        jTableViewGrupo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descricao", "% Desconto"
            }
        ));
        jTableViewGrupo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableViewGrupoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableViewGrupo);

        jButtonGravar.setText("Gravar");
        jButtonGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGravarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSair))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jTextFieldNomeGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldDesconto, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonGravar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonExcluir)))
                        .addGap(0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSair))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNomeGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGravar)
                    .addComponent(jButtonExcluir))
                .addGap(0, 27, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jTextFieldNomeGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeGrupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeGrupoActionPerformed

    private void jButtonGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGravarActionPerformed
     
        idexistente = jTextField1.getText();
        mogrupo.setDESCONTO(jTextFieldDesconto.getText());
        mogrupo.setDESCRICAO(jTextFieldNomeGrupo.getText());

        GrupoControle grupocontrole = new GrupoControle();
        
        if (!idexistente.isEmpty()) {
            mogrupo.setId(Integer.parseInt(jTextField1.getText()));

        }
        try {
            grupocontrole.salvar(mogrupo);
            carregarDados();
        } catch (Exception ex) {
            Logger.getLogger(viewGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTextFieldDesconto.setText("");
        jTextFieldNomeGrupo.setText("");

    }//GEN-LAST:event_jButtonGravarActionPerformed

    private void jTableViewGrupoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableViewGrupoMouseClicked

        int linha = jTableViewGrupo.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um produto");
        } else {
            jTextField1.setText(jTableViewGrupo.getValueAt(linha, 0).toString());
            recebeId = (Integer) jTableViewGrupo.getValueAt(linha, 0);

            MoGrupo a = controle.consultaPorId(MoGrupo.class, recebeId);

            if (a == null) {
                System.out.println("a e´vazio)");
            } else {
                
                jTextFieldDesconto.setText(a.getDESCONTO());
                jTextFieldNomeGrupo.setText(a.getDESCRICAO());

            }

        }
    }//GEN-LAST:event_jTableViewGrupoMouseClicked

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        idexistente = jTextField1.getText();
        controle.remove(MoGrupo.class, Integer.parseInt(idexistente));
        carregarDados();
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewGrupo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonGravar;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableViewGrupo;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldDesconto;
    private javax.swing.JTextField jTextFieldNomeGrupo;
    // End of variables declaration//GEN-END:variables
}
