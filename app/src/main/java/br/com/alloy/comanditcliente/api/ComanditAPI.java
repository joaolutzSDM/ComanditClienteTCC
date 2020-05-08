package br.com.alloy.comanditcliente.api;

import java.util.List;

import br.com.alloy.comanditcliente.api.model.Comanda;
import br.com.alloy.comanditcliente.api.model.Pedido;
import br.com.alloy.comanditcliente.api.model.Produto;
import br.com.alloy.comanditcliente.api.model.ProdutoCategoria;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ComanditAPI {

    @POST("comanda/login")
    Call<Comanda> comandaLogin(@Body Comanda comanda);

    @GET("produtos/consultarCategorias")
    Call<List<ProdutoCategoria>> consultarCategorias();

    @POST("produtos/consultarPorCategoria")
    Call<List<Produto>> consultarProdutosCategoria(@Body ProdutoCategoria produtoCategoria);

    @POST("pedido/consultar/comanda")
    Call<List<Pedido>> consultarPedidosComanda(@Body Comanda comanda);

}