package be.ac.ulb.infof307.g07.Views;

import be.ac.ulb.infof307.g07.MyClass;
import be.ac.ulb.infof307.g07.Controllers.Handlers.SearchFieldOnKeyReleasedHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

/**
 * 
 * @author Fan && Renato
 * 
 */

public class PokedexView {

	//MyClass will be changed in Pokemon class or similar
	private ObservableList<MyClass> pokemonInPokedex;
	private ObservableList<MyClass> matchingPokemon;
	
	private ListView<MyClass> pokemonListView;
	private Pane pokedexBorderPane;
	private TextField searchFieldPokemon;

	private Pane stackpane;
	
	public PokedexView(Pane newstackpane){
		stackpane = newstackpane;
		
		pokedexBorderPane = new Pane();
		
		pokemonInPokedex = FXCollections.observableArrayList();
		fillPokedex();
		matchingPokemon = pokemonInPokedex;
		
		pokemonListView = new ListView<MyClass>();
		updatePokedex();
		//pokedexBorderPane.setCenter(pokemonListView);
		
		createSearchField();
		
		
	}
	
	public void updatePokedex(){
		
		System.out.println("avant: "+pokemonInPokedex.size());
		//pokemonListView.getItems().clear();

		//pokemonListView.getItems().clear();
		System.out.println("apresm: "+matchingPokemon.size());
		pokemonListView.setItems(matchingPokemon);
		
		
		pokemonListView.setCellFactory(
					new Callback<ListView<MyClass>, ListCell<MyClass>>() {  
					@Override
					public ListCell<MyClass> call(ListView<MyClass> pokelv) {
						return new PokemonCellView(stackpane);
					}
					});

	
	}
	
	public ObservableList<MyClass> getPokemonList(){
		
		return pokemonInPokedex;
		
	}
	
	
	
	public Pane getView(){
		return pokedexBorderPane;
	}
	
	private void fillPokedex(){
		pokemonInPokedex.add(new MyClass(45, "fanachu", "https://pldh.net/media/pokemon/gen6/xy_shiny/175.png"));
		pokemonInPokedex.add(new MyClass(54, "yoyoyo", "https://pldh.net/media/pokemon/gen6/xy_shiny/175.png"));
		pokemonInPokedex.add(new MyClass(67, "woot", "https://pldh.net/media/pokemon/gen6/xy_shiny/175.png"));
		pokemonInPokedex.add(new MyClass(87, "pikachu", "https://pldh.net/media/pokemon/gen6/xy_shiny/175.png"));
		pokemonInPokedex.add(new MyClass(67, "woot", "https://pldh.net/media/pokemon/gen6/xy_shiny/175.png"));
		pokemonInPokedex.add(new MyClass(67, "woot", "https://pldh.net/media/pokemon/gen6/xy_shiny/175.png"));
		pokemonInPokedex.add(new MyClass(67, "woot", "https://pldh.net/media/pokemon/gen6/xy_shiny/175.png"));
		pokemonInPokedex.add(new MyClass(67, "woot", "https://pldh.net/media/pokemon/gen6/xy_shiny/175.png"));
		
		
	}
	
	private void createSearchField(){
		
		searchFieldPokemon = new TextField();
		searchFieldPokemon.setOnKeyReleased(new SearchFieldOnKeyReleasedHandler(this, searchFieldPokemon));
		Pane searchFieldHBox = new Pane();
		searchFieldHBox.setStyle("-fx-background-color:#FF0000;");
		searchFieldHBox.getChildren().addAll(new Label("Search : "), searchFieldPokemon);
		//pokedexBorderPane.setTop(searchFieldHBox);
		
	}
	
	public void setNewPokemonList(ObservableList<MyClass> newPokemonList){
		matchingPokemon = newPokemonList;
		
	}
	
	
}
