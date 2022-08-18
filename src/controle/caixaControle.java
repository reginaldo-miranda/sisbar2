/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import dao.DaoGenerico;
import javax.swing.JOptionPane;
import model.MoCaixa;

/**
 *
 * @author suporte11-pc
 */
public class caixaControle extends DaoGenerico<MoCaixa> {

    private Double totalVendaRecebido = 0.0, dinhRecebido = 0.0, cartaoRecebido = 0.0, pixRecebeido = 0.0, chequeRecebido = 0.0;
    private Double totalOpcoes = 0.0, falta = 0.0;

    public caixaControle() {

    }
    public void teste(Double total){
        JOptionPane.showMessageDialog(null, "aqui na teste" + total);
    }

    public void calculosCaixa(Double total, Double dinheiro, Double cartao, Double pix, Double cheque) {

        totalVendaRecebido = total;
        JOptionPane.showMessageDialog(null, "aqui na teste" + total);
        dinhRecebido = dinheiro;
        cartaoRecebido = cartao;
        pixRecebeido = pix;
        chequeRecebido = cheque; 
        
        totalOpcoes = (dinhRecebido + cartaoRecebido + pixRecebeido + chequeRecebido);

        if (totalVendaRecebido < totalOpcoes) {
            
            falta =  (totalVendaRecebido - totalOpcoes);
            //      setFalta(falta);
            
            //    nao encerrar a venda    
            JOptionPane.showMessageDialog(null, "total venda menor q opções falta " + falta);
        }
        if (totalVendaRecebido > totalOpcoes) {
           JOptionPane.showMessageDialog(null, "total venda maior q opções");
            // preencher campo troco    
            //encerrar a venda      */  
        }
        if (totalVendaRecebido.equals(totalOpcoes)) {
            //    JOptionPane.showMessageDialog(null, "total venda igual as opções");
            // encerrar a venda
        }
       
    }

    /**
     * @return the falta
     */
    public Double getFalta() {
        return falta;
    }

    /**
     * @param falta the falta to set
     */
    public void setFalta(Double falta) {
        this.falta = falta;
    }
     
}
