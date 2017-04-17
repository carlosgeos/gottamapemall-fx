package be.ac.ulb.infof307.g07.Controllers.Handlers;

import be.ac.ulb.infof307.g07.PokemonViewListener;
import be.ac.ulb.infof307.g07.Models.Pokemon;
import be.ac.ulb.infof307.g07.Views.PokedexView;

public class PokemonViewDblClickHandler implements PokemonViewListener{

	@Override
	public void handle(Pokemon pokemon, PokedexView pokedexView) {
		
		pokedexView.showPokemonDetail(pokemon);
		
	}

	
	
}
