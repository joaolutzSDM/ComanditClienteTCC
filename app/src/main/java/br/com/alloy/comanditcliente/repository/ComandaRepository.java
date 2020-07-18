package br.com.alloy.comanditcliente.repository;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import br.com.alloy.comanditcliente.R;
import br.com.alloy.comanditcliente.service.ExceptionUtils;
import br.com.alloy.comanditcliente.service.RetrofitConfig;
import br.com.alloy.comanditcliente.service.dto.APIException;
import br.com.alloy.comanditcliente.service.model.Comanda;
import br.com.alloy.comanditcliente.service.model.Conta;
import br.com.alloy.comanditcliente.ui.comanda.ComandaViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ComandaRepository {

    private Context context;
    private ComandaViewModel comandaViewModel;

    public ComandaRepository(Context context, ComandaViewModel comandaViewModel) {
        this.context = context;
        this.comandaViewModel = comandaViewModel;
    }

    public void comandaLogin() {
        RetrofitConfig.getComanditAPI().comandaLogin().enqueue(new Callback<Comanda>() {
            @Override
            public void onResponse(Call<Comanda> call, Response<Comanda> response) {
                if(response.isSuccessful()) {
                    comandaViewModel.setComanda(response.body());
                } else {
                    APIException exception = ExceptionUtils.parseException(response);
                    Log.e(context.getString(R.string.api_exception), exception.getMessage());
                    Toast.makeText(context, exception.getMessage(), Toast.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<Comanda> call, Throwable t) {
                Toast.makeText(context, R.string.erroRequest, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getContaComanda() {
        RetrofitConfig.getComanditAPI().consultarContaComanda().enqueue(new Callback<Conta>() {
            @Override
            public void onResponse(Call<Conta> call, Response<Conta> response) {
                if(response.isSuccessful()) {
                    comandaViewModel.setConta(response.body());
                } else {
                    APIException exception = ExceptionUtils.parseException(response);
                    Log.e(context.getString(R.string.api_exception), exception.getMessage());
                    Toast.makeText(context, exception.getMessage(), Toast.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<Conta> call, Throwable t) {
                Toast.makeText(context, R.string.erroRequest, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
