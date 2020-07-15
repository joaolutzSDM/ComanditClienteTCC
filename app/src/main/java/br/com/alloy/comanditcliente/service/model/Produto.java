package br.com.alloy.comanditcliente.service.model;

import java.math.BigDecimal;

public class Produto {

    private Integer idProduto;
    private String nomeProduto;
    private String nomeProdutoCardapio;
    private String ingredientesProdutoCardapio;
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

    @Override
    public String toString() {
        return "Produto{" +
                "idProduto=" + idProduto +
                ", nomeProduto='" + nomeProduto + '\'' +
                ", nomeProdutoCardapio='" + nomeProdutoCardapio + '\'' +
                ", ingredientesProdutoCardapio='" + ingredientesProdutoCardapio + '\'' +
                ", valorProduto=" + valorProduto +
                ", ativo=" + ativo +
                ", disponivel=" + disponivel +
                '}';
    }
}
