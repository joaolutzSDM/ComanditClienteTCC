package br.com.alloy.comanditcliente.ui.cardapio;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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
import br.com.alloy.comanditcliente.service.ExceptionUtils;
import br.com.alloy.comanditcliente.service.RetrofitConfig;
import br.com.alloy.comanditcliente.service.dto.APIException;
import br.com.alloy.comanditcliente.service.model.Produto;
import br.com.alloy.comanditcliente.service.model.ProdutoCategoria;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CardapioFragment extends Fragment implements CardapioResponseListener {

    private FragmentCardapioBinding binding;
    private CardapioViewModel cardapioViewModel;
    private CardapioRepository cardapioRepository;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCardapioBinding.inflate(inflater, container, false);
        cardapioViewModel = new ViewModelProvider(this).get(CardapioViewModel.class);
        cardapioRepository = new CardapioRepository(this);
        setViewModelObserversAndListeners();
        binding.swipeRefreshCardapio.setRefreshing(true);
        carregarCategorias();
        return binding.getRoot();
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
                Integer idCategoria = cardapioViewModel.getIdCategoria().getValue();
                if(!getCardapioAdapter().getProdutos().containsKey(idCategoria)) {
                    getCardapioAdapter().getProdutos().put(idCategoria, produtos);
                    getCardapioAdapter().notifyDataSetChanged();
                }
            }
        });

        binding.expandableListviewCardapio.setOnGroupExpandListener(groupPosition -> {
            binding.swipeRefreshCardapio.setRefreshing(true);
            ProdutoCategoria categoria = (ProdutoCategoria) getCardapioAdapter().getGroup(groupPosition);
            cardapioRepository.getProdutos(categoria);
        });

        binding.expandableListviewCardapio.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            return true;
        });

        binding.swipeRefreshCardapio.setOnRefreshListener(this::carregarCategorias);
    }

    private void carregarCategorias() {
        cardapioRepository.getCategorias();
    }

    @Override
    public void onCategoriasResponse(List<ProdutoCategoria> categorias) {
        cancelRefresh();
        cardapioViewModel.setCategorias(categorias);
    }

    private void cancelRefresh() {
        if (binding.swipeRefreshCardapio.isRefreshing()) {
            binding.swipeRefreshCardapio.setRefreshing(false);
        }
    }

    @Override
    public void onProdutosResponse(List<Produto> produtos, Integer idCategoria) {
        cancelRefresh();
        cardapioViewModel.setProdutos(produtos);
        cardapioViewModel.setIdCategoria(idCategoria);
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