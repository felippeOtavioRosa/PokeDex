package com.example.pokedex.service;

import com.example.pokedex.model.PokemonList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokemonService {
    @GET("pokedex.json")
    Call<PokemonList> getPokemonList();
}
