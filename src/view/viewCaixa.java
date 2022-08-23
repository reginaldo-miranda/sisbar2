/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import model.MoPdv;
import model.MoPdvItens;
import controle.caixaControle;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import static java.lang.Double.isNaN;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author suporte11-pc
 */
public class viewCaixa extends javax.swing.JDialog {

    /**
     * Creates new form viewCaixa
     */
    MoPdv mopdv = new MoPdv();
    MoPdvItens mopdvitens = new MoPdvItens();
    caixaControle cxcontrole = new caixaControle();

    private Integer receberNumVenda = 0;
    private Double total = 0.0, falta = 0.0, troco = 0.0, novototal = 0.0;
    private Double dinheiro = 0.0, cartao = 0.0, pix = 0.0, cheque = 0.0, totalRecebido = 0.0;

    public viewCaixa(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        passarIdVenda(receberNumVenda, total);
        jTextFieldDinheiro.requestFocus();

    }

    viewCaixa() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void passarIdVenda(Integer receberNumVenda, Double total) {

        jTextFieldNumVenda.setText(Integer.toString(receberNumVenda));
        novototal = total;
        jTextFieldTotal.setText(Double.toString(total));
    }

    public void somaRecebido() {

        totalRecebido = (dinheiro + cartao + pix + cheque);
        jTextFieldTotalRecebido.setText(Double.toString(totalRecebido));
        falta = novototal - totalRecebido;

        if (totalRecebido > novototal) {
            troco = totalRecebido - novototal;
            jTextFieldTroco.setText(Double.toString(troco));
            jTextFieldFalta.setText("");
        } else {
            jTextFieldFalta.setText(Double.toString(falta));
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
        jTextFieldTotal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldDinheiro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldCartao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldPix = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldCheque = new javax.swing.JTextField();
        jButtonFecharVenda = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldFalta = new javax.swing.JTextField();
        jTextFieldTroco = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldNumVenda = new javax.swing.JTextField();
        jTextFieldTotalRecebido = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButtonGerarCodigoPix = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Caixa");

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jTextFieldTotal.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jTextFieldTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setText("Total ");

        jLabel2.setText("Dinheiro");

        jTextFieldDinheiro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldDinheiroFocusLost(evt);
            }
        });

        jLabel3.setText("Cartao");

        jTextFieldCartao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldCartaoFocusLost(evt);
            }
        });
        jTextFieldCartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCartaoActionPerformed(evt);
            }
        });

        jLabel4.setText("Pix");

        jTextFieldPix.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldPixFocusLost(evt);
            }
        });
        jTextFieldPix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPixActionPerformed(evt);
            }
        });

        jLabel5.setText("Cheque");

        jTextFieldCheque.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldChequeFocusLost(evt);
            }
        });

        jButtonFecharVenda.setText("Fechar a Venda");
        jButtonFecharVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharVendaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel6.setText("Falta");

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel7.setText("Troco");

        jTextFieldFalta.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jTextFieldFalta.setForeground(new java.awt.Color(204, 51, 0));
        jTextFieldFalta.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTextFieldTroco.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jTextFieldTroco.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel8.setText("N: Venda");

        jTextFieldTotalRecebido.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel9.setText("Total Recebido");

        jButtonGerarCodigoPix.setText("gerar codigo");
        jButtonGerarCodigoPix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerarCodigoPixActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextFieldNumVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(114, 114, 114)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldFalta, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonSair))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldTotalRecebido)
                            .addComponent(jButtonFecharVenda, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(jTextFieldTotal, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldDinheiro, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldCartao, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldPix, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldCheque, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonGerarCodigoPix)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSair)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldTotal)
                                    .addComponent(jTextFieldFalta)
                                    .addComponent(jTextFieldTroco)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNumVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldCartao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jButtonGerarCodigoPix))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldCheque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTotalRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jButtonFecharVenda)
                .addGap(32, 32, 32))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jTextFieldCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCartaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCartaoActionPerformed

    private void jTextFieldPixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPixActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPixActionPerformed

    private void jButtonFecharVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharVendaActionPerformed
        JOptionPane.showMessageDialog(null, "estou no concluir bl ? petista");
        //   cxcontrole.calculosCaixa(total, dinheiro, cartao, pix, cheque);
        //  jTextFieldFalta.setText(cxcontrole.getFalta().toString());
    }//GEN-LAST:event_jButtonFecharVendaActionPerformed

    private void jTextFieldDinheiroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDinheiroFocusLost
        //  pegarDadosJtextfild();
        if (jTextFieldDinheiro.getText().isEmpty()) {
            jTextFieldDinheiro.setText(Double.toString(0));
            dinheiro = 0.0;
            jTextFieldTotalRecebido.setText("");
            jTextFieldTroco.setText("");
        } else {
            dinheiro = Double.parseDouble(jTextFieldDinheiro.getText());
        }
        somaRecebido();
    }//GEN-LAST:event_jTextFieldDinheiroFocusLost

    private void jTextFieldCartaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCartaoFocusLost
        //  pegarDadosJtextfild();
        if (jTextFieldCartao.getText().isEmpty()) {
            jTextFieldCartao.setText("");
            cartao = 0.0;
        } else {
            cartao = Double.parseDouble(jTextFieldCartao.getText());
        }
        somaRecebido();
        jTextFieldCartao.setText("");
    }//GEN-LAST:event_jTextFieldCartaoFocusLost

    public void abrirJanela() {
        viewQrCode qrcode = new viewQrCode();
        qrcode.setVisible(true);
        qrcode.setAlwaysOnTop(true);
    }
    private void jTextFieldPixFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPixFocusLost
    
        if (jTextFieldPix.getText().isEmpty()) {
            jTextFieldPix.setText("");
            pix = 0.0;
        } else {
            pix = Double.parseDouble(jTextFieldPix.getText());
        }
        somaRecebido();
        JOptionPane.showMessageDialog(null, "pagar c pix", "", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("qrcode-pix.png")));
     

    }//GEN-LAST:event_jTextFieldPixFocusLost

    private void jTextFieldChequeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldChequeFocusLost
        //  pegarDadosJtextfild();
        if (jTextFieldCheque.getText().isEmpty()) {
            jTextFieldCheque.setText("");
            cheque = 0.0;
        } else {
            cheque = Double.parseDouble(jTextFieldCheque.getText());
        }
        somaRecebido();
    }//GEN-LAST:event_jTextFieldChequeFocusLost

    private void jButtonGerarCodigoPixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerarCodigoPixActionPerformed
        //  abrirJanela();
        JOptionPane.showMessageDialog(null, "Mensagem Aleatória", "Título da Mensagem", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("qrcode-pix.png")));
    }//GEN-LAST:event_jButtonGerarCodigoPixActionPerformed

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
            java.util.logging.Logger.getLogger(viewCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                viewCaixa dialog = new viewCaixa(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonFecharVenda;
    private javax.swing.JButton jButtonGerarCodigoPix;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextFieldCartao;
    private javax.swing.JTextField jTextFieldCheque;
    private javax.swing.JTextField jTextFieldDinheiro;
    private javax.swing.JTextField jTextFieldFalta;
    private javax.swing.JTextField jTextFieldNumVenda;
    private javax.swing.JTextField jTextFieldPix;
    private javax.swing.JTextField jTextFieldTotal;
    private javax.swing.JTextField jTextFieldTotalRecebido;
    private javax.swing.JTextField jTextFieldTroco;
    // End of variables declaration//GEN-END:variables

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
}
