/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import dao.DaoGenerico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.MoPdv;
import model.MoProdutos;

/**
 *
 * @author suporte11-pc
 */
public class Pdv2Controle extends DaoGenerico<MoPdv> {



    public Pdv2Controle() {
    }
    
       
     public java.util.List<MoPdv> ConsultarVendaPId(Integer idpr) {

        EntityManager em = getEM();

        TypedQuery<MoPdv> consulta = (TypedQuery<MoPdv>) em.createNamedQuery("MoPdv.id", MoPdv.class);
        consulta.setParameter("idpd", idpr);
        List<MoPdv> vpdv = consulta.getResultList();
        return vpdv;

    }
    
}
