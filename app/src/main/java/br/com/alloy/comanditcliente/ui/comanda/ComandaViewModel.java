package br.com.alloy.comanditcliente.ui.comanda;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Date;

import br.com.alloy.comanditcliente.service.model.Comanda;
import br.com.alloy.comanditcliente.service.model.Conta;

public class ComandaViewModel extends ViewModel {

    private MutableLiveData<Comanda> comanda;
    private MutableLiveData<Conta> conta;

    public ComandaViewModel() {
        comanda = new MutableLiveData<>();
        conta = new MutableLiveData<>();
    }

    public LiveData<Comanda> getComanda() {
        return comanda;
    }

    public Comanda getComandaForRequest() {
        return new Comanda(comanda.getValue().getIdComanda(), comanda.getValue().getSenhaAcessoMobile());
    }

    public LiveData<Conta> getConta() {
        return conta;
    }

    public void setComanda(Comanda comanda) {
        this.comanda.setValue(comanda);
    }

    public void setConta(Conta conta) {
        this.conta.setValue(conta);
    }

}