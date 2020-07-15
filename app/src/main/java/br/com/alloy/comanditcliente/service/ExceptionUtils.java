package br.com.alloy.comanditcliente.service;

import com.google.gson.Gson;

import br.com.alloy.comanditcliente.service.dto.APIException;
import retrofit2.Response;

public class ExceptionUtils {

    public static APIException parseException(Response<?> response) {
        try {
            return new Gson().fromJson(response.errorBody().charStream(), APIException.class);
        } catch (Exception e) {
            return new APIException();
        }
    }

}
