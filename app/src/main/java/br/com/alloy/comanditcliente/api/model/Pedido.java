package br.com.alloy.comanditcliente.api.model;

import java.math.BigDecimal;

public class Pedido {

    private Integer item;
    private Long idPedido;
    private Produto produto;
    private Integer quantidadePedido;
    private BigDecimal valorPedido;
    private String observacaoPedido;
    private PedidoHistorico pedidoHistorico;
    private BigDecimal valorTotal;

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public PedidoHistorico getPedidoHistorico() {
        return pedidoHistorico;
    }

    public void setPedidoHistorico(PedidoHistorico pedidoHistorico) {
        this.pedidoHistorico = pedidoHistorico;
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

    public String getObservacaoPedido() {
        return observacaoPedido;
    }

    public void setObservacaoPedido(String observacaoPedido) {
        this.observacaoPedido = observacaoPedido;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "item=" + item +
                ", idPedido=" + idPedido +
                ", produto=" + produto +
                ", quantidadePedido=" + quantidadePedido +
                ", valorPedido=" + valorPedido +
                ", observacaoPedido='" + observacaoPedido + '\'' +
                ", pedidoHistorico=" + pedidoHistorico +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
