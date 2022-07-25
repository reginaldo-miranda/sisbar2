package model;

import dao.EntidadeBase;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
        
    @NamedQuery(name = "MoProdutos.todos", query = "SELECT prod FROM MoProdutos prod"),
            
    @NamedQuery(name = "Moprodutos.id", query = "SELECT pr FROM MoProdutos pr where pr.Id = :idprod")
})
@Table(name = "produtos")
public class MoProdutos implements EntidadeBase, Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    
    private String descricao;
    private String grupo;
    private Double preco_venda;
    private Double qde;
    private String unid_medida;

    public MoProdutos() {
    }

    /**
     * @return the Id
     */
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

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the grupo
     */
    public String getGrupo() {
        return grupo;
    }

    /**
     * @param grupo the grupo to set
     */
    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    /**
     * @return the preco_venda
     */
    public Double getPreco_venda() {
        return preco_venda;
    }

    /**
     * @param preco_venda the preco_venda to set
     */
    public void setPreco_venda(Double preco_venda) {
        this.preco_venda = preco_venda;
    }

    /**
     * @return the qde
     */
    public Double getQde() {
        return qde;
    }

    /**
     * @param qde the qde to set
     */
    public void setQde(Double qde) {
        this.qde = qde;
    }

    /**
     * @return the unid_medida
     */
    public String getUnid_medida() {
        return unid_medida;
    }

    /**
     * @param unid_medida the unid_medida to set
     */
    public void setUnid_medida(String unid_medida) {
        this.unid_medida = unid_medida;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.Id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MoProdutos other = (MoProdutos) obj;
        return this.Id == other.Id;
    }




}
