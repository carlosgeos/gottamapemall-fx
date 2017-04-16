package be.ac.ulb.infof307.g07.Controllers.Handlers;

import be.ac.ulb.infof307.g07.Models.Pokemon;
import be.ac.ulb.infof307.g07.Views.PokedexView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class PokedexDblClickPokemonInfoHandler implements EventHandler<MouseEvent>{

	private Pokemon pokemon;
	private PokedexView pokedexView;
	
	public PokedexDblClickPokemonInfoHandler(PokedexView pokedexView, Pokemon pokemon){
		this.pokemon = pokemon;
		this.pokedexView = pokedexView;
	}
	
	@Override
	public void handle(MouseEvent event) {
		
		 if (event.getClickCount() == 2) {
	        	System.out.println("Hello");
	        	this.pokedexView.showPokemonDetail(this.pokemon);
	        }
		
		
		
	}

	
	
}
