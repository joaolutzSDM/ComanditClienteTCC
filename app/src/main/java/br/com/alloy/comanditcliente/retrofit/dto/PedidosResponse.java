package br.com.alloy.comanditcliente.retrofit.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import br.com.alloy.comanditcliente.retrofit.model.Pedido;

public class PedidosResponse extends Response<PedidosResponse> {

    private List<Pedido> pedidos;
    private String valorTotalComanda;
    private Boolean comServico;
    private String taxaServico;
    private String valorServico;
    private String valorTotalComServico;

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public String getValorTotalComanda() {
        return valorTotalComanda;
    }

    public void setValorTotalComanda(String valorTotalComanda) {
        this.valorTotalComanda = valorTotalComanda;
    }

    public Boolean getComServico() {
        return comServico;
    }

    public void setComServico(Boolean comServico) {
        this.comServico = comServico;
    }

    public String getTaxaServico() {
        return taxaServico;
    }

    public void setTaxaServico(String taxaServico) {
        this.taxaServico = taxaServico;
    }

    public String getValorServico() {
        return valorServico;
    }

    public void setValorServico(String valorServico) {
        this.valorServico = valorServico;
    }

    public String getValorTotalComServico() {
        return valorTotalComServico;
    }

    public void setValorTotalComServico(String valorTotalComServico) {
        this.valorTotalComServico = valorTotalComServico;
    }

}
