package br.com.alloy.comanditcliente.ui.cardapio;

import java.util.List;

import br.com.alloy.comanditcliente.service.ExceptionUtils;
import br.com.alloy.comanditcliente.service.RetrofitConfig;
import br.com.alloy.comanditcliente.service.model.Produto;
import br.com.alloy.comanditcliente.service.model.ProdutoCategoria;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CardapioRepository {

    private CardapioResponseListener listener;

    public CardapioRepository(CardapioResponseListener listener) {
        this.listener = listener;
    }

    protected void getCategorias() {
        RetrofitConfig.getComanditAPIMock().consultarCategorias().enqueue(new Callback<List<ProdutoCategoria>>() {
            @Override
            public void onResponse(Call<List<ProdutoCategoria>> call, Response<List<ProdutoCategoria>> response) {
                if(response.isSuccessful()) {
                    listener.onCategoriasResponse(response.body());
                } else {
                    listener.onAPIException(ExceptionUtils.parseException(response));
                }
            }

            @Override
            public void onFailure(Call<List<ProdutoCategoria>> call, Throwable t) {
                listener.onRequestFailure(t);
            }
        });
    }

    protected void getProdutos(ProdutoCategoria categoria) {
        RetrofitConfig.getComanditAPIMock().consultarProdutosCategoria().enqueue(new Callback<List<Produto>>() {
            @Override
            public void onResponse(Call<List<Produto>> call, Response<List<Produto>> response) {
                if(response.isSuccessful()) {
                    listener.onProdutosResponse(response.body(), categoria.getIdProdutoCategoria());
                } else {
                    listener.onAPIException(ExceptionUtils.parseException(response));
                }
            }

            @Override
            public void onFailure(Call<List<Produto>> call, Throwable t) {
                listener.onRequestFailure(t);
            }
        });
    }

}
