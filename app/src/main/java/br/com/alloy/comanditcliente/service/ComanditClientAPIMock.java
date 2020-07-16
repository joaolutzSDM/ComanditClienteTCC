package br.com.alloy.comanditcliente.service;

import java.util.List;

import br.com.alloy.comanditcliente.service.model.Comanda;
import br.com.alloy.comanditcliente.service.model.Conta;
import br.com.alloy.comanditcliente.service.model.Pedido;
import br.com.alloy.comanditcliente.service.model.Produto;
import br.com.alloy.comanditcliente.service.model.ProdutoCategoria;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ComanditClientAPIMock {
        @GET("comandaLogin.json")
        Call<Comanda> comandaLogin();

        @GET("categorias.json")
        Call<List<ProdutoCategoria>> consultarCategorias();

        @GET("produtos.json")
        Call<List<Produto>> consultarProdutosCategoria();

        @GET("pedidosAgrupados.json")
        Call<List<Pedido>> consultarPedidosComanda();

        @GET("pedidosResumo.json")
        Call<List<Pedido>> consultarPedidosComandaResumo();

        @GET("conta.json")
        Call<Conta> consultarContaComanda();
}
