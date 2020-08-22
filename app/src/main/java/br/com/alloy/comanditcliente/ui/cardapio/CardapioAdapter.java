package br.com.alloy.comanditcliente.ui.cardapio;

import android.content.ClipData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import com.bumptech.glide.Glide;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.alloy.comanditcliente.R;
import br.com.alloy.comanditcliente.databinding.ItemCategoriaBinding;
import br.com.alloy.comanditcliente.databinding.ItemProdutoBinding;
import br.com.alloy.comanditcliente.service.model.Produto;
import br.com.alloy.comanditcliente.service.model.ProdutoCategoria;

public class CardapioAdapter extends BaseExpandableListAdapter {

    private List<ProdutoCategoria> categorias;
    private Map<Integer, List<Produto>> produtos;
    private String produtoImageUrl = "";
    private int lastExpandedGroup;

    public CardapioAdapter(List<ProdutoCategoria> categorias) {
        this.categorias = categorias;
        this.produtos = new HashMap<>();
    }

    public int getLastExpandedGroup() {
        return lastExpandedGroup;
    }

    public void setLastExpandedGroup(int lastExpandedGroup) {
        this.lastExpandedGroup = lastExpandedGroup;
    }

    public Map<Integer, List<Produto>> getProdutos() {
        return produtos;
    }

    @Override
    public int getGroupCount() {
        return categorias.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return produtos.get(categorias.get(groupPosition).getIdProdutoCategoria()).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return categorias.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return produtos.get(categorias.get(groupPosition).getIdProdutoCategoria()).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return categorias.get(groupPosition).getIdProdutoCategoria();
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return produtos.get(categorias.get(groupPosition).getIdProdutoCategoria()).get(childPosition).getIdProduto();
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    public ProdutoCategoria getCategoria(int groupPosition) {
        return categorias.get(groupPosition);
    }

    private Produto getProduto(int groupPosition, int childPosition) {
        return produtos.get(categorias.get(groupPosition).getIdProdutoCategoria()).get(childPosition);
    }

    public void updateProdutos(Integer idProdutoCategoria, List<Produto> produtos) {
        this.produtos.put(idProdutoCategoria, produtos);
        notifyDataSetChanged();
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ItemCategoriaBinding binding;
        if(convertView == null) {
            binding = ItemCategoriaBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            convertView = binding.getRoot();
            convertView.setTag(binding);
        } else {
            binding = (ItemCategoriaBinding) convertView.getTag();
        }
        ProdutoCategoria categoria = getCategoria(groupPosition);
        binding.nomeCategoria.setText(categoria.getNomeCategoriaCardapio());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ItemProdutoBinding binding;
        if(convertView == null) {
            binding = ItemProdutoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            convertView = binding.getRoot();
            convertView.setTag(binding);
        } else {
            binding = (ItemProdutoBinding) convertView.getTag();
        }
        Produto produto = getProduto(groupPosition, childPosition);
        binding.nomeProduto.setText(produto.getNomeProdutoCardapio());
        if(produto.getIngredientesProdutoCardapio() != null && !produto.getIngredientesProdutoCardapio().trim().isEmpty()) {
            binding.ingredientes.setText(produto.getIngredientesProdutoCardapio());
        }
        if(produto.getDisponivel()) {
           binding.status.setVisibility(View.GONE);
        } else {
            binding.status.setVisibility(View.VISIBLE);
        }
        //TODO Rever forma de carregamento das imagens dos produtos
        Glide.with(convertView)
                .load(produtoImageUrl.concat(produto.getIdProduto().toString()))
                .into(binding.fotoProduto);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}