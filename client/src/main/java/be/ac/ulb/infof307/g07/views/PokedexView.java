package be.ac.ulb.infof307.g07.views;

import java.io.IOException;
import java.util.HashMap;

import be.ac.ulb.infof307.g07.Main;
import be.ac.ulb.infof307.g07.controllers.PokedexController;
import be.ac.ulb.infof307.g07.models.Pokedex;
import be.ac.ulb.infof307.g07.models.Pokemon;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class PokedexView {

	private final Pokedex pokedex;
	private HashMap<Integer,PokemonView> pokemonView = new HashMap<Integer, PokemonView>();
	private static PokedexView instance = null;
	
	private Pane mainPane;
	private AnchorPane pokemonViewContainer;
	private AnchorPane pokemonDetailContainer;
	private TextField searchField;
	
	public static PokedexView getInstance(){
		if( instance == null ){
			instance = new PokedexView();
		}
		return instance;
	}
	
	public PokedexView(){
		pokedex = new Pokedex();
	}
	
	public void loadView(){
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("fxml/Pokedex.fxml"));
			mainPane = loader.load();
		} catch (IOException except) {
			
			except.printStackTrace();
		}
	}
	
	public void setSearchField(TextField newSearchField){
		
		searchField = newSearchField;
	}
	
	public void displayPokemon(Integer[] pokemonId){
		System.out.println("Displaying pokemon....");
		for(Integer id: pokemonId){
			pokemonViewContainer.getChildren().add(pokemonView.get(id).getView());
		}
		System.out.println("Finish displaying pokemon....");
	}
	
	private void initPokemonViews(){
		System.out.println("Initialiazing PokemonViews...");
		HashMap<Integer, Pokemon> pokemons = pokedex.getPokemons();
		for( int id:pokemons.keySet() ){
			PokemonView newPokemonView = new PokemonView(pokemons.get(id));
			newPokemonView.loadView();
			newPokemonView.setPokemonDataInView();
			pokemonView.put(id, newPokemonView);
		}
		System.out.println("Finish initialiazing PokemonViews...");
	}
	
	public void setPokemonContainer(AnchorPane pVContainer){
		pokemonViewContainer = pVContainer;
	}
	
	public void setPokemonDetailContainer(AnchorPane pDContainer ){
		pokemonDetailContainer = pDContainer;
	}
	
	public void init(){
		
		initPokemonViews();
		displayPokemon(pokedex.getPokemonsId());
		
	}
	
	public void displayPokemonInDetail(int pokemonId){
		pokemonDetailContainer.setVisible(true);
		pokemonDetailContainer.toFront();
		pokemonViewContainer.toBack();
	}
	
	public Pane getView(){
		return mainPane;
	}
}
