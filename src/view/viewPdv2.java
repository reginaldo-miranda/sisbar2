/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controle.ClientesControle;
import controle.Pdv2Controle;
import controle.PdvItensControle;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import static java.time.Instant.now;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MoPdv;
import model.MoPdvItens;
//import static model.MoPdv_.id;
import model.MoProdutos;

/**
 *
 * @author suporte11-pc
 */
public class viewPdv2 extends javax.swing.JFrame {

    Pdv2Controle controle = new Pdv2Controle();
    MoPdv mopdv = new MoPdv();

    PdvItensControle pdvitensctr = new PdvItensControle();
    MoPdvItens mopdvitens = new MoPdvItens();

    ClientesControle clicontrole = new ClientesControle();

    private String receber, receberNomeCli = null;
    private Integer id_prod, receb_id_cliente, receberVenda;

    Integer recebeVendaSelecionada, numVenda = 0;
    private String receberDescProd, receberPreco, recebeIdProd, receberIdSelecionado;

    Double qde;

    /**
     * Creates new form viewPdv2
     */
    public viewPdv2() {
        initComponents();
        jButtonGravarItens.setEnabled(false);
    }

    public void carregaVendaItens() {

        DefaultTableModel modelo = (DefaultTableModel) getjTableVendaPdv().getModel();
        modelo.setRowCount(0);
        for (MoPdvItens venditens : pdvitensctr.carregaVendaId(numVenda)) {
            modelo.addRow(new Object[]{venditens.getId(), venditens.getProdutos(), venditens.getQuantidade(), venditens.getValorUnitario()});
        }
    }

    public void carregarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) getjTableVendaPdv().getModel();
        // modelo.setRowCount(0);
        modelo.addRow(new Object[]{
            jTextFieldCodigoProd.getText(), jTextFieldDescricaoProd.getText(),
            jTextFieldQde.getText(), jTextFieldprecoUnit.getText()});

    }

    public void salvarItens() {

        mopdvitens.setProdutos(Integer.parseInt(jTextFieldCodigoProd.getText()));
        mopdvitens.setQuantidade(Double.parseDouble(jTextFieldQde.getText()));
        mopdvitens.setValorUnitario(Double.parseDouble(jTextFieldQde.getText()));
        //   mopdvitens.setVenda(Integer.parseInt(jTextFieldNumVenda.getText()));

        try {
            pdvitensctr.salvarItensVenda(mopdvitens);

            jTextFieldCodigoProd.setText("");
            jTextFieldQde.setText("");
            jTextFieldDescricaoProd.setText("");
            jTextFieldprecoUnit.setText("");

            jButtonBuscarProduto.setFocusPainted(true);
        } catch (Exception ex) {
            Logger.getLogger(viewPdv2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void salvarVendaEItens() {
        try {
            mopdv = controle.salvar(mopdv);
            List<MoPdv> vpdv = controle.ConsultarVendaPId(mopdv.getId());
            for (MoPdv p : vpdv) {
                numVenda = p.getId();
            }
            jTextFieldNumVenda.setText(Integer.toString(numVenda));

        } catch (Exception ex) {
            Logger.getLogger(viewPdv2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void pegarDadosTabela() throws Exception {
        DefaultTableModel modelo = (DefaultTableModel) getjTableVendaPdv().getModel();
        if (modelo.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "tabela vazia");
        } else {
            for (int i = 0; i < modelo.getRowCount(); i++) {
                //   mopdvitens.setProduto((MoProdutos) modelo.getValueAt(i, 0));
                qde = Double.parseDouble((String) modelo.getValueAt(i, 0));
                mopdvitens.setQuantidade(qde);
                mopdvitens.setVenda(mopdv);
                pdvitensctr.salvarItensVenda(mopdvitens);
                //     mopdvitens.setValorUnitario((Double) modelo.getValueAt(i, 3));
               // mopdv = controle.salvar(mopdv);
            }

        }

        /*  List<MoPdvItens> mod = (List<MoPdvItens>) modelo;
        for (MoPdvItens mo : mod) {
            System.out.println("view.viewPdv2.pegarDadosTabela()" + mo.getProduto());
        } */
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldNumVenda = new javax.swing.JTextField();
        jButtonSair = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldIdClinete = new javax.swing.JTextField();
        jTextFieldNomeCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButtonBuscaCli = new javax.swing.JButton();
        jTextFieldTotalVenda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVendaPdv = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldCodigoProd = new javax.swing.JTextField();
        jTextFieldDescricaoProd = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldprecoUnit = new javax.swing.JTextField();
        jButtonBuscarProduto = new javax.swing.JButton();
        jButtonNovoCupom = new javax.swing.JButton();
        jButtonGravarItens = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldQde = new javax.swing.JTextField();
        jButtonBuscarVenda = new javax.swing.JButton();
        jButtonGrade = new javax.swing.JButton();
        jButtonConcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("N: Vendas");

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jLabel2.setText("Codigo");

        jLabel3.setText("Clientes");

        jButtonBuscaCli.setText("Cliente");
        jButtonBuscaCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscaCliActionPerformed(evt);
            }
        });

        jTableVendaPdv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descricao", "Qde", "Preco"
            }
        ));
        jScrollPane1.setViewportView(jTableVendaPdv);

        jLabel4.setText("Codigo");

        jLabel5.setText("Descricao");

        jLabel6.setText("P Unit");

        jButtonBuscarProduto.setText("Produto");
        jButtonBuscarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarProdutoActionPerformed(evt);
            }
        });

        jButtonNovoCupom.setText("Novo");
        jButtonNovoCupom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoCupomActionPerformed(evt);
            }
        });

        jButtonGravarItens.setText("Gravar");
        jButtonGravarItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGravarItensActionPerformed(evt);
            }
        });

        jLabel7.setText("Qde");

        jButtonBuscarVenda.setText("Buscar Venda");
        jButtonBuscarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarVendaActionPerformed(evt);
            }
        });

        jButtonGrade.setText("Gr Grade");
        jButtonGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGradeActionPerformed(evt);
            }
        });

        jButtonConcluir.setText("Concluir");
        jButtonConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonBuscarVenda)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonSair))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTextFieldIdClinete))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTextFieldNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButtonBuscaCli))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldNumVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonNovoCupom)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldCodigoProd, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(58, 58, 58)
                                        .addComponent(jLabel5)
                                        .addGap(185, 185, 185)
                                        .addComponent(jLabel6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldQde, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldDescricaoProd, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldprecoUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonBuscarProduto)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonGravarItens)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonConcluir)))
                                .addGap(0, 31, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButtonGrade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButtonSair)
                    .addComponent(jButtonBuscarVenda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNumVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonNovoCupom))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldIdClinete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonBuscaCli)))
                    .addComponent(jTextFieldTotalVenda))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonGrade)
                        .addGap(51, 51, 51)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCodigoProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDescricaoProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldprecoUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscarProduto)
                    .addComponent(jButtonGravarItens)
                    .addComponent(jTextFieldQde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonConcluir))
                .addGap(83, 83, 83))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonBuscaCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscaCliActionPerformed
        BuscaCliente dialog = new BuscaCliente(new javax.swing.JFrame(), true);
        dialog.setVisible(true);

        receb_id_cliente = dialog.getId_cli_selecionado();
        jTextFieldIdClinete.setText(Integer.toString(receb_id_cliente));

        receberNomeCli = dialog.getNomeclieSelecionado();
        jTextFieldNomeCliente.setText(receberNomeCli);

    }//GEN-LAST:event_jButtonBuscaCliActionPerformed

    private void jButtonBuscarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarProdutoActionPerformed
        BuscaProduto dialog = new BuscaProduto(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
        receberIdSelecionado = dialog.getProdIdSelecionado();
        receberDescProd = dialog.getDescSelecionado();
        receberPreco = dialog.getPrecoSelecionado();

        jTextFieldCodigoProd.setText(receberIdSelecionado);
        jTextFieldDescricaoProd.setText(receberDescProd);
        jTextFieldprecoUnit.setText(receberPreco);


    }//GEN-LAST:event_jButtonBuscarProdutoActionPerformed

    private void jButtonNovoCupomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoCupomActionPerformed
        // Calendar c = Calendar.getInstance();
        // SimpleDateFormat df = new SimpleDateFormat();
        mopdv.setData(Calendar.getInstance());
        // mopdv.setId_clientes(Integer.parseInt(jTextFieldIdClinete.getText().toString()));

        try {
            mopdv = controle.salvar(mopdv);
            List<MoPdv> vpdv = controle.ConsultarVendaPId(mopdv.getId());
            for (MoPdv p : vpdv) {
                numVenda = p.getId();
            }
            jTextFieldNumVenda.setText(Integer.toString(numVenda));

        } catch (Exception ex) {
            Logger.getLogger(viewPdv2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonNovoCupomActionPerformed

    private void jButtonGravarItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGravarItensActionPerformed

        salvarItens();

    }//GEN-LAST:event_jButtonGravarItensActionPerformed

    private void jButtonBuscarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarVendaActionPerformed

        BuscarVenda dialog = new BuscarVenda(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
        recebeVendaSelecionada = dialog.getCodigoSelecionado();
        numVenda = recebeVendaSelecionada;
        jTextFieldNumVenda.setText(Integer.toString(recebeVendaSelecionada));
        carregaVendaItens();


    }//GEN-LAST:event_jButtonBuscarVendaActionPerformed

    private void jButtonGradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGradeActionPerformed
        if (jTextFieldQde.getText().equals("") || jTextFieldIdClinete.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo Cliente e qde obrigatorio");
            jTextFieldQde.requestFocus();
        } else {
            carregarTabela();
            jTextFieldCodigoProd.setText("");
            jTextFieldQde.setText(" ");
            jTextFieldDescricaoProd.setText("");
            jTextFieldprecoUnit.setText("");
        }

    }//GEN-LAST:event_jButtonGradeActionPerformed

    private void jButtonConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConcluirActionPerformed
        JOptionPane.showMessageDialog(null, "aqui");
        try {
            pegarDadosTabela();
            //  salvarVendaEItens();
        } catch (Exception ex) {
            Logger.getLogger(viewPdv2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonConcluirActionPerformed

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
            java.util.logging.Logger.getLogger(viewPdv2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewPdv2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewPdv2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewPdv2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewPdv2().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscaCli;
    private javax.swing.JButton jButtonBuscarProduto;
    private javax.swing.JButton jButtonBuscarVenda;
    private javax.swing.JButton jButtonConcluir;
    private javax.swing.JButton jButtonGrade;
    private javax.swing.JButton jButtonGravarItens;
    private javax.swing.JButton jButtonNovoCupom;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableVendaPdv;
    private javax.swing.JTextField jTextFieldCodigoProd;
    private javax.swing.JTextField jTextFieldDescricaoProd;
    private javax.swing.JTextField jTextFieldIdClinete;
    private javax.swing.JTextField jTextFieldNomeCliente;
    private javax.swing.JTextField jTextFieldNumVenda;
    private javax.swing.JTextField jTextFieldQde;
    private javax.swing.JTextField jTextFieldTotalVenda;
    private javax.swing.JTextField jTextFieldprecoUnit;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the jTableVendaPdv
     */
    public javax.swing.JTable getjTableVendaPdv() {
        return jTableVendaPdv;
    }

    /**
     * @param jTableVendaPdv the jTableVendaPdv to set
     */
    public void setjTableVendaPdv(javax.swing.JTable jTableVendaPdv) {
        this.jTableVendaPdv = jTableVendaPdv;
    }
}
