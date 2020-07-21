package br.com.alloy.comanditcliente.ui.comanda;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.Locale;

import br.com.alloy.comanditcliente.R;
import br.com.alloy.comanditcliente.databinding.FragmentComandaBinding;
import br.com.alloy.comanditcliente.repository.ComandaRepository;
import br.com.alloy.comanditcliente.service.model.Comanda;
import br.com.alloy.comanditcliente.service.model.Conta;

public class ComandaFragment extends Fragment {

    private FragmentComandaBinding binding;
    private ComandaViewModel comandaViewModel;
    private ComandaRepository comandaRepository;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentComandaBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        comandaViewModel = new ViewModelProvider(requireActivity()).get(ComandaViewModel.class);
        comandaRepository = new ComandaRepository(getContext(), comandaViewModel);
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
        comandaRepository.getContaComanda();
    }

    private void loadClientLogo() {
        Glide.with(this)
                .load("https://comandit.github.io/mock/comanditclientapi/images/client_logo.jpg")
                .circleCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.imageviewClientLogo);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}