package be.ac.ulb.infof307.g07.Views;


import be.ac.ulb.infof307.g07.Controllers.Handlers.PokedexDblClickPokemonInfoHandler;
import be.ac.ulb.infof307.g07.Models.Pokemon;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 * 
 * @author Fan && Renato
 * 
 */

public class PokemonView extends ListCell<Pokemon>{
	
	// have to change this
	public static boolean isUpdated = false;
	
	private PokedexView pokedexView;
	private int defaultPokemonIcon = 45;
	
	public PokemonView(PokedexView pokedexView){
		
		this.pokedexView = pokedexView;
			
	}
	
	@Override
	public void updateItem(Pokemon pokemon, boolean empty) 
	{
		super.updateItem(pokemon, empty);
		GridPane gr = new GridPane();
		gr.setVgap(20);
		gr.setHgap(20);
		gr.setPadding(new Insets(5,5,5,5));
		// Format name
		if (pokemon == null || empty) 
		{
			
		} 
		else 
		{
			
			Image pokemonImage = new Image(pokemon.getImagePath(), this.defaultPokemonIcon, this.defaultPokemonIcon, true, true);
			ImageView pokemonImageView = new ImageView(pokemonImage);
						
			gr.add(pokemonImageView, 0, 0);
			gr.add(new Label(Integer.toString(pokemon.getId())), 1, 0);
			gr.add(new Label(pokemon.getName()), 2, 0);
			
		}
		
		this.setOnMouseClicked(new PokedexDblClickPokemonInfoHandler(this.pokedexView, pokemon));
		
		this.setText(null);
		setGraphic(gr);
		
	}	

}
