package model;

import dao.EntidadeBase;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "Mogrupo.todos", query = "SELECT gru FROM MoGrupo gru")

@Table(name = "grupo")
public class MoGrupo implements EntidadeBase, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String DESCONTO;
    private String DESCRICAO;

    public String getDESCONTO() {
        return DESCONTO;
    }

  
    public void setDESCONTO(String DESCONTO) {
        this.DESCONTO = DESCONTO;
    }

    /**
     * @return the DESCRICAO
     */
    public String getDESCRICAO() {
        return DESCRICAO;
    }

    /**
     * @param DESCRICAO the DESCRICAO to set
     */
    public void setDESCRICAO(String DESCRICAO) {
        this.DESCRICAO = DESCRICAO;
    }

    @Override
    public Integer getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }

 

}
