package be.ac.ulb.infof307.g07.views;

import java.io.IOException;

import be.ac.ulb.infof307.g07.Main;
import be.ac.ulb.infof307.g07.controllers.PokemonController;
import be.ac.ulb.infof307.g07.models.Pokemon;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class PokemonView {
	
	private ImageView pokemonImage;
	private Label pokemonName;
	
	private GridPane mainPane;
	private Pokemon pokemon;
	
	public PokemonView( Pokemon newPokemon ){
		pokemon = newPokemon;	
	}
	
	public void loadView(){
		try {
			System.out.println("Loading PokemonView...");
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("fxml/Pokemon.fxml"));
			PokemonController newPokemonController = new PokemonController(this);
			loader.setController(newPokemonController);
			mainPane = loader.load();
			System.out.println("Finish loading PokemonView...");
		} catch (IOException except) {
			except.printStackTrace();
		}
	}
	
	public void setFieldName(Label newPokemonName){
		
		pokemonName = newPokemonName;
	}
	
	public void setFieldImage(ImageView newImage){
		
		pokemonImage = newImage;
	}
	
	public void setPokemonDataInView(){
		System.out.println("Setting pokemon data...");
		pokemonName.setText(pokemon.getName());
		pokemonImage.setImage(new Image("file:src/main/resources/"+Integer.toString(pokemon.getId())+".gif"));
		System.out.println("Finish setting pokemon data...");
	}
	
	public GridPane getView(){
		return mainPane;
	}
	
	public Pokemon getPokemon(){
		
		return pokemon;
		
	}
}
