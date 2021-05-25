package br.com.alloy.comanditcliente.ui.cardapio;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

import br.com.alloy.comanditcliente.R;
import br.com.alloy.comanditcliente.databinding.FragmentCardapioBinding;
import br.com.alloy.comanditcliente.service.dto.APIException;
import br.com.alloy.comanditcliente.service.model.Produto;
import br.com.alloy.comanditcliente.service.model.ProdutoCategoria;

public class CardapioFragment extends Fragment implements CardapioResponseListener {

    private FragmentCardapioBinding binding;
    private CardapioViewModel cardapioViewModel;
    private CardapioRepository cardapioRepository;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCardapioBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cardapioViewModel = new ViewModelProvider(this).get(CardapioViewModel.class);
        cardapioRepository = new CardapioRepository(this);
        setViewModelObserversAndListeners();
        binding.swipeRefreshCardapio.setRefreshing(true);
        carregarCategorias();
    }

    private CardapioAdapter getCardapioAdapter() {
        return (CardapioAdapter) binding.expandableListviewCardapio.getExpandableListAdapter();
    }

    private void setViewModelObserversAndListeners() {
        cardapioViewModel.getCategorias().observe(getViewLifecycleOwner(), categorias -> {
            binding.expandableListviewCardapio.setAdapter(new CardapioAdapter(categorias));
        });

        cardapioViewModel.getProdutos().observe(getViewLifecycleOwner(), produtos -> {
            if(!produtos.isEmpty()) {
                getCardapioAdapter().updateProdutos(produtos.get(0).getIdProdutoCategoria(), produtos);
                binding.expandableListviewCardapio.expandGroup(getCardapioAdapter().getLastExpandedGroup(), true);
            } else {
                Toast.makeText(getContext(), R.string.no_products, Toast.LENGTH_SHORT).show();
            }
        });

        binding.expandableListviewCardapio.setOnGroupClickListener((parent, v, groupPosition, id) -> {
            if(!parent.isGroupExpanded(groupPosition)) {
                if (!getCardapioAdapter().getProdutos().containsKey((int) getCardapioAdapter().getGroupId(groupPosition))) {
                    binding.swipeRefreshCardapio.setRefreshing(true);
                    ProdutoCategoria categoria = getCardapioAdapter().getCategoria(groupPosition);
                    cardapioRepository.getProdutos(categoria);
                    getCardapioAdapter().setLastExpandedGroup(groupPosition);
                    return true;
                }
            }
            return false;
        });
        binding.swipeRefreshCardapio.setOnRefreshListener(this::carregarCategorias);
    }

    private void carregarCategorias() {
        cardapioRepository.getCategorias();
    }

    private void cancelRefresh() {
        if (binding.swipeRefreshCardapio.isRefreshing()) {
            binding.swipeRefreshCardapio.setRefreshing(false);
        }
    }

    @Override
    public void onCategoriasResponse(List<ProdutoCategoria> categorias) {
        cancelRefresh();
        cardapioViewModel.setCategorias(categorias);
    }

    @Override
    public void onProdutosResponse(List<Produto> produtos) {
        cancelRefresh();
        cardapioViewModel.setProdutos(produtos);
    }

    @Override
    public void onAPIException(APIException ex) {
        cancelRefresh();
        Log.e(getString(R.string.api_exception), ex.getMessage());
        Toast.makeText(getContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRequestFailure(Throwable t) {
        cancelRefresh();
        Toast.makeText(getContext(), R.string.requestError, Toast.LENGTH_SHORT).show();
    }

}