package br.com.alloy.comanditcliente.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import br.com.alloy.comanditcliente.R;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<LoginFormState> loginFormState = new MutableLiveData<>();

    LiveData<LoginFormState> getLoginFormState() {
        return loginFormState;
    }

    public void loginDataChanged(String comanda, String password) {
        if (!isValid(comanda)) {
            loginFormState.setValue(new LoginFormState(R.string.invalid_comanda, null));
        } else if (!isValid(password)) {
            loginFormState.setValue(new LoginFormState(null, R.string.invalid_password));
        } else {
            loginFormState.setValue(new LoginFormState(true));
        }
    }

    // A placeholder password validation check
    private boolean isValid(String value) {
        return value != null && !value.trim().isEmpty();
    }
}