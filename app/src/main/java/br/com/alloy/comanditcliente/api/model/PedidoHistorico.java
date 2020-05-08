package br.com.alloy.comanditcliente.api.model;

import java.util.Date;

public class PedidoHistorico {

    private Integer idPedidoHistorico;
    private Date dataPedido;
    private Produto produto;
    private Integer quantidadePedidoHistorico;

    public Integer getIdPedidoHistorico() {
        return idPedidoHistorico;
    }

    public void setIdPedidoHistorico(Integer idPedidoHistorico) {
        this.idPedidoHistorico = idPedidoHistorico;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidadePedidoHistorico() {
        return quantidadePedidoHistorico;
    }

    public void setQuantidadePedidoHistorico(Integer quantidadePedidoHistorico) {
        this.quantidadePedidoHistorico = quantidadePedidoHistorico;
    }

    @Override
    public String toString() {
        return "PedidoHistorico{" +
                "idPedidoHistorico=" + idPedidoHistorico +
                ", dataPedido=" + dataPedido +
                ", produto=" + produto +
                ", quantidadePedidoHistorico=" + quantidadePedidoHistorico +
                '}';
    }
}
