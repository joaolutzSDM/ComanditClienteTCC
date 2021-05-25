package br.com.alloy.comanditcliente;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import java.util.Objects;

import br.com.alloy.comanditcliente.databinding.ActivityMainBinding;
import br.com.alloy.comanditcliente.service.model.Comanda;
import br.com.alloy.comanditcliente.ui.comanda.ComandaViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //recupera a instância do comandaViewModel para setar a comanda retornada na tela de login
        ComandaViewModel comandaViewModel = new ViewModelProvider(this).get(ComandaViewModel.class);
        Comanda comanda = (Comanda) Objects.requireNonNull(getIntent().getExtras()).getSerializable("comanda");
        comandaViewModel.setComanda(comanda);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        NavController navController = Objects.requireNonNull(navHostFragment).getNavController();
        //Removido método que sincronizava o bottomNavigation com o ActionBar do aplicativo
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

}
