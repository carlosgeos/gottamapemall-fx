package be.ac.ulb.infof307.g07.Controllers.Handlers;

import be.ac.ulb.infof307.g07.Controllers.PokemonViewListener;
import be.ac.ulb.infof307.g07.Models.Pokemon;
import be.ac.ulb.infof307.g07.Views.PokedexView;

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
