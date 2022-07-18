
package controle;

import dao.DaoGenerico;
import javax.persistence.EntityManager;
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
}
