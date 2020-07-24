package br.com.alloy.comanditcliente.ui.comanda;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.Locale;

import br.com.alloy.comanditcliente.R;
import br.com.alloy.comanditcliente.databinding.FragmentComandaBinding;
import br.com.alloy.comanditcliente.service.ExceptionUtils;
import br.com.alloy.comanditcliente.service.RetrofitConfig;
import br.com.alloy.comanditcliente.service.dto.APIException;
import br.com.alloy.comanditcliente.service.model.Comanda;
import br.com.alloy.comanditcliente.service.model.Conta;
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
        createViewModelObservers();
        loadData();
        return view;
    }

    private void createViewModelObservers() {
        //dados da comanda
        comandaViewModel.getComanda().observe(getViewLifecycleOwner(), new Observer<Comanda>() {
            @Override
            public void onChanged(Comanda c) {
                binding.textviewComanda.setText(String.format(Locale.getDefault(), "%d", c.getIdComanda()));
                binding.textviewMesa.setText(String.format(Locale.getDefault(), "%d", c.getNumeroMesa()));
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault());
                binding.textviewAbertura.setText(sdf.format(c.getHoraAbertura()));
            }
        });
        //dados da conta
        comandaViewModel.getConta().observe(getViewLifecycleOwner(), new Observer<Conta>() {
            @Override
            public void onChanged(Conta conta) {

            }
        });
    }

    private void loadData() {
        loadClientLogo();
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
        if(response.isSuccessful()) {
            comandaViewModel.setConta(response.body());
        } else {
            APIException exception = ExceptionUtils.parseException(response);
            Log.e(getString(R.string.api_exception), exception.getMessage());
            Toast.makeText(getContext(), exception.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Call<Conta> call, Throwable t) {
        Toast.makeText(getContext(), R.string.requestError, Toast.LENGTH_SHORT).show();
    }

}