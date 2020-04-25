package br.com.alloy.comanditcliente.retrofit.model;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class Produto {

    @SerializedName("ID_PRODUTO")
    private Integer idProduto;
    @SerializedName("NOME_PRODUTO")
    private String nomeProduto;
    @SerializedName("NOME_PRODUTO_CARDAPIO")
    private String nomeProdutoCardapio;
    @SerializedName("INGREDIENTES_PRODUTO_CARDAPIO")
    private String ingredientesProdutoCardapio;
    @SerializedName("VALOR_PRODUTO")
    private BigDecimal valorProduto;
    private Boolean ativo;
    private Boolean disponivel;

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getNomeProdutoCardapio() {
        return nomeProdutoCardapio;
    }

    public void setNomeProdutoCardapio(String nomeProdutoCardapio) {
        this.nomeProdutoCardapio = nomeProdutoCardapio;
    }

    public String getIngredientesProdutoCardapio() {
        return ingredientesProdutoCardapio;
    }

    public void setIngredientesProdutoCardapio(String ingredientesProdutoCardapio) {
        this.ingredientesProdutoCardapio = ingredientesProdutoCardapio;
    }

    public BigDecimal getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(BigDecimal valorProduto) {
        this.valorProduto = valorProduto;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

}
