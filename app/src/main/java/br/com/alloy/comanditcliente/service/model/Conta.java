package br.com.alloy.comanditcliente.service.model;

import java.util.List;

public class Conta {

    private Comanda comanda;
    private List<ItemConta> itens;

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

    public List<ItemConta> getItens() {
        return itens;
    }

    public void setItens(List<ItemConta> itens) {
        this.itens = itens;
    }

}
