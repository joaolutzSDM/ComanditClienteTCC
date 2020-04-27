package br.com.alloy.comanditcliente.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Comanda {

    @SerializedName("ID_COMANDA")
    private Integer idComanda;
    @SerializedName("NUMERO_MESA")
    private Integer numeroMesa;
    @SerializedName("SENHA_ACESSO_MOBILE")
    private String senhaAcessoMobile;
    @SerializedName("HORA_ABERTURA")
    private Date horaAbertura;

    public Integer getIdComanda() {
        return idComanda;
    }

    public void setIdComanda(Integer idComanda) {
        this.idComanda = idComanda;
    }

    public Integer getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(Integer numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public String getSenhaAcessoMobile() {
        return senhaAcessoMobile;
    }

    public void setSenhaAcessoMobile(String senhaAcessoMobile) {
        this.senhaAcessoMobile = senhaAcessoMobile;
    }

    public Date getHoraAbertura() {
        return horaAbertura;
    }

    public void setHoraAbertura(Date horaAbertura) {
        this.horaAbertura = horaAbertura;
    }

}
