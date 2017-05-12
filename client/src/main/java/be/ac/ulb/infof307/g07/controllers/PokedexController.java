package be.ac.ulb.infof307.g07.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import be.ac.ulb.infof307.g07.views.PokedexView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class PokedexController implements Initializable{

	@FXML
	private TextField searchField;
	@FXML
	private AnchorPane pokemonViewContainer;
	@FXML
	private AnchorPane pokemonDetailContainer;
	
	private static PokedexController instance;
	
	public PokedexController(){
		
		instance = this;
	}
	
	public static PokedexController getInstance(){
		
		if(instance == null ){
			
			instance = new PokedexController();
			
		}
		return instance;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		PokedexView.getInstance().setSearchField(searchField);
		PokedexView.getInstance().setPokemonContainer(pokemonViewContainer);
		PokedexView.getInstance().setPokemonDetailContainer(pokemonDetailContainer);
	}
	
	@FXML
	private void searchPokedex(){
		
		
	}
	
	public void onDblClickPokemonView(int pokemonId){
		PokedexView.getInstance().displayPokemonInDetail(pokemonId);
	}
}
