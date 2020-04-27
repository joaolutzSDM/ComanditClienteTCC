package br.com.alloy.comanditcliente.api.dto;

import java.util.List;

import br.com.alloy.comanditcliente.api.model.Produto;

public class ProdutosResponse extends Response<List<Produto>> {

    @Override
    public String toString() {
        return "ProdutosResponse{" + super.toString() + "}";
    }

}
