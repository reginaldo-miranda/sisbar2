package model;

import dao.EntidadeBase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity

@NamedQueries({
    @NamedQuery(name = "MoPdv.todos", query = "SELECT pd FROM MoPdv pd"),

    @NamedQuery(name = "MoPdv.id", query = "SELECT pd FROM MoPdv pd where pd.id = :idpd")
})

@Table(name = "venda")
public class MoPdv implements EntidadeBase, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data")
    private Calendar data;

    private Double valorTotal;
    private Integer parcelas;
    private Integer id_clientes;
    @ManyToOne
    @JoinColumn(name="clientes", referencedColumnName ="id" )
    private MoClientes clientes;
 
    
    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY )
    private List<MoPdvItens> itens = new ArrayList<>();
    

    public MoPdv() {
        this.valorTotal = 0.0;
    }
    
    public void adicionarItens(MoPdvItens obj){
        obj.setVenda(this);
//        this.valorTotal  += obj.getValorTotal();
        this.getItens().add(obj);
        
    }
    
    public void removerItens(int index){
        MoPdvItens obj = this.getItens().get(index);
        this.valorTotal -= obj.getValorTotal();
        this.getItens().remove(index);
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer Id) {
        this.id = Id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getParcelas() {
        return parcelas;
    }

    public void setParcelas(Integer parcelas) {
        this.parcelas = parcelas;
    }

    public Integer getId_clientes() {
        return id_clientes;
    }

    public void setId_clientes(Integer id_clientes) {
        this.id_clientes = id_clientes;
    }

    /**
     * @return the clientes
     */
    public MoClientes getClientes() {
        return clientes;
    }

    /**
     * @param clientes the clientes to set
     */
    public void setClientes(MoClientes clientes) {
        this.clientes = clientes;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final MoPdv other = (MoPdv) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * @return the itens
     */
    public List<MoPdvItens> getItens() {
        return itens;
    }

    /**
     * @param itens the itens to set
     */
    public void setItens(List<MoPdvItens> itens) {
        this.itens = itens;
    }

}
