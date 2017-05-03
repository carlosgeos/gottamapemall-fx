package be.ac.ulb.infof307.g07.controllers.Handlers;

import be.ac.ulb.infof307.g07.controllers.PokemonListener;
import be.ac.ulb.infof307.g07.views.PokemonView;

/**
 * Cette classe s'occupe de rafraîchir les compteurs des signalisations des pokemons (=nombre de fois que le pokemon a été repéré)
 * 
 * @version 1.0
 * 
 * @see be.ac.ulb.infof307.g07.views.PokemonView
 * @see be.ac.ulb.infof307.g07.views.PokemonView#refreshCount()
 */
public class onPokemonGlobalCountChangeHandler implements PokemonListener{
	
	/**
	 * la vue sur un pokemon, càd l'affichage des pokemons dans le pokedex
	 */
    private PokemonView pokemonView;
    
    /**
     * Constructeur de onPokemonGlobalCountChangeHandler
     * 
     * @param pokemonView
     */
    public onPokemonGlobalCountChangeHandler(PokemonView pokemonView){
        this.pokemonView = pokemonView;
    }
    
    /**
     * Cette méthode fait appel à refreshCount() de PokemonView pour actualiser les compteurs des repérages des pokemons
     * 
     * @see be.ac.ulb.infof307.g07.views.PokemonView
     * @see be.ac.ulb.infof307.g07.views.PokemonView#refreshCount()
     */
    @Override
    public void onChangeGlobalCount() {
        pokemonView.refreshCount();
    }

} 
