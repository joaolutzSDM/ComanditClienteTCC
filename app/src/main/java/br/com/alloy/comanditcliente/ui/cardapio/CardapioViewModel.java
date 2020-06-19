package br.com.alloy.comanditcliente.ui.cardapio;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CardapioViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CardapioViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}