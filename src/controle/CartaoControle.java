/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import dao.DaoGenerico;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.MoCartao;
import model.MoClientes;
import model.MoGrupo;

/**
 *
 * @author suporte11-pc
 */
public class CartaoControle extends DaoGenerico<MoCartao> {

    public CartaoControle() {
        
    }
    
        public java.util.List<MoCartao> carregaCartao() {

        EntityManager em = getEM();

        TypedQuery<MoCartao> consulta = (TypedQuery<MoCartao>) em.createNamedQuery("MoCartao.todos", MoCartao.class);

        return consulta.getResultList();

    } 
    
    
    
}
