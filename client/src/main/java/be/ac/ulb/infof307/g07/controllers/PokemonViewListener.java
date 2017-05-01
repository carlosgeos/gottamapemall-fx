package be.ac.ulb.infof307.g07.controllers;

import be.ac.ulb.infof307.g07.models.Pokemon;
import be.ac.ulb.infof307.g07.views.PokedexView;

public interface PokemonViewListener {
    // This is a listener for pokemonView
    public void onDoubleClick(Pokemon pokemon);
}
