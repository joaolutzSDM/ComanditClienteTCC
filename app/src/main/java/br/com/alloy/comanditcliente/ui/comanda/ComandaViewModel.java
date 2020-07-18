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
        //Mock para Testes
        Comanda c = new Comanda();
        c.setIdComanda(1);
        c.setNumeroMesa(1);
        c.setSenhaAcessoMobile("ABCDEF");
        c.setHoraAbertura(new Date());
        comanda.setValue(c);
    }

    public LiveData<Comanda> getComanda() {
        return comanda;
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