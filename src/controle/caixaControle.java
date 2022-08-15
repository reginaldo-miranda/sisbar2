/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import dao.DaoGenerico;
import model.MoCaixa;

/**
 *
 * @author suporte11-pc
 */
public class caixaControle extends DaoGenerico<MoCaixa> {

    public caixaControle() {

    }

    public void calculosCaixa() {
        falta =  total da venda > total da opcoes
        if (falta  < total da venda){
            preencher campo falta
            nao encerrar a venda                    
        }else{
            troco = total das vendas - total das opcoes
             preencher campo troco    
             encerrar a venda        
      }
    }

}
