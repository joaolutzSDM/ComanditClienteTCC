package br.com.alloy.comanditcliente.ui.comanda;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

import br.com.alloy.comanditcliente.databinding.ItemContaBinding;
import br.com.alloy.comanditcliente.databinding.ItemPedidoBinding;
import br.com.alloy.comanditcliente.service.model.ItemConta;
import br.com.alloy.comanditcliente.service.model.Pedido;
import br.com.alloy.comanditcliente.ui.pedidos.PedidoAdapter;

public class ContaAdapter extends RecyclerView.Adapter<ContaAdapter.ContaHolder> {

    private final List<ItemConta> itens;

    public ContaAdapter(List<ItemConta> itens) {
        this.itens = itens;
    }

    @NonNull
    @Override
    public ContaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContaAdapter.ContaHolder(ItemContaBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContaHolder holder, int position) {
        ItemConta item = itens.get(position);
        holder.binding.itemLabel.setText(item.getLabel());
        holder.binding.itemValue.setText(item.getValue());
    }

    @Override
    public int getItemCount() {
        return itens != null ? itens.size() : 0;
    }

    static class ContaHolder extends RecyclerView.ViewHolder {

        private ItemContaBinding binding;

        public ContaHolder(ItemContaBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
