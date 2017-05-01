package be.ac.ulb.infof307.g07.controllers.Handlers;

import be.ac.ulb.infof307.g07.controllers.PokemonListener;
import be.ac.ulb.infof307.g07.views.PokemonView;

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
