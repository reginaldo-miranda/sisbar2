/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import controle.Pdv2Controle;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MoPdv;
import model.MoProdutos;

/**
 *
 * @author suporte11-pc
 */
public class BuscarVenda extends javax.swing.JDialog {

    Pdv2Controle controle = new Pdv2Controle();

    private String dataselecionada;
    private Integer codigoSelecionado;
    private Integer clienteSelecionado;
    private Double valorSelecionado;

    /**
     *
     * @param parent
     * @param modal
     */
    /**
     * Creates new form BuscarVenda
     */
    public BuscarVenda(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        carregaVenda();
    }
    
      public void carregaVenda() {

        DefaultTableModel modelo = (DefaultTableModel) getjTableBuscarVenda().getModel();
        for (MoPdv mopdv : controle.ConsultarVendaTodas()) {

            modelo.addRow(new Object[]{mopdv.getId(), mopdv.getData(), mopdv.getClientes() ,mopdv.getValorTotal()});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonSair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBuscarVenda = new javax.swing.JTable();
        jButtonSelecionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Venda");

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jTableBuscarVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Data", "Cliente", "Valor"
            }
        ));
        jScrollPane1.setViewportView(jTableBuscarVenda);

        jButtonSelecionar.setText("Selecionar");
        jButtonSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSair)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSelecionar)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonSair)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButtonSelecionar)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarActionPerformed
        int linha = getjTableBuscarVenda().getSelectedRow();

        if (linha == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um Cliente");
        } else {

            setCodigoSelecionado(Integer.parseInt(getjTableBuscarVenda().getValueAt(linha, 0).toString()));
           // setDataselecionada(getjTableBuscarVenda().getValueAt(linha, 1).toString());
           // setClienteSelecionado(Integer.parseInt(getjTableBuscarVenda().getValueAt(linha, 2).toString()));
           // setClienteSelecionado(Integer.parseInt(getjTableBuscarVenda().getValueAt(linha, 3).toString()));

            this.dispose();

        }
    }//GEN-LAST:event_jButtonSelecionarActionPerformed

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
            java.util.logging.Logger.getLogger(BuscarVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BuscarVenda dialog = new BuscarVenda(new javax.swing.JFrame(), true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableBuscarVenda;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the dataselecionada
     */
    public String getDataselecionada() {
        return dataselecionada;
    }

    /**
     * @param dataselecionada the dataselecionada to set
     */
    public void setDataselecionada(String dataselecionada) {
        this.dataselecionada = dataselecionada;
    }

    /**
     * @return the codigoSelecionado
     */
    public Integer getCodigoSelecionado() {
        return codigoSelecionado;
    }

    /**
     * @param codigoSelecionado the codigoSelecionado to set
     */
    public void setCodigoSelecionado(Integer codigoSelecionado) {
        this.codigoSelecionado = codigoSelecionado;
    }

    /**
     * @return the clienteSelecionado
     */
    public Integer getClienteSelecionado() {
        return clienteSelecionado;
    }

    /**
     * @param clienteSelecionado the clienteSelecionado to set
     */
    public void setClienteSelecionado(Integer clienteSelecionado) {
        this.clienteSelecionado = clienteSelecionado;
    }

    /**
     * @return the valorSelecionado
     */
    public Double getValorSelecionado() {
        return valorSelecionado;
    }

    /**
     * @param valorSelecionado the valorSelecionado to set
     */
    public void setValorSelecionado(Double valorSelecionado) {
        this.valorSelecionado = valorSelecionado;
    }

    /**
     * @return the jTableBuscarVenda
     */
    public javax.swing.JTable getjTableBuscarVenda() {
        return jTableBuscarVenda;
    }

    /**
     * @param jTableBuscarVenda the jTableBuscarVenda to set
     */
    public void setjTableBuscarVenda(javax.swing.JTable jTableBuscarVenda) {
        this.jTableBuscarVenda = jTableBuscarVenda;
    }
}
