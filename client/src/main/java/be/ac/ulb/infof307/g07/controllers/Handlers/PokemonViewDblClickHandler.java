package be.ac.ulb.infof307.g07.controllers.Handlers;

import be.ac.ulb.infof307.g07.controllers.PokemonViewListener;
import be.ac.ulb.infof307.g07.models.Pokemon;
import be.ac.ulb.infof307.g07.views.PokedexView;

/**
 * Cette classe s'occupe de gérer le double clic sur un pokemon dans le pokedex, pour afficher uniquement ce pokemon ainsi que des informations le concernant.
 * 
 * @version 1.0
 * 
 * @see be.ac.ulb.infof307.g07.views.PokedexView
 * @see be.ac.ulb.infof307.g07.views.PokedexView#showPokemonDetail(Pokemon)
 */
public class PokemonViewDblClickHandler implements PokemonViewListener {
	
	/**
	 * la vue sur le pokedex, pour l'affichage de celui-ci
	 * 
	 * @see be.ac.ulb.infof307.g07.views.PokedexView
	 */
    private  PokedexView pokedexView;
    
    /**
     * Constructeur de PokemonViewDblClickHandler
     * 
     * @param pokedexView la vue sur le pokedex
     * 
     * @see be.ac.ulb.infof307.g07.views.PokedexView
     */
    public PokemonViewDblClickHandler(PokedexView pokedexView) {
        this.pokedexView = pokedexView;
    }
    
    /**
     * Fait appel à la méthode showPokemonDetail de PokedexView, 
     * qui affiche en lieu et place du pokedex, le pokemon sélectionné et des informations complémentaires (image, nom, id, caractéristiques: type-s, taille, et poids). 
     * 
     * @param pokemon le pokemon sur lequel l'utilisateur a cliqué
     * 
     * @see be.ac.ulb.infof307.g07.views.PokedexView
     * @see be.ac.ulb.infof307.g07.views.PokedexView#showPokemonDetail(Pokemon)
     */
    @Override
    public void onDoubleClick(Pokemon pokemon) {
        pokedexView.showPokemonDetail(pokemon);
    }
}
