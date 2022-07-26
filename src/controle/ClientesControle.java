package controle;

import dao.DaoGenerico;
import java.util.ArrayList;
import java.awt.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.MoClientes;

public class ClientesControle extends DaoGenerico<MoClientes> {

    public ClientesControle() {
    }

    public java.util.List<MoClientes> carregaCli() {

        EntityManager em = getEM();

        TypedQuery<MoClientes> consulta = (TypedQuery<MoClientes>) em.createNamedQuery("MoClientes.todos", MoClientes.class);

        return consulta.getResultList();

    }

    public java.util.List<MoClientes> getListaCli() {

        // EntityManager gerente = FabricaGerenciadorEntidades.getGerente();
        EntityManager em = getEM();

        TypedQuery<MoClientes> consulta = (TypedQuery<MoClientes>) em.createNamedQuery("MoClientes.todos", MoClientes.class);

        return consulta.getResultList();
    }
}
