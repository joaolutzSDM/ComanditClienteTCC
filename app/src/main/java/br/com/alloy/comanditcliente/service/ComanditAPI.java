package br.com.alloy.comanditcliente.service;

import java.util.List;

import br.com.alloy.comanditcliente.service.model.Comanda;
import br.com.alloy.comanditcliente.service.model.Conta;
import br.com.alloy.comanditcliente.service.model.Pedido;
import br.com.alloy.comanditcliente.service.model.Produto;
import br.com.alloy.comanditcliente.service.model.ProdutoCategoria;
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

    @POST("pedido/consultar/conta")
    Call<Conta> consultarContaComanda(@Body Comanda comanda);

}