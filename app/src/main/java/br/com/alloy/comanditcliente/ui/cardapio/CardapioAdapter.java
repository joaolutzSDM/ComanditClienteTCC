package br.com.alloy.comanditcliente.ui.cardapio;

import android.content.ClipData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Map;

import br.com.alloy.comanditcliente.R;
import br.com.alloy.comanditcliente.databinding.ItemCategoriaBinding;
import br.com.alloy.comanditcliente.databinding.ItemProdutoBinding;
import br.com.alloy.comanditcliente.service.model.Produto;
import br.com.alloy.comanditcliente.service.model.ProdutoCategoria;

public class CardapioAdapter extends BaseExpandableListAdapter {

    private List<ProdutoCategoria> categorias;
    private Map<ProdutoCategoria, List<Produto>> produtos;
    private String produtoImageUrl = "";

    public CardapioAdapter(List<ProdutoCategoria> categorias, Map<ProdutoCategoria, List<Produto>> produtos) {
        this.categorias = categorias;
        this.produtos = produtos;
    }

    @Override
    public int getGroupCount() {
        return categorias.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return produtos.get(categorias.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return categorias.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return produtos.get(categorias.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return categorias.get(groupPosition).getIdProdutoCategoria();
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return produtos.get(categorias.get(groupPosition)).get(childPosition).getIdProduto();
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    private ProdutoCategoria getCategoria(int groupPosition) {
        return categorias.get(groupPosition);
    }

    private Produto getProduto(int groupPosition, int childPosition) {
        return produtos.get(categorias.get(groupPosition)).get(childPosition);
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
        //TODO Rever forma de carregamento das imagens dos produtos
        Glide.with(convertView)
                .load(produtoImageUrl.concat(produto.getIdProduto().toString()))
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.fotoProduto);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}