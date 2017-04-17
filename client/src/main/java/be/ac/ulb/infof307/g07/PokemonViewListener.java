package be.ac.ulb.infof307.g07;

import be.ac.ulb.infof307.g07.Models.Pokemon;
import be.ac.ulb.infof307.g07.Views.PokedexView;

public interface PokemonViewListener {
	
	// This is a listener for pokemonView
	public void handle(Pokemon pokemon, PokedexView pokedexView);
	
}
