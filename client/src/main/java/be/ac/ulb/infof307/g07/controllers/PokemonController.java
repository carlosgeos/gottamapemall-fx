package be.ac.ulb.infof307.g07.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import be.ac.ulb.infof307.g07.views.PokemonView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class PokemonController implements Initializable{

	@FXML
	private Pane pokemonImageContainer;
	@FXML
	private Label pokemonId;
	@FXML
	private Label pokemonName;
	@FXML
	private Label pokemonSignalisation;
	
	private PokemonView pokemonView;
	
	public PokemonController(PokemonView newPokemonView){
		pokemonView = newPokemonView;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		pokemonView.setFields(pokemonImageContainer, pokemonName, pokemonId, pokemonSignalisation);
	}
	
	@FXML	
	private void onLeftClick(MouseEvent event){
		if( event.getClickCount() == 1 ){
			pokemonView.onClickStyle(event);
			pokemonView.onSelected();
		}
	}
}
