package br.com.alloy.comanditcliente.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    private ComanditAPI comanditAPI;

    public RetrofitConfig() {
        comanditAPI = new Retrofit.Builder()
                .baseUrl("http://WORKSTATION:3312/comandit/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ComanditAPI.class);
    }

    public ComanditAPI getComanditAPI() {
        return comanditAPI;
    }

}
