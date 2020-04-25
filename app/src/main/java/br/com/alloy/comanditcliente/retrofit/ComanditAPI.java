package br.com.alloy.comanditcliente.retrofit;

import br.com.alloy.comanditcliente.retrofit.dto.CategoriasResponse;
import br.com.alloy.comanditcliente.retrofit.dto.ComandaRequest;
import br.com.alloy.comanditcliente.retrofit.dto.ComandaResponse;
import br.com.alloy.comanditcliente.retrofit.dto.PedidosResponse;
import br.com.alloy.comanditcliente.retrofit.dto.ProdutosRequest;
import br.com.alloy.comanditcliente.retrofit.dto.ProdutosResponse;
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