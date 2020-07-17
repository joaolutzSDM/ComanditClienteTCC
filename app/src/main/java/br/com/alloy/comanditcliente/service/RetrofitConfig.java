package br.com.alloy.comanditcliente.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    private ComanditClientAPI comanditClientAPI; // http://WORKSTATION:3312/comandit/api/cliente/
    private ComanditClientAPIMock comanditClientAPIMock; // https://comandit.github.io/mock/comanditclientapi/

    private RetrofitConfig() {
        comanditClientAPIMock = new Retrofit.Builder()
                .baseUrl("https://comandit.github.io/mock/comanditclientapi/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ComanditClientAPIMock.class);
    }

    public static RetrofitConfig getInstance() {
        return new RetrofitConfig();
    }

    public ComanditClientAPIMock getComanditAPI() {
        return comanditClientAPIMock;
    }

}
