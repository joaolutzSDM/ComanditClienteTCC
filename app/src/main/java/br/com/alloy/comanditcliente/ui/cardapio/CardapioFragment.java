package br.com.alloy.comanditcliente.ui.cardapio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import java.util.List;

import br.com.alloy.comanditcliente.R;
import br.com.alloy.comanditcliente.databinding.FragmentCardapioBinding;
import br.com.alloy.comanditcliente.databinding.FragmentComandaBinding;
import br.com.alloy.comanditcliente.service.model.ProdutoCategoria;

public class CardapioFragment extends Fragment {

    private FragmentCardapioBinding binding;
    private CardapioViewModel cardapioViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCardapioBinding.inflate(inflater, container, false);
        cardapioViewModel = new ViewModelProvider(this).get(CardapioViewModel.class);
        setViewModelObserversAndListeners();
        binding.swipeRefreshCardapio.setRefreshing(true);
        carregarCardapio();
        return binding.getRoot();
    }

    private void setViewModelObserversAndListeners() {
        cardapioViewModel.getCategorias().observe(getViewLifecycleOwner(), categorias -> {

        });

        cardapioViewModel.getProdutos().observe(getViewLifecycleOwner(), produtos -> {
            //binding.

        });

        binding.expandableListviewCardapio.setOnGroupExpandListener(groupPosition -> {
            ProdutoCategoria categoria = (ProdutoCategoria) binding.expandableListviewCardapio.getExpandableListAdapter().getGroup(groupPosition);

        });

        binding.expandableListviewCardapio.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            return true;
        });

        binding.swipeRefreshCardapio.setOnRefreshListener(this::carregarCardapio);
    }

    private void carregarCardapio() {

    }

}