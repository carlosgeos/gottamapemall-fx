package be.ac.ulb.infof307.g07.controllers;


import java.net.URL;
import java.util.ResourceBundle;

import be.ac.ulb.infof307.g07.views.PokemonView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class PokemonController implements Initializable{

	@FXML
	private ImageView pokemonImage;
	@FXML
	private Label pokemonName;
	
	private PokemonView pokemonView;
	
	public PokemonController(PokemonView newPokemonView){
		System.out.println("Creating PokemonController...");
		pokemonView = newPokemonView;
		System.out.println("Finish creating PokemonController...");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("Assigning PokemonController...");
		pokemonView.setFieldImage(pokemonImage);
		pokemonView.setFieldName(pokemonName);
		System.out.println("Finish Assigning PokemonController...");
	}
	
	@FXML	
	private void onLeftClick(MouseEvent event){
		
		if( event.getClickCount() == 1 ){
			PokedexController.getInstance().onLeftClickPokemonView(pokemonView.getPokemon().getId());
		}else if( event.getClickCount() == 2 ){
			 
		}
	}
}
