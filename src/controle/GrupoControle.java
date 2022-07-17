
package controle;

import dao.DaoGenerico;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.MoGrupo;
import model.MoProdutos;


public class GrupoControle extends DaoGenerico<MoGrupo> {

    public GrupoControle() {
    }
    
      
    public java.util.List<MoGrupo> carregaGrupo() {

        EntityManager em = getEM();

        TypedQuery<MoGrupo> consulta = (TypedQuery<MoGrupo>) em.createNamedQuery("Mogrupo.todos", MoGrupo.class);

        return consulta.getResultList();

    } 
}
