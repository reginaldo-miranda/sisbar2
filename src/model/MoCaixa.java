/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dao.EntidadeBase;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author suporte11-pc
 */
@Entity

@Table(name = "caixa")
public class MoCaixa implements EntidadeBase, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Double valotTotal;
    private Double faltaReceber;
    private Double valorTroco;

    private Double valorRecebido;

    private String tiporecebido;
    private int parcelas;

  //  private Double total = 0.0, falta = 0.0, troco = 0.0;
    private Double dinheiro = 0.0, cartao = 0.0, pix = 0.0, cheque = 0.0;

    public MoCaixa() {
    }

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
     * @return the valotTotal
     */
    public Double getValotTotal() {
        return valotTotal;
    }

    /**
     * @param valotTotal the valotTotal to set
     */
    public void setValotTotal(Double valotTotal) {
        this.valotTotal = valotTotal;
    }

    /**
     * @return the valorRecebido
     */
    public Double getValorRecebido() {
        return valorRecebido;
    }

    /**
     * @param valorRecebido the valorRecebido to set
     */
    public void setValorRecebido(Double valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

    /**
     * @return the faltaReceber
     */
    public Double getFaltaReceber() {
        return faltaReceber;
    }

    /**
     * @param faltaReceber the faltaReceber to set
     */
    public void setFaltaReceber(Double faltaReceber) {
        this.faltaReceber = faltaReceber;
    }

    /**
     * @return the valorTroco
     */
    public Double getValorTroco() {
        return valorTroco;
    }

    /**
     * @param valorTroco the valorTroco to set
     */
    public void setValorTroco(Double valorTroco) {
        this.valorTroco = valorTroco;
    }

    /**
     * @return the tiporecebido
     */
    public String getTiporecebido() {
        return tiporecebido;
    }

    /**
     * @param tiporecebido the tiporecebido to set
     */
    public void setTiporecebido(String tiporecebido) {
        this.tiporecebido = tiporecebido;
    }

    /**
     * @return the parcelas
     */
    public int getParcelas() {
        return parcelas;
    }

    /**
     * @param parcelas the parcelas to set
     */
    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.id;
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
        final MoCaixa other = (MoCaixa) obj;
        return this.id == other.id;
    }

}
