package br.com.alloy.comanditcliente.retrofit.model;

import com.google.gson.annotations.SerializedName;

public class ProdutoCategoria {

    @SerializedName("ID_PRODUTO_CATEGORIA")
    private Integer idProdutoCategoria;
    @SerializedName("NOME_CATEGORIA")
    private String nomeCategoria;
    @SerializedName("NOME_CATEGORIA_CARDAPIO")
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

}
