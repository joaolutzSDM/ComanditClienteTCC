package br.com.alloy.comanditcliente.service.model;

import java.math.BigDecimal;

public class Conta {

    private Comanda comanda;
    private Integer qtdItens;
    private Integer taxaServico;
    private BigDecimal valorPedidos;
    private BigDecimal valorServico;
    private BigDecimal valorCouvert;
    private BigDecimal valorTotal;

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

    public Integer getQtdItens() {
        return qtdItens;
    }

    public void setQtdItens(Integer qtdPedidos) {
        this.qtdItens = qtdPedidos;
    }

    /**
     * @return the taxaServico
     */
    public Integer getTaxaServico() {
        return taxaServico;
    }
    /**
     * @param taxaServico the taxaServico to set
     */
    public void setTaxaServico(Integer taxaServico) {
        this.taxaServico = taxaServico;
    }
    /**
     * @return the valorPedidos
     */
    public BigDecimal getValorPedidos() {
        return valorPedidos;
    }
    /**
     * @param valorPedidos the valorPedidos to set
     */
    public void setValorPedidos(BigDecimal valorPedidos) {
        this.valorPedidos = valorPedidos;
    }
    /**
     * @return the valorServico
     */
    public BigDecimal getValorServico() {
        return valorServico;
    }
    /**
     * @param valorServico the valorServico to set
     */
    public void setValorServico(BigDecimal valorServico) {
        this.valorServico = valorServico;
    }
    /**
     * @return the valorCouvert
     */
    public BigDecimal getValorCouvert() {
        return valorCouvert;
    }
    /**
     * @param valorCouvert the valorCouvert to set
     */
    public void setValorCouvert(BigDecimal valorCouvert) {
        this.valorCouvert = valorCouvert;
    }
    /**
     * @return the valorTotal
     */
    public BigDecimal getValorTotal() {
        return valorTotal;
    }
    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

}
