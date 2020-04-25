package br.com.alloy.comanditcliente.retrofit.model;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class Pedido {

    @SerializedName("ID_COMANDA")
    private Integer idComanda;
    @SerializedName("ID_PRODUTO_PD")
    private Integer idProduto;
    @SerializedName("NOME_PRODUTO_PD")
    private String nomeProduto;
    @SerializedName("VALOR_PRODUTO_PD")
    private BigDecimal valorProduto;
    @SerializedName("QUANTIDADE_PEDIDO")
    private Integer quantidadePedido;
    @SerializedName("VALOR_PEDIDO")
    private BigDecimal valorPedido;
    @SerializedName("ID_PEDIDO_HISTORICO")
    private Integer idPedidoHistorico;
    @SerializedName("ID_PEDIDO")
    private Integer idPedido;
    @SerializedName("VALOR_TOTAL_PEDIDO")
    private BigDecimal valorTotalPedido;

    public Integer getIdComanda() {
        return idComanda;
    }

    public void setIdComanda(Integer idComanda) {
        this.idComanda = idComanda;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public BigDecimal getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(BigDecimal valorProduto) {
        this.valorProduto = valorProduto;
    }

    public Integer getQuantidadePedido() {
        return quantidadePedido;
    }

    public void setQuantidadePedido(Integer quantidadePedido) {
        this.quantidadePedido = quantidadePedido;
    }

    public BigDecimal getValorPedido() {
        return valorPedido;
    }

    public void setValorPedido(BigDecimal valorPedido) {
        this.valorPedido = valorPedido;
    }

    public Integer getIdPedidoHistorico() {
        return idPedidoHistorico;
    }

    public void setIdPedidoHistorico(Integer idPedidoHistorico) {
        this.idPedidoHistorico = idPedidoHistorico;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public BigDecimal getValorTotalPedido() {
        return valorTotalPedido;
    }

    public void setValorTotalPedido(BigDecimal valorTotalPedido) {
        this.valorTotalPedido = valorTotalPedido;
    }

}
