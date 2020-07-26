package br.com.alloy.comanditcliente.ui.pedidos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import br.com.alloy.comanditcliente.R;
import br.com.alloy.comanditcliente.databinding.PedidoItemBinding;
import br.com.alloy.comanditcliente.service.model.Pedido;
import br.com.alloy.comanditcliente.ui.util.StringUtil;

public class PedidoAdapter extends RecyclerView.Adapter<PedidoAdapter.PedidoHolder> {

    private final List<Pedido> pedidos;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());

    public PedidoAdapter(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public PedidoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PedidoHolder(PedidoItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent,false));
    }

    @Override
    public void onBindViewHolder(PedidoHolder holder, int position) {
        Pedido pedido = pedidos.get(position);
        holder.binding.itemPedido.setText(String.format(Locale.getDefault(), "%d", pedido.getItem()));
        holder.binding.nomeProduto.setText(pedido.getProduto().getNomeProduto());
        holder.binding.quantidadePedido.setText(String.format(Locale.getDefault(), "%dx", pedido.getQuantidadePedido()));
        holder.binding.horaPedido.setText(simpleDateFormat.format(pedido.getPedidoHistorico().getDataPedido()));
        holder.binding.valorPedido.setText(StringUtil.formatCurrencyValue(pedido.getValorTotal()));

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

        private PedidoItemBinding binding;

        PedidoHolder(PedidoItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }

}