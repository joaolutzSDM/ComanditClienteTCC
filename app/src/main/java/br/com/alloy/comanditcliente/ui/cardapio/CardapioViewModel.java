package br.com.alloy.comanditcliente.ui.cardapio;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import br.com.alloy.comanditcliente.service.model.Produto;
import br.com.alloy.comanditcliente.service.model.ProdutoCategoria;

public class CardapioViewModel extends ViewModel {

    private MutableLiveData<List<ProdutoCategoria>> categorias;
    private MutableLiveData<List<Produto>> produtos;

    public CardapioViewModel() {
        categorias = new MutableLiveData<>();
        produtos = new MutableLiveData<>();
    }

    public LiveData<List<ProdutoCategoria>> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<ProdutoCategoria> categorias) {
        this.categorias.setValue(categorias);
    }

    public LiveData<List<Produto>> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos.setValue(produtos);
    }
}