/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import dao.DaoGenerico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.table.DefaultTableModel;
import model.MoPdvItens;
import model.MoProdutos;

/**
 *
 * @author suporte11-pc
 */
public class PdvItensControle extends DaoGenerico<MoPdvItens> {
    
        public List<MoPdvItens> carregaVendaId(Integer idpr) {

        EntityManager em = getEM();

        TypedQuery<MoPdvItens> consulta = (TypedQuery<MoPdvItens>) em.createNamedQuery("MoVendaItens.id", MoPdvItens.class);
        consulta.setParameter("idvi", idpr);
        List<MoPdvItens> viid = consulta.getResultList();
        return viid;

    }
     
    public List<MoPdvItens> carregaVendaItenTd() {

        EntityManager em = getEM();

        TypedQuery<MoPdvItens> consulta = (TypedQuery<MoPdvItens>) em.createNamedQuery("MoVendaItens.todos", MoPdvItens.class);
        List<MoPdvItens> viid = consulta.getResultList();
        return viid;

    }
    
}
