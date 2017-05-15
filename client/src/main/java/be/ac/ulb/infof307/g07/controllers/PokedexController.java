package be.ac.ulb.infof307.g07.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import be.ac.ulb.infof307.g07.PokemonViewListener;
import be.ac.ulb.infof307.g07.models.Pokedex;
import be.ac.ulb.infof307.g07.models.Pokemon;
import be.ac.ulb.infof307.g07.views.PokedexView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class PokedexController implements Initializable, PokemonViewListener{

	@FXML
	private TextField searchField;
	@FXML
	private AnchorPane pokemonDetailContainer;
	@FXML
	private ScrollPane pokemonViewContainer;
	@FXML
	private Pane mainPokedexPane;
	@FXML
	private AnchorPane detailImageContainer;
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
	private Pokemon selectedPokemon;
	
	public static PokedexController getInstance(){
		
		if(instance == null ){
			
			instance = new PokedexController();
			
		}
		return instance;
	}
	
	public void toggleMainView(){
		closePokemonDetailView();
		PokedexView.getInstance().showPokedex(PokedexView.getInstance().getIsMainHided());
	}
	
	public void toggleMode(Integer[] list, ScrollPane container){
		PokedexView.getInstance().toggleMode(container);
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		PokedexView.getInstance().setSearchField(searchField);
		PokedexView.getInstance().setContainers(pokemonViewContainer, pokemonDetailContainer);
		Label[] tmpLabel = {detailId, detailName, detailTypes, detailWeight, detailHeight};
		PokedexView.getInstance().setDetailComponent( tmpLabel, detailImageContainer);
	}
	
	@FXML
	private void searchPokedex(){
		
	}
	
	public void onLeftClickPokemonView(int pokemonId){
		PokedexView.getInstance().displayPokemonInDetail(pokemonId);
	}
	
	@FXML
	public void closePokemonDetailView(){
		PokedexView.getInstance().showDetailView(false);
	}

	@Override
	public void onSelect(Pokemon pokemon) {
		selectedPokemon = pokemon;
		PokedexView.getInstance().displayPokemonInDetail(pokemon.getId());
	}
}
