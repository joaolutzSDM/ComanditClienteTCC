package br.com.alloy.comanditcliente.ui.pedidos;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;

import java.util.List;

import br.com.alloy.comanditcliente.R;
import br.com.alloy.comanditcliente.databinding.FragmentPedidosBinding;
import br.com.alloy.comanditcliente.service.ExceptionUtils;
import br.com.alloy.comanditcliente.service.RetrofitConfig;
import br.com.alloy.comanditcliente.service.dto.APIException;
import br.com.alloy.comanditcliente.service.model.Comanda;
import br.com.alloy.comanditcliente.service.model.Pedido;
import br.com.alloy.comanditcliente.ui.comanda.ComandaViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PedidosFragment extends Fragment implements Callback<List<Pedido>> {

    private FragmentPedidosBinding binding;
    private PedidosViewModel pedidosViewModel;
    private ComandaViewModel comandaViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPedidosBinding.inflate(inflater, container, false);
        pedidosViewModel = new ViewModelProvider(this).get(PedidosViewModel.class);
        comandaViewModel = new ViewModelProvider(requireActivity()).get(ComandaViewModel.class);
        setViewModelObserversAndListeners();
        //carrega os pedidos
        binding.swipeRefreshPedidos.setRefreshing(true);
        carregarPedidos();
        return binding.getRoot();
    }

    private void setViewModelObserversAndListeners() {
        //adiciona linha dos itens da lista de pedidos
        binding.recyclerViewPedidos.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
        //dados da comanda
        pedidosViewModel.getPedidos().observe(getViewLifecycleOwner(), pedidos -> {
            binding.recyclerViewPedidos.setAdapter(new PedidoAdapter(pedidos));
        });
        //setting carregarPedidos as the method for the swipe down refresh layout
        binding.swipeRefreshPedidos.setOnRefreshListener(this::carregarPedidos);
    }

    private void carregarPedidos() {
        //TODO - Remover em prod (chamada à API Mock)
        //Comanda comanda = comandaViewModel.getComanda().getValue();
        RetrofitConfig.getComanditAPIMock().consultarPedidosComandaResumo().enqueue(this);
    }

    @Override
    public void onResponse(Call<List<Pedido>> call, Response<List<Pedido>> response) {
        if(binding.swipeRefreshPedidos.isRefreshing()) {
            binding.swipeRefreshPedidos.setRefreshing(false);
        }
        if(response.isSuccessful()) {
            List<Pedido> pedidos = response.body();
            pedidosViewModel.setPedidos(pedidos);
        } else {
            APIException exception = ExceptionUtils.parseException(response);
            Log.e(getString(R.string.api_exception), exception.getMessage());
            Toast.makeText(getContext(), exception.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Call<List<Pedido>> call, Throwable t) {
        if(binding.swipeRefreshPedidos.isRefreshing()) {
            binding.swipeRefreshPedidos.setRefreshing(false);
        }
        Toast.makeText(getContext(), R.string.requestError, Toast.LENGTH_SHORT).show();
    }

}