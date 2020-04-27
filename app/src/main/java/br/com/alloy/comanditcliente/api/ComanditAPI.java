package br.com.alloy.comanditcliente.api;

import br.com.alloy.comanditcliente.api.dto.CategoriasResponse;
import br.com.alloy.comanditcliente.api.dto.ComandaRequest;
import br.com.alloy.comanditcliente.api.dto.ComandaResponse;
import br.com.alloy.comanditcliente.api.dto.PedidosResponse;
import br.com.alloy.comanditcliente.api.dto.ProdutosRequest;
import br.com.alloy.comanditcliente.api.dto.ProdutosResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ComanditAPI {

    @POST("comanda/login")
    Call<ComandaResponse> comandaLogin(@Body ComandaRequest request);

    @GET("produtos/consultarCategorias")
    Call<CategoriasResponse> consultarCategorias();

    @POST("produtos/consultarPorCategoria")
    Call<ProdutosResponse> consultarProdutosCategoria(@Body ProdutosRequest request);

    @POST("pedidos/consultar")
    Call<PedidosResponse> consultarPedidosComanda(@Body ComandaRequest request);

}