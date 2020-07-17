package br.com.alloy.comanditcliente.ui.comanda;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import br.com.alloy.comanditcliente.MainActivity;
import br.com.alloy.comanditcliente.databinding.FragmentComandaBinding;
import br.com.alloy.comanditcliente.service.model.Comanda;

public class ComandaFragment extends Fragment {

    private FragmentComandaBinding comandaBinding;
    private ComandaViewModel comandaViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        comandaBinding = FragmentComandaBinding.inflate(inflater, container, false);
        View view = comandaBinding.getRoot();
        comandaViewModel = new ViewModelProvider(this).get(ComandaViewModel.class);
        comandaViewModel.getComanda().observe(getViewLifecycleOwner(), new Observer<Comanda>() {
            @Override
            public void onChanged(@Nullable Comanda c) {
                comandaBinding.textviewComanda.setText(c.toString());
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        comandaBinding = null;
    }

}