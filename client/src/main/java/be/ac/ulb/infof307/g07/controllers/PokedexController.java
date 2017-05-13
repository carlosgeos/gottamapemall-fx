package be.ac.ulb.infof307.g07.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import be.ac.ulb.infof307.g07.models.Pokedex;
import be.ac.ulb.infof307.g07.views.PokedexView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class PokedexController implements Initializable{

	@FXML
	private TextField searchField;
	@FXML
	private AnchorPane pokemonViewContainer;
	@FXML
	private AnchorPane pokemonDetailContainer;
	@FXML
	private Pane mainPokedexPane;
	@FXML
	private ImageView detailImage;
	@FXML
	private Label detailId;
	@FXML
	private Label detailName;
	@FXML
	private Label detailTypes;
	@FXML
	private Label detailWeight;
	@FXML
	private Label detailHeight;
	
	
	
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
		Label[] tmpLabel = {detailId, detailName, detailTypes, detailWeight, detailHeight};
		PokedexView.getInstance().setDetailComponent( tmpLabel, detailImage);
	}
	
	@FXML
	private void searchPokedex(){
		
	}
	
	public void onLeftClickPokemonView(int pokemonId){
		PokedexView.getInstance().displayPokemonInDetail(pokemonId);
		Pokedex.getInstance().setSelectedPokemon(pokemonId);
	}
	
	@FXML
	public void closePokemonDetailView(){
		PokedexView.getInstance().toggleToPokedexView();
	}
}
