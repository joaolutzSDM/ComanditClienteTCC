package br.com.alloy.comanditcliente.ui.pedidos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import br.com.alloy.comanditcliente.service.model.Pedido;

public class PedidosViewModel extends ViewModel {

    private MutableLiveData<List<Pedido>> pedidos;

    public PedidosViewModel() {
        pedidos = new MutableLiveData<>();
    }

    public LiveData<List<Pedido>> getPedidos() {
        return pedidos;
    }

    public List<Pedido> getPedidosList() {
        return pedidos.getValue();
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos.setValue(pedidos);
    }

}