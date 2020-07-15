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

import br.com.alloy.comanditcliente.service.ExceptionUtils;
import br.com.alloy.comanditcliente.service.RetrofitConfig;
import br.com.alloy.comanditcliente.service.dto.APIException;
import br.com.alloy.comanditcliente.service.model.Comanda;
import br.com.alloy.comanditcliente.service.model.Pedido;
import br.com.alloy.comanditcliente.service.model.ProdutoCategoria;
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
                R.id.navigation_comanda, R.id.navigation_pedidos, R.id.navigation_cardapio)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        //comandaLogin();
        carregarPedidos();
    }

    private void carregarPedidos() {
        Comanda comanda = new Comanda();
        comanda.setIdComanda(1);
        comanda.setSenhaAcessoMobile("212121");
        retrofitConfig.getComanditAPI().consultarPedidosComanda(comanda).enqueue(new Callback<List<Pedido>>() {
            @Override
            public void onResponse(Call<List<Pedido>> call, Response<List<Pedido>> response) {
                if(response.isSuccessful()) {
                    System.out.println(response.body());
                    List<Pedido> lista = response.body();
                    for(Pedido p : lista) {
                        System.out.println(p);
                    }
                } else {
                    if(response.code() == 500) {
                        APIException ex = ExceptionUtils.parseException(response);
                        Toast.makeText(MainActivity.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Ocorreu um erro ao realizar a consulta", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Pedido>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Erro na request", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void comandaLogin() {
        retrofitConfig.getComanditAPI().consultarCategorias().enqueue(new Callback<List<ProdutoCategoria>>() {
            @Override
            public void onResponse(Call<List<ProdutoCategoria>> call, Response<List<ProdutoCategoria>> response) {
                if(response.isSuccessful()) {
                    List<ProdutoCategoria> lista = response.body();
                    for(ProdutoCategoria pc : lista) {
                        System.out.println(pc);
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Erro no response", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ProdutoCategoria>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Erro na request", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
