package br.com.alloy.comanditcliente.ui.comanda;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;

import br.com.alloy.comanditcliente.MainActivity;
import br.com.alloy.comanditcliente.R;
import br.com.alloy.comanditcliente.databinding.FragmentComandaBinding;
import br.com.alloy.comanditcliente.service.ExceptionUtils;
import br.com.alloy.comanditcliente.service.dto.APIException;
import br.com.alloy.comanditcliente.service.model.Comanda;
import br.com.alloy.comanditcliente.service.model.Conta;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ComandaFragment extends Fragment {

    private FragmentComandaBinding binding;
    private ComandaViewModel comandaViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentComandaBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        comandaViewModel = new ViewModelProvider(this).get(ComandaViewModel.class);
        createViewModelObservers();
        loadData();
        return view;
    }

    private void createViewModelObservers() {
        //dados da comanda
        comandaViewModel.getComanda().observe(getViewLifecycleOwner(), new Observer<Comanda>() {
            @Override
            public void onChanged(@Nullable Comanda c) {
                binding.textviewComanda.setText(c.getIdComanda().toString());
                binding.textviewMesa.setText(c.getNumeroMesa().toString());
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                binding.textviewAbertura.setText(sdf.format(c.getHoraAbertura()));
            }
        });
        //dados da conta
        comandaViewModel.getConta().observe(getViewLifecycleOwner(), new Observer<Conta>() {
            @Override
            public void onChanged(Conta conta) {
                //comandaBinding.
            }
        });
    }

    private void loadData() {
        loadClientLogo();
        loadAccount();
    }

    private void loadClientLogo() {
        Glide.with(this)
                .load("https://comandit.github.io/mock/comanditclientapi/images/client_logo.jpg")
                .circleCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.imageviewClientLogo);
    }

    private void loadAccount() {
        MainActivity.getComanditAPI().consultarContaComanda().enqueue(new Callback<Conta>() {
            @Override
            public void onResponse(Call<Conta> call, Response<Conta> response) {
                if(response.isSuccessful()) {
                    comandaViewModel.setConta(response.body());
                } else {
                    APIException exception = ExceptionUtils.parseException(response);
                    Toast.makeText(getContext(), R.string.erroCarregarConta, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Conta> call, Throwable t) {
                Toast.makeText(getContext(), R.string.erroRequest, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}