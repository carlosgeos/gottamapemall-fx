package be.ac.ulb.infof307.g07.controllers.Handlers;

import be.ac.ulb.infof307.g07.views.PokedexView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * 
 * Cette classe s occupe de la fermeture de la fenetre de detail d un pokemon dans le pokedex.
 * 
 * @version 1.0
 */
public class ClosePokemonDetailWindowHandler implements EventHandler<ActionEvent>{
	
    private PokedexView pokedex;
    
    /**
     * Constructeur
     * @param pokedex la vue du pokedex
     */
    public ClosePokemonDetailWindowHandler(PokedexView pokedex) {
        this.pokedex = pokedex;
    }
    
    /**
     * Ferme la fenetre 
     */
    @Override
    public void handle(ActionEvent event) {
        // close the window
        this.pokedex.closePokemonDetail();
    }
}
