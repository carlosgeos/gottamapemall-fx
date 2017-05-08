package be.ac.ulb.infof307.g07.controllers;

import be.ac.ulb.infof307.g07.models.Pokemon;

/**
 * Interface pour la confirmation de sélection d'un pokemon lors de l'ajout d"une épingle sur la carte
 * Utilisé par addNewPokeMarkerHandler qui redéfinit la méthode onConfirm().
 * 
 * @version 1.0
 *
 * @see be.ac.ulb.infof307.g07.controllers.Handlers.addNewPokeMarkerHandler
 * @see be.ac.ulb.infof307.g07.controllers.Handlers.addNewPokeMarkerHandler#onConfirm(Pokemon, String, String)
 */
public interface ChoosePokemonViewListener {
    public void onConfirm(Pokemon pokemon, String date, String time);
}
