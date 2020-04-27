package br.com.alloy.comanditcliente;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.List;

import br.com.alloy.comanditcliente.api.RetrofitConfig;
import br.com.alloy.comanditcliente.api.callback.CategoriasResponseCallback;
import br.com.alloy.comanditcliente.api.dto.CategoriasResponse;
import br.com.alloy.comanditcliente.api.model.ProdutoCategoria;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RetrofitConfig retrofitConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        retrofitConfig = new RetrofitConfig();
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        comandaLogin();
    }

    private void comandaLogin() {
        retrofitConfig.getComanditAPI().consultarCategorias().enqueue(new Callback<CategoriasResponse>() {
            @Override
            public void onResponse(Call<CategoriasResponse> call, Response<CategoriasResponse> response) {
                if(response.isSuccessful()) {
                    List<ProdutoCategoria> lista = response.body().getData();
                    for(ProdutoCategoria pc : lista) {
                        System.out.println(pc);
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Erro no response", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CategoriasResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Erro na request", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
