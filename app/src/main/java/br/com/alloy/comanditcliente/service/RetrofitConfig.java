package br.com.alloy.comanditcliente.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    private static ComanditClientAPI comanditClientAPI;
    private static ComanditClientAPIMock comanditClientAPIMock;
    private static final String BASE_URL = "http://WORKSTATION:3312/comandit/api/cliente/";
    private static final String BASE_URL_MOCK = "https://comandit.github.io/mock/comanditclientapi/";

    public static ComanditClientAPI getComanditAPI() {
        if(comanditClientAPI == null) {
            comanditClientAPI = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ComanditClientAPI.class);
        }
        return comanditClientAPI;
    }

    public static ComanditClientAPIMock getComanditAPIMock() {
        if(comanditClientAPIMock == null) {
            comanditClientAPIMock = new Retrofit.Builder()
                    .baseUrl(BASE_URL_MOCK)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ComanditClientAPIMock.class);
        }
        return comanditClientAPIMock;
    }

}
