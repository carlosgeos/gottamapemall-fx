package be.ac.ulb.infof307.g07.views;

import java.io.IOException;
import java.util.HashMap;

import be.ac.ulb.infof307.g07.Main;
import be.ac.ulb.infof307.g07.models.Pokedex;
import be.ac.ulb.infof307.g07.models.Pokemon;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	
	private Label[] pokemonDetailLabels;
	private ImageView pokemonDetailImageView;
	
	private AnchorPane filledIn = null;
	
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
	
	public void toggleMode( Integer[] list, AnchorPane container ){
		
		if( container == null){
			// pokedex mode
			toggleToPokedexView();
			
		}else{
			// selection mode
			toggleToDetailView();
		}
		
		displayPokemon(list, container );
	}
	
	public void displayPokemon(Integer[] newPokemonIdList, AnchorPane newContainer){
		System.out.println("Displaying pokemon....");
		AnchorPane container;
		Integer[] pokemonIdList;
		
		if( newContainer != null ){
			System.out.println("setting new container..");
			container = newContainer;
		}else{
			System.out.println("setting default container..");
			container = pokemonViewContainer;
		}
		
		if(filledIn != null){
			System.out.println("Clearing pokedex...");
			filledIn.getChildren().clear();
			System.out.println("Finish clearing pokedex...");
		}
		
		if( newPokemonIdList == null ){
			pokemonIdList = Pokedex.getInstance().getPokemonsId();
		}else{
			pokemonIdList = newPokemonIdList;
		}
		for(Integer id: pokemonIdList){
			container.getChildren().add(pokemonView.get(id).getView());
		}
		filledIn = container;
		System.out.println("Finish displaying pokemon....");
	}
	
	public void initPokemonViews(){
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
		displayPokemon(pokedex.getPokemonsId(), null);
		
	}
	
	private void toggleVisibility(){
		boolean tmp = pokemonViewContainer.isVisible();
		pokemonViewContainer.setVisible(pokemonDetailContainer.isVisible());
		pokemonDetailContainer.setVisible(tmp);
	}
	
	public void toggleToPokedexView(){
		if(!pokemonViewContainer.isVisible()){
			toggleVisibility();
			pokemonDetailContainer.toBack();
			pokemonViewContainer.toFront();
		}
	}
	
	public void toggleToDetailView(){

		if(!pokemonDetailContainer.isVisible()){
			toggleVisibility();
			pokemonDetailContainer.toFront();
			pokemonViewContainer.toBack();
		}
	}
	
	
	public void hideAll(boolean visible){
		mainPane.setVisible(!visible);
	}
	
	public void displayPokemonInDetail(int pokemonId){
		
		Pokemon pokemon = pokedex.getPokemon(pokemonId);
		// set Image
		pokemonDetailImageView.setImage(new Image("file:src/main/resources/"+Integer.toString(pokemon.getId())+".gif"));
		// set Id
		pokemonDetailLabels[0].setText(Integer.toString(pokemon.getId()));
		// set Name
		pokemonDetailLabels[1].setText(pokemon.getName());
		// set Types
		pokemonDetailLabels[2].setText(arrayToString(pokemon.getType(),","));
		// set Weight
		pokemonDetailLabels[3].setText(Double.toString(pokemon.getWeight()));
		// set Height
		pokemonDetailLabels[4].setText(Double.toString(pokemon.getHeight()));
		toggleToDetailView();
	}
	
	public static String arrayToString( String[] string, String separator ){
		
		String output = "";
		for( String elem : string ){
			
			output += elem + separator;
		}
		
		output = output.substring(0, output.length()-1);
		return output;
	}
	
	public void setDetailComponent(Label[] pokemonLabels, ImageView pokemonImage){
		pokemonDetailLabels = pokemonLabels;
		pokemonDetailImageView = pokemonImage;
	}
	
	public Pane getView(){
		return mainPane;
	}
}
