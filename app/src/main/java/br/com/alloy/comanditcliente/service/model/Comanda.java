package br.com.alloy.comanditcliente.service.model;

import java.util.Date;

public class Comanda {

    private Integer idComanda;
    private Integer numeroMesa;
    private String senhaAcessoMobile;
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

    @Override
    public String toString() {
        return "Comanda{" +
                "idComanda=" + idComanda +
                ", numeroMesa=" + numeroMesa +
                ", senhaAcessoMobile='" + senhaAcessoMobile + '\'' +
                ", horaAbertura=" + horaAbertura +
                '}';
    }
}
