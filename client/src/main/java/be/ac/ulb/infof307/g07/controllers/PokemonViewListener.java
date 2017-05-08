package be.ac.ulb.infof307.g07.controllers;

import be.ac.ulb.infof307.g07.models.Pokemon;
import be.ac.ulb.infof307.g07.views.PokedexView;

/**
 * This is a listener for pokemonView
 *
 * @version 1.0
 *
 * @see be.ac.ulb.infof307.g07.views.PokemonView
 */
public interface PokemonViewListener {
   
    public void onDoubleClick(Pokemon pokemon);
}
