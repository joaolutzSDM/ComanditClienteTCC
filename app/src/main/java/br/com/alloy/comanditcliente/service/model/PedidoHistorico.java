package br.com.alloy.comanditcliente.service.model;

import java.util.Date;

public class PedidoHistorico {

    private Integer idPedidoHistorico;
    private Date dataPedido;

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

    @Override
    public String toString() {
        return "PedidoHistorico{" +
                "idPedidoHistorico=" + idPedidoHistorico +
                ", dataPedido=" + dataPedido +
                '}';
    }
}
