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

public interface ComanditClientAPI {

    @POST("comanda/login")
    Call<Comanda> comandaLogin(@Body Comanda comanda);

    @GET("produto/consultar/categorias")
    Call<List<ProdutoCategoria>> consultarCategorias();

    @POST("produto/consultar/categoria")
    Call<List<Produto>> consultarProdutosCategoria(@Body ProdutoCategoria produtoCategoria);

    @POST("pedido/consultar/comanda/resumo")
    Call<List<Pedido>> consultarPedidosComanda(@Body Comanda comanda);

    @POST("pedido/consultar/conta")
    Call<Conta> consultarContaComanda(@Body Comanda comanda);

}