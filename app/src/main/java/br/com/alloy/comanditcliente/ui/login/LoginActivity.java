package br.com.alloy.comanditcliente.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import br.com.alloy.comanditcliente.MainActivity;
import br.com.alloy.comanditcliente.R;
import br.com.alloy.comanditcliente.databinding.ActivityLoginBinding;
import br.com.alloy.comanditcliente.service.ExceptionUtils;
import br.com.alloy.comanditcliente.service.RetrofitConfig;
import br.com.alloy.comanditcliente.service.dto.APIException;
import br.com.alloy.comanditcliente.service.model.Comanda;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements Callback<Comanda> {

    private LoginViewModel loginViewModel;
    private ActivityLoginBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        setObserversAndListeners();
    }

    private void setObserversAndListeners() {
        binding.login.setOnClickListener(this::onLoginClick);
        binding.loginQrcode.setOnClickListener(this::qrCodeLogin);
        loginViewModel.getLoginFormState().observe(this, loginFormState -> {
            if (loginFormState == null) {
                return;
            }
            binding.login.setEnabled(loginFormState.isDataValid());
            if (loginFormState.getUsernameError() != null) {
                binding.comanda.setError(getString(loginFormState.getUsernameError()));
            }
            if (loginFormState.getPasswordError() != null) {
                binding.password.setError(getString(loginFormState.getPasswordError()));
            }
        });
        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                loginViewModel.loginDataChanged(binding.comanda.getText().toString(),
                        binding.password.getText().toString());
            }
        };
        binding.comanda.addTextChangedListener(afterTextChangedListener);
        binding.password.addTextChangedListener(afterTextChangedListener);
        binding.password.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                doLogin(binding.comanda.getText().toString(), binding.password.getText().toString());
            }
            return false;
        });
    }

    public void onLoginClick(View view) {
        doLogin(binding.comanda.getText().toString(), binding.password.getText().toString());
    }

    public void qrCodeLogin(View view) {
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
        integrator.setPrompt(getString(R.string.qrcode_scan_prompt));
        integrator.setCameraId(0);
        integrator.setOrientationLocked(false);
        integrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() != null) {
                //código lido corretamente
                String qrCode = result.getContents();
                if(qrCode.contains("Comandit")) {
                    String[] comanda = qrCode.split("-",3);
                    if(comanda.length == 3) {
                        try {
                            Integer.parseInt(comanda[1]);
                            doLogin(comanda[1], comanda[2]);
                        } catch(NumberFormatException ex) {
                            Toast.makeText(this, R.string.invalid_qrcode, Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(this, R.string.invalid_qrcode, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, R.string.invalid_qrcode, Toast.LENGTH_SHORT).show();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void doLogin(String idComanda, String senhaAcessoMobile) {
        binding.loading.setVisibility(View.VISIBLE);
        Comanda comanda = new Comanda(Integer.parseInt(idComanda), senhaAcessoMobile);
        RetrofitConfig.getComanditAPI().comandaLogin(comanda).enqueue(this);
    }

    @Override
    public void onResponse(Call<Comanda> call, Response<Comanda> response) {
        binding.loading.setVisibility(View.GONE);
        if(response.isSuccessful()) {
            //login realizado com sucesso, redireciona para a tela principal (MainActivity)
            Comanda comanda = response.body();
            startMainActivity(comanda);
        } else {
            APIException exception = ExceptionUtils.parseException(response);
            Log.e(getString(R.string.api_exception), exception.getMessage());
            Toast.makeText(this, exception.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Call<Comanda> call, Throwable t) {
        binding.loading.setVisibility(View.GONE);
        Log.e(getString(R.string.comm_failure), t.getMessage(), t);
        Toast.makeText(this, R.string.requestError, Toast.LENGTH_LONG).show();
    }

    private void startMainActivity(Comanda comanda) {
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("comanda", comanda);
        startActivity(i);
        finish(); //encerra a tela atual (login)
    }

}