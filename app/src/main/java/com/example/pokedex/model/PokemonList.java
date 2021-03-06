package com.example.pokedex.model;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.pokedex.R;

import java.util.List;

public class PokemonList {

    private List<Pokemon> pokemon;

    public PokemonList(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }

    @Override
    public String toString() {
        return "PokemonList{" +
                "pokemon=" + pokemon +
                '}';
    }
}