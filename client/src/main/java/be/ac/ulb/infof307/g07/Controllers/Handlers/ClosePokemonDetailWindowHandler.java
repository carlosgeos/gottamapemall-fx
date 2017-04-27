package be.ac.ulb.infof307.g07.Controllers.Handlers;

import be.ac.ulb.infof307.g07.Views.PokedexView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ClosePokemonDetailWindowHandler implements EventHandler<ActionEvent>{
    private PokedexView pokedex;
    
    public ClosePokemonDetailWindowHandler(PokedexView pokedex) {
        this.pokedex = pokedex;
    }
    
    @Override
    public void handle(ActionEvent event) {
        // close the window
        this.pokedex.closePokemonDetail();
    }
}
