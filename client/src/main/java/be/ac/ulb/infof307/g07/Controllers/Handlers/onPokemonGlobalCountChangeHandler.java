package be.ac.ulb.infof307.g07.Controllers.Handlers;

import be.ac.ulb.infof307.g07.Controllers.PokemonListener;
import be.ac.ulb.infof307.g07.Views.PokemonView;

public class onPokemonGlobalCountChangeHandler implements PokemonListener{

	private PokemonView pokemonView;
	
	public onPokemonGlobalCountChangeHandler(PokemonView pokemonView){
		
		this.pokemonView = pokemonView;
		
	}
	
	@Override
	public void onChangeGlobalCount() {
		
		pokemonView.refreshCount();
		
	}

}
