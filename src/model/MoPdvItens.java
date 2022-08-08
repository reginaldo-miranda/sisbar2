/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dao.EntidadeBase;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author suporte11-pc
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "MoVendaItens.todos", query = "SELECT vit FROM MoPdvItens vit"),

    @NamedQuery(name = "MoVendaItens.id", query = "SELECT vi FROM MoPdvItens vi where vi.id = :idvi"),

    @NamedQuery(name = "MoVendaItens.ve", query = "SELECT vi FROM MoPdvItens vi where vi.id_venda = :idvi")

//  @NamedQuery(name = "MoVendaItens.ve", query = "SELECT d FROM MoPdvItens e join e.MoPdv e where d.venda = :idvi")    
})
// link de site exemplo join   https://www.baeldung.com/jpa-join-types

@Table(name = "vendaitens")
public class MoPdvItens implements EntidadeBase, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double quantidade;
    private Double valorUnitario;
    private Double valorTotal;
    private int id_venda;
     
    @ManyToOne
    @JoinColumn(name = "venda", referencedColumnName = "id")
    private MoPdv venda;

    @ManyToOne
    @JoinColumn(name = "produto", referencedColumnName = "id")
    private MoProdutos produto;

    // private int produtos;
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the quantidade
     */
    public Double getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the valorUnitario
     */
    public Double getValorUnitario() {
        return valorUnitario;
    }

    /**
     * @param valorUnitario the valorUnitario to set
     */
    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    /**
     * @return the valorTotal
     */
    public Double getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    /*
   
    public int getProdutos() {
        return produtos;
    }

    public void setProdutos(int produtos) {
        this.produtos = produtos;
    }
     */
    /**
     * @return the produto
     */
    public MoProdutos getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(MoProdutos produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final MoPdvItens other = (MoPdvItens) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * @return the venda
     */
    public MoPdv getVenda() {
        return venda;
    }

    /**
     * @param venda the venda to set
     */
    public void setVenda(MoPdv venda) {
        this.venda = venda;
    }

    public void setProduto(Integer id_prod) {
        this.id = id_prod;
    }

    /**
     * @return the id_venda
     */
    public int getId_venda() {
        return id_venda;
    }

    /**
     * @param id_venda the id_venda to set
     */
    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

}
