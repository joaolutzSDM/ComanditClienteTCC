package br.com.alloy.comanditcliente.ui.pedidos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import br.com.alloy.comanditcliente.databinding.ItemPedidoBinding;
import br.com.alloy.comanditcliente.service.model.Pedido;
import br.com.alloy.comanditcliente.ui.util.StringUtil;

public class PedidoAdapter extends RecyclerView.Adapter<PedidoAdapter.PedidoHolder> {

    private final List<Pedido> pedidos;
    private SimpleDateFormat timeOrderFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());

    public PedidoAdapter(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public PedidoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PedidoHolder(ItemPedidoBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent,false));
    }

    @Override
    public void onBindViewHolder(PedidoHolder holder, int position) {
        Pedido pedido = pedidos.get(position);
        holder.binding.nomeProduto.setText(pedido.getProduto().getNomeProdutoCardapio());
        holder.binding.quantidadePedido.setText(String.format(Locale.getDefault(), "x%d", pedido.getQuantidadePedido()));
        holder.binding.valorPedido.setText(StringUtil.getCurrencyStringWithoutR$(pedido.getValorTotal()));
        if(pedido.getPedidoHistorico() != null) {
            holder.binding.horaPedido.setText(timeOrderFormat.format(pedido.getPedidoHistorico().getDataPedido()));
            holder.binding.horaPedidoLayout.setVisibility(View.VISIBLE);
        } else {
            holder.binding.horaPedidoLayout.setVisibility(View.INVISIBLE);
        }

        if(pedido.getObservacaoPedido() == null || pedido.getObservacaoPedido().trim().isEmpty()) {
            holder.binding.observacaoPedido.setVisibility(View.GONE);
        } else {
            holder.binding.observacaoPedido.setText(pedido.getObservacaoPedido());
            holder.binding.observacaoPedido.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return pedidos != null ? pedidos.size() : 0;
    }

    static class PedidoHolder extends RecyclerView.ViewHolder {

        private ItemPedidoBinding binding;

        PedidoHolder(ItemPedidoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }

}