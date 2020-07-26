package br.com.alloy.comanditcliente.ui.comanda;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Objects;

import br.com.alloy.comanditcliente.R;
import br.com.alloy.comanditcliente.databinding.FragmentComandaBinding;
import br.com.alloy.comanditcliente.service.ExceptionUtils;
import br.com.alloy.comanditcliente.service.RetrofitConfig;
import br.com.alloy.comanditcliente.service.dto.APIException;
import br.com.alloy.comanditcliente.service.model.Conta;
import br.com.alloy.comanditcliente.ui.util.StringUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ComandaFragment extends Fragment implements Callback<Conta> {

    private FragmentComandaBinding binding;
    private ComandaViewModel comandaViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentComandaBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        comandaViewModel = new ViewModelProvider(requireActivity()).get(ComandaViewModel.class);
        setViewModelObserversAndListeners();
        loadClientLogo();
        loadData();
        return view;
    }

    @SuppressLint("DefaultLocale")
    private void setViewModelObserversAndListeners() {
        //dados da comanda
        comandaViewModel.getComanda().observe(getViewLifecycleOwner(), c -> {
            binding.numeroComanda.setText(String.format("%d", c.getIdComanda()));
            binding.numeroMesa.setText(String.format("%d", c.getNumeroMesa()));
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault());
            binding.horaAbertura.setText(sdf.format(c.getHoraAbertura()));
        });
        //dados da conta
        comandaViewModel.getConta().observe(getViewLifecycleOwner(), conta -> {
            binding.quantidadePedidos.setText(String.format("%d", conta.getQtdItens()));
            binding.taxaServico.setText(String.format("%d%%", conta.getTaxaServico()));
            //valores
            binding.valorPedidos.setText(StringUtil.formatCurrencyValue(conta.getValorPedidos()));
            binding.valorServico.setText(StringUtil.formatCurrencyValue(conta.getValorServico()));
            binding.valorCouvert.setText(StringUtil.formatCurrencyValue(conta.getValorCouvert()));
            binding.valorTotal.setText(StringUtil.formatCurrencyValue(conta.getValorTotal()));
        });
        //setting loadData as the method for the swipe down refresh layout
        binding.swipeRefreshComanda.setOnRefreshListener(this::loadData);
    }

    private void loadData() {
        RetrofitConfig.getComanditAPI().consultarContaComanda(
                comandaViewModel.getComanda().getValue()).enqueue(this);
    }

    private void loadClientLogo() {
        Glide.with(this)
                .load(getString(R.string.client_logo_url))
                .circleCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.imageviewClientLogo);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onResponse(Call<Conta> call, Response<Conta> response) {
        if(binding.swipeRefreshComanda.isRefreshing()) {
            binding.swipeRefreshComanda.setRefreshing(false);
        }
        if(response.isSuccessful()) {
            Conta conta = response.body();
            assert conta != null;
            comandaViewModel.setComanda(conta.getComanda());
            comandaViewModel.setConta(conta);
        } else {
            APIException exception = ExceptionUtils.parseException(response);
            Log.e(getString(R.string.api_exception), exception.getMessage());
            Toast.makeText(getContext(), exception.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Call<Conta> call, Throwable t) {
        if(binding.swipeRefreshComanda.isRefreshing()) {
            binding.swipeRefreshComanda.setRefreshing(false);
        }
        Toast.makeText(getContext(), R.string.requestError, Toast.LENGTH_SHORT).show();
    }

}