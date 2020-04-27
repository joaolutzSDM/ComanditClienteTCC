package br.com.alloy.comanditcliente.api.callback;

import android.util.Log;

import java.util.List;

import br.com.alloy.comanditcliente.api.dto.CategoriasResponse;
import br.com.alloy.comanditcliente.api.model.ProdutoCategoria;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriasResponseCallback implements Callback<CategoriasResponse>, ICallback<CategoriasResponse> {

    private CategoriasResponse data;

    @Override
    public void onResponse(Call<CategoriasResponse> call, Response<CategoriasResponse> response) {
        if(response.isSuccessful()) {
            data = response.body();
        } else {
            this.onFailure(call, null);
        }
    }

    @Override
    public void onFailure(Call<CategoriasResponse> call, Throwable t) {
        Log.e("CategoriasCallback", "onFailure: ", t);
        data = null;
    }

    @Override
    public CategoriasResponse getResponse() {
        return data;
    }

}
