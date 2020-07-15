package br.com.alloy.comanditcliente.ui.comanda;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Date;

import br.com.alloy.comanditcliente.service.model.Comanda;

public class ComandaViewModel extends ViewModel {

    private MutableLiveData<Comanda> comanda;

    public ComandaViewModel() {
        comanda = new MutableLiveData<>();
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
}