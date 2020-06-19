package br.com.alloy.comanditcliente.ui.comanda;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ComandaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ComandaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}