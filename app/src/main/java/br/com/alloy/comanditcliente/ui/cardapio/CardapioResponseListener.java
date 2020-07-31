package br.com.alloy.comanditcliente.ui.cardapio;

import java.util.List;

import br.com.alloy.comanditcliente.service.dto.APIException;
import br.com.alloy.comanditcliente.service.model.Produto;
import br.com.alloy.comanditcliente.service.model.ProdutoCategoria;

public interface CardapioResponseListener {

    void onCategoriasResponse(List<ProdutoCategoria> categorias);
    void onProdutosResponse(List<Produto> produtos, Integer idCategoria);
    void onAPIException(APIException ex);
    void onRequestFailure(Throwable t);

}
