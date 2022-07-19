/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import controle.GrupoControle;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MoGrupo;

public class BuscaGrupo extends javax.swing.JDialog {

    GrupoControle controle = new GrupoControle();
    MoGrupo mogrupo = new MoGrupo();
    private Integer idSelecionado;
    private String descontoSelecionado;
    private String descricaoSelecionado;
            
    public BuscaGrupo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        carregarDados();
    }
         public void carregarDados(){
         DefaultTableModel modelo = (DefaultTableModel) jTableGrupo.getModel();
         modelo.setRowCount(0);
            for (MoGrupo grupo : controle.carregaGrupo()) {
            modelo.addRow(new Object[]{grupo.getId(),grupo.getDESCRICAO(),grupo.getDESCONTO()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonSair = new javax.swing.JButton();
        jButtonSelecionar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableGrupo = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Grupo");

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jButtonSelecionar.setText("Selecionar");
        jButtonSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarActionPerformed(evt);
            }
        });

        jTableGrupo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descricao", "Desconto"
            }
        ));
        jScrollPane2.setViewportView(jTableGrupo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonSair))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSelecionar))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButtonSair)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jButtonSelecionar)
                .addGap(27, 27, 27))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarActionPerformed
         int linha = jTableGrupo.getSelectedRow();
         if (linha == -1){
              JOptionPane.showMessageDialog(null, "Selecione um produto");
         }else{
              setIdSelecionado((Integer.parseInt(jTableGrupo.getValueAt(linha, 0).toString())));
              setDescricaoSelecionado(jTableGrupo.getValueAt(linha, 1).toString());;
              setDescontoSelecionado(jTableGrupo.getValueAt(linha, 2).toString());;
              this.dispose();;
         }
    }//GEN-LAST:event_jButtonSelecionarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BuscaGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscaGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscaGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscaGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BuscaGrupo dialog = new BuscaGrupo(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSair;
    private javax.swing.JButton jButtonSelecionar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableGrupo;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the idSelecionado
     */
    public Integer getIdSelecionado() {
        return idSelecionado;
    }

    /**
     * @param idSelecionado the idSelecionado to set
     */
    public void setIdSelecionado(Integer idSelecionado) {
        this.idSelecionado = idSelecionado;
    }

    /**
     * @return the descontoSelecionado
     */
    public String getDescontoSelecionado() {
        return descontoSelecionado;
    }

    /**
     * @param descontoSelecionado the descontoSelecionado to set
     */
    public void setDescontoSelecionado(String descontoSelecionado) {
        this.descontoSelecionado = descontoSelecionado;
    }

    /**
     * @return the descricaoSelecionado
     */
    public String getDescricaoSelecionado() {
        return descricaoSelecionado;
    }

    /**
     * @param descricaoSelecionado the descricaoSelecionado to set
     */
    public void setDescricaoSelecionado(String descricaoSelecionado) {
        this.descricaoSelecionado = descricaoSelecionado;
    }
}
