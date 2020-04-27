package br.com.alloy.comanditcliente.api.dto;

import java.util.List;

import br.com.alloy.comanditcliente.api.model.ProdutoCategoria;

public class CategoriasResponse extends Response<List<ProdutoCategoria>> {

    @Override
    public String toString() {
        return "CategoriasResponse{" + super.toString() + "}";
    }

}
