/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controle.ClientesControle;
import controle.Pdv2Controle;
import controle.PdvItensControle;
import dao.DaoGenerico;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import static java.time.Instant.now;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MoClientes;
import model.MoPdv;
import model.MoPdvItens;
import model.MoPdvItens_;
import static model.MoPdvItens_.produto;
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

    BuscaCliente buscacliente = new BuscaCliente();

    MoProdutos moproduto = new MoProdutos();

    private viewCaixa vcaixa;
    private viewPdv2 vpdv2;

    private String receber, receberNomeCli = null, receberNomeCliSelecionado;
    private Integer id_prod, idprod, receb_id_cliente, receberVenda;
    private Integer recebeVendaSelecionada, receberIdClienteSelecionado;

    Integer numVenda = 0, numProd = 0;
    private String receberDescProd, receberPreco, recebeIdProd, receberIdSelecionado;

    Double qde;

    private Double valortotalVenda = 0.0, total = 0.0, precoUnit;

    /**
     * Creates new form viewPdv2
     */
    public viewPdv2() {
        initComponents();
        desbilitarBtn();
        //   this.vcaixa = new viewCaixa(this, true);
    }

    public void desbilitarBtn() {

        jButtonBuscaCli.setEnabled(false);
        jButtonConcluir.setEnabled(false);
        jButtonBuscarProduto.setEnabled(false);
        jButtonGrade.setEnabled(false);
    }

    public void habilitarBtn() {

        jButtonBuscaCli.setEnabled(true);
        jButtonConcluir.setEnabled(true);
        jButtonBuscarProduto.setEnabled(true);
        //jButtonGrade.setEnabled(true);
    }

    public void carregaVendaItens() {

        // mopdv.adicionarItens(mopdvitens);
        DefaultTableModel modelo = (DefaultTableModel) jTableVendaPdv.getModel();
        modelo.setRowCount(0);

        //   for (MoPdvItens venditens : pdvitensctr.carregaVendaId(numVenda)) {
        for (MoPdvItens venditens : pdvitensctr.carregaVendaId(getNumVenda())) {
            modelo.addRow(new Object[]{venditens.getId(), venditens.getProduto(), venditens.getQuantidade(), venditens.getValorUnitario()});

        }
        List<MoPdv> vpdv = controle.ConsultarVendaPId(mopdv.getId());
        for (MoPdv p : vpdv) {
            setNumVenda(p.getId());

        }
        jTextFieldTotalVenda.setText(Double.toString(total));
    }

    public void carregarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) getjTableVendaPdv().getModel();
        // modelo.setRowCount(0);
        setValortotalVenda((Double) getValortotalVenda() + (Double.parseDouble(jTextFieldQde.getText()) * Double.parseDouble(jTextFieldprecoUnit.getText())));
        jTextFieldTotalVenda.setText(getValortotalVenda().toString());
        modelo.addRow(new Object[]{
            jTextFieldCodigoProd.getText(),
            jTextFieldDescricaoProd.getText(),
            jTextFieldQde.getText(),
            jTextFieldprecoUnit.getText()});

    }

    /*
    public void salvarItens() {

        mopdvitens.setProduto(Integer.parseInt(jTextFieldCodigoProd.getText()));
        mopdvitens.setQuantidade(Double.parseDouble(jTextFieldQde.getText()));
        mopdvitens.setValorUnitario(Double.parseDouble(jTextFieldQde.getText()));
        
        mopdvitens.setValorTotal(qde);
        
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
     */
    public void salvarVendaEItens() {
        try {
            mopdv = controle.salvar(mopdv);
            List<MoPdv> vpdv = controle.ConsultarVendaPId(mopdv.getId());
            for (MoPdv p : vpdv) {
                setNumVenda(p.getId());
            }
            jTextFieldNumVenda.setText(Integer.toString(getNumVenda()));

        } catch (Exception ex) {
            Logger.getLogger(viewPdv2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void pegarDadosTabela() throws Exception {
        int linha = getjTableVendaPdv().getSelectedRow();

        DefaultTableModel modelo = (DefaultTableModel) getjTableVendaPdv().getModel();
        if (modelo.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "tabela vazia");
        } else {
            for (int i = 0; i < modelo.getRowCount(); i++) {

                id_prod = Integer.parseInt(modelo.getValueAt(i, 0).toString());
                moproduto.setId(id_prod);

                qde = Double.parseDouble((String) modelo.getValueAt(i, 2));
                precoUnit = Double.parseDouble((String) modelo.getValueAt(i, 3));

                mopdvitens.setProduto(moproduto);
                mopdvitens.setQuantidade(qde);
                mopdvitens.setVenda(mopdv);
                mopdvitens.setId_venda(getNumVenda());

                mopdvitens.setValorUnitario((precoUnit));

                pdvitensctr.salvarItensVenda(mopdvitens);
                //  mopdv = controle.salvar(mopdv);
                mopdv.adicionarItens(mopdvitens);
            }
            mopdv.setValorTotal(valortotalVenda);
            mopdv.setId_clientes(receb_id_cliente);
            mopdv = controle.salvar(mopdv);
        }

        viewCaixa dialog = new viewCaixa(new javax.swing.JFrame(), true);
        receberVenda = Integer.parseInt(jTextFieldNumVenda.getText());
        dialog.passarIdVenda(receberVenda, valortotalVenda);

        dialog.setVisible(true);
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
        jLabel7 = new javax.swing.JLabel();
        jTextFieldQde = new javax.swing.JTextField();
        jButtonBuscarVenda = new javax.swing.JButton();
        jButtonGrade = new javax.swing.JButton();
        jButtonConcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("N: Vendas");

        jTextFieldNumVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNumVendaActionPerformed(evt);
            }
        });

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

        jTextFieldTotalVenda.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jTextFieldTotalVenda.setForeground(new java.awt.Color(0, 255, 0));

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

        jLabel7.setText("Qde");

        jButtonBuscarVenda.setText("Buscar Venda");
        jButtonBuscarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarVendaActionPerformed(evt);
            }
        });

        jButtonGrade.setText("Gravar");
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
                                        .addComponent(jButtonGrade)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonConcluir)))
                                .addGap(0, 31, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 280, Short.MAX_VALUE)
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
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
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
                    .addComponent(jTextFieldQde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonConcluir)
                    .addComponent(jButtonGrade))
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

        jTextFieldQde.setText(Double.toString(2));
        jTextFieldCodigoProd.setText(receberIdSelecionado);
        jTextFieldDescricaoProd.setText(receberDescProd);
        jTextFieldprecoUnit.setText(receberPreco);
        jButtonGrade.setEnabled(true);


    }//GEN-LAST:event_jButtonBuscarProdutoActionPerformed

    private void jButtonNovoCupomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoCupomActionPerformed
        // Calendar c = Calendar.getInstance();
        // SimpleDateFormat df = new SimpleDateFormat();
        habilitarBtn();
        mopdv.setData(Calendar.getInstance());

        // mopdv.setId_clientes(Integer.parseInt(jTextFieldIdClinete.getText().toString()));
        try {
            mopdv = controle.salvar(mopdv);
            List<MoPdv> vpdv = controle.ConsultarVendaPId(mopdv.getId());
            for (MoPdv p : vpdv) {
                setNumVenda(p.getId());
                setRecebeVendaSelecionada(getNumVenda());
            }
            jTextFieldNumVenda.setText(Integer.toString(getNumVenda()));
            setRecebeVendaSelecionada(getNumVenda());
        } catch (Exception ex) {
            Logger.getLogger(viewPdv2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonNovoCupomActionPerformed

    private void jButtonBuscarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarVendaActionPerformed

        BuscarVenda dialog = new BuscarVenda(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
     
        setRecebeVendaSelecionada(dialog.getCodigoSelecionado());
        setReceberIdClienteSelecionado(dialog.getClienteSelecionado());
        // setReceberNomeCliSelecionado(dialogcli.getNomeclieSelecionado());
        
        total = dialog.getValorSelecionado();
        setNumVenda(getRecebeVendaSelecionada());
        jTextFieldNumVenda.setText(Integer.toString(getRecebeVendaSelecionada()));
        jTextFieldIdClinete.setText(Integer.toString(getReceberIdClienteSelecionado()));
        jTextFieldTotalVenda.setText(Double.toString(total));
        
        jTextFieldNomeCliente.setText(receberNomeCli);
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

    private void jTextFieldNumVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNumVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNumVendaActionPerformed

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

    /**
     * @return the valortotalVenda
     */
    public Double getValortotalVenda() {
        return valortotalVenda;
    }

    /**
     * @param valortotalVenda the valortotalVenda to set
     */
    public void setValortotalVenda(Double valortotalVenda) {
        this.valortotalVenda = valortotalVenda;
    }

    /**
     * @return the total
     */
    public Double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * @return the numVenda
     */
    public Integer getNumVenda() {
        return numVenda;
    }

    /**
     * @param numVenda the numVenda to set
     */
    public void setNumVenda(Integer numVenda) {
        this.numVenda = numVenda;
    }

    /**
     * @return the vcaixa
     */
    public viewCaixa getVcaixa() {
        return vcaixa;
    }

    /**
     * @param vcaixa the vcaixa to set
     */
    public void setVcaixa(viewCaixa vcaixa) {
        this.vcaixa = vcaixa;
    }

    /**
     * @return the vpdv2
     */
    public viewPdv2 getVpdv2() {
        return vpdv2;
    }

    /**
     * @param vpdv2 the vpdv2 to set
     */
    public void setVpdv2(viewPdv2 vpdv2) {
        this.vpdv2 = vpdv2;
    }

    /**
     * @return the receberVenda
     */
    public Integer getReceberVenda() {
        return receberVenda;
    }

    /**
     * @param receberVenda the receberVenda to set
     */
    public void setReceberVenda(Integer receberVenda) {
        this.receberVenda = receberVenda;
    }

    /**
     * @return the recebeVendaSelecionada
     */
    public Integer getRecebeVendaSelecionada() {
        return recebeVendaSelecionada;
    }

    /**
     * @param recebeVendaSelecionada the recebeVendaSelecionada to set
     */
    public void setRecebeVendaSelecionada(Integer recebeVendaSelecionada) {
        this.recebeVendaSelecionada = recebeVendaSelecionada;
    }

    /**
     * @return the receberIdClienteSelecionado
     */
    public Integer getReceberIdClienteSelecionado() {
        return receberIdClienteSelecionado;
    }

    /**
     * @param receberIdClienteSelecionado the receberIdClienteSelecionado to set
     */
    public void setReceberIdClienteSelecionado(Integer receberIdClienteSelecionado) {
        this.receberIdClienteSelecionado = receberIdClienteSelecionado;
    }

    /**
     * @return the receberNomeCliSelecionado
     */
    public String getReceberNomeCliSelecionado() {
        return receberNomeCliSelecionado;
    }

    /**
     * @param receberNomeCliSelecionado the receberNomeCliSelecionado to set
     */
    public void setReceberNomeCliSelecionado(String receberNomeCliSelecionado) {
        this.receberNomeCliSelecionado = receberNomeCliSelecionado;
    }

}
