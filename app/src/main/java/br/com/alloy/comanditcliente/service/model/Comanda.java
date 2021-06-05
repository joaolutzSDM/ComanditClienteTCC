package br.com.alloy.comanditcliente.service.model;

import java.io.Serializable;
import java.util.Date;

public class Comanda implements Serializable {

    private Integer idComanda;
    private Integer numeroMesa;
    private String senhaAcessoMobile;
    private Date horaAlteracao;

    public Comanda() {
    }

    public Comanda(Integer idComanda, String senhaAcessoMobile) {
        this.idComanda = idComanda;
        this.senhaAcessoMobile = senhaAcessoMobile;
    }

    public Comanda(Integer idComanda, Integer numeroMesa, String senhaAcessoMobile) {
        this(idComanda, senhaAcessoMobile);
        this.numeroMesa = numeroMesa;
    }

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

    public Date getHoraAlteracao() {
        return horaAlteracao;
    }

    public void setHoraAlteracao(Date horaAlteracao) {
        this.horaAlteracao = horaAlteracao;
    }

    @Override
    public String toString() {
        return "Comanda{" +
                "idComanda=" + idComanda +
                ", numeroMesa=" + numeroMesa +
                ", senhaAcessoMobile='" + senhaAcessoMobile + '\'' +
                ", horaAlteracao=" + horaAlteracao +
                '}';
    }
}
