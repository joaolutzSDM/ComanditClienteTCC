package br.com.alloy.comanditcliente.service.model;

import java.util.Objects;

public class ProdutoCategoria {

    private Integer idProdutoCategoria;
    private String nomeCategoria;
    private String nomeCategoriaCardapio;
    private Boolean ativo;

    public Integer getIdProdutoCategoria() {
        return idProdutoCategoria;
    }

    public void setIdProdutoCategoria(Integer idProdutoCategoria) {
        this.idProdutoCategoria = idProdutoCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getNomeCategoriaCardapio() {
        return nomeCategoriaCardapio;
    }

    public void setNomeCategoriaCardapio(String nomeCategoriaCardapio) {
        this.nomeCategoriaCardapio = nomeCategoriaCardapio;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoCategoria that = (ProdutoCategoria) o;
        return idProdutoCategoria.equals(that.idProdutoCategoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProdutoCategoria);
    }

    @Override
    public String toString() {
        return "ProdutoCategoria{" +
                "idProdutoCategoria=" + idProdutoCategoria +
                ", nomeCategoria='" + nomeCategoria + '\'' +
                ", nomeCategoriaCardapio='" + nomeCategoriaCardapio + '\'' +
                ", ativo=" + ativo +
                '}';
    }

}
