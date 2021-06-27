package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.example.pokedex.model.Pokemon;
import com.example.pokedex.model.PokemonList;
import com.example.pokedex.service.PokemonApiClient;
import com.example.pokedex.service.PokemonService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "ManActivity";
    private PokemonList pokemonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pokemonList = new PokemonList(new ArrayList<>());

        // obténm e prepara a recyclerView
        RecyclerView recyclerView = findViewById(R.id.poke_recyclerview);
        PokemonRecyclerAdapter recyclerAdapter = new PokemonRecyclerAdapter(getApplicationContext(),
                pokemonList.getPokemon());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerAdapter);

        PokemonService service = PokemonApiClient.getClient().create(PokemonService.class);
        Call<PokemonList> call = service.getPokemonList();
        call.enqueue(new Callback<PokemonList>() {
            @Override
            public void onResponse(Call<PokemonList> call, Response<PokemonList> response) {
                pokemonList = response.body();
                Log.d(TAG, "onResponse: "+pokemonList);
                // atualiza a lista de pokemons quando terminar o dowload
                recyclerAdapter.setPokemons(pokemonList.getPokemon());
            }

            @Override
            public void onFailure(Call<PokemonList> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.toString(), t);
            }
        });
    }
}