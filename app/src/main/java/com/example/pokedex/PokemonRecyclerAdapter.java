package com.example.pokedex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokedex.model.Pokemon;

import java.util.List;

public class PokemonRecyclerAdapter extends RecyclerView.Adapter<PokemonRecyclerAdapter.PokemonViewHolder> {
    Context context;
    List<Pokemon> pokemons;

    public PokemonRecyclerAdapter(Context context, List<Pokemon> pokemons) {
        this.context = context;
        this.pokemons = pokemons;
    }

        public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PokemonRecyclerAdapter.PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //"inflar" o layout dentro do código
        View view = LayoutInflater.from(context).inflate(R.layout.poke_recyclerview_layout, parent, false);
        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonRecyclerAdapter.PokemonViewHolder holder, int position) { // quando receber dados para mostrar na lista, p biding vai auttuar
        Pokemon pokemon = pokemons.get(position);
        holder.pokemonName.setText(pokemon.getName());
        holder.pokemonNum.setText(pokemon.getNum());
        holder.pokemonType.setText(pokemon.getType().toString());
    }

    @Override
    public int getItemCount() { // vai informar a maior quantidade de itens da lista
        if (pokemons != null) {
            return pokemons.size();
        }

        return 0;
    }

    public class PokemonViewHolder extends RecyclerView.ViewHolder {
        TextView pokemonName;
        TextView pokemonNum;
        TextView pokemonType;

        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);
            pokemonName = itemView.findViewById(R.id.poke_name);
            pokemonNum = itemView.findViewById(R.id.poke_num);
            pokemonType = itemView.findViewById(R.id.poke_type);
        }
    }
}
