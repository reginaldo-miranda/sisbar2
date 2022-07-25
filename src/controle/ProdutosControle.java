
package controle;

import dao.DaoGenerico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.TypedQuery;
import model.MoClientes;
import model.MoProdutos;

public class ProdutosControle extends DaoGenerico<MoProdutos>{

    public ProdutosControle() {
    }
  
    public java.util.List<MoProdutos> carregaProd() {

        EntityManager em = getEM();

        TypedQuery<MoProdutos> consulta = (TypedQuery<MoProdutos>) em.createNamedQuery("MoProdutos.todos", MoProdutos.class);

        return consulta.getResultList();

    }  
    
     public java.util.List<MoProdutos> carregaProdPId(Integer idpr) {

        EntityManager em = getEM();

        TypedQuery<MoProdutos> consulta = (TypedQuery<MoProdutos>) em.createNamedQuery("Moprodutos.id", MoProdutos.class);
        consulta.setParameter("idprod", idpr);
        List<MoProdutos> prod = consulta.getResultList();
        return prod;

    }
   
   
}
