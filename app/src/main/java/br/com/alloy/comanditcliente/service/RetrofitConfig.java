package br.com.alloy.comanditcliente.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    private static ComanditClientAPI comanditClientAPI;
    private static final String BASE_URL = "http://WORKSTATION:3312/comandit/cliente/api/";

    public static ComanditClientAPI getComanditAPI() {
        if(comanditClientAPI == null) {
            comanditClientAPI = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ComanditClientAPI.class);
        }
        return comanditClientAPI;
    }

}
