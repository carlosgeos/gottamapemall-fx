package be.ac.ulb.infof307.g07.controllers.Handlers;

import be.ac.ulb.infof307.g07.controllers.PokemonViewListener;
import be.ac.ulb.infof307.g07.models.Pokemon;
import be.ac.ulb.infof307.g07.views.PokedexView;

public class PokemonViewDblClickHandler implements PokemonViewListener {
    private  PokedexView pokedexView;
    
    public PokemonViewDblClickHandler(PokedexView pokedexView) {
        this.pokedexView = pokedexView;
    }
    
    @Override
    public void onDoubleClick(Pokemon pokemon) {
        pokedexView.showPokemonDetail(pokemon);
    }
}
