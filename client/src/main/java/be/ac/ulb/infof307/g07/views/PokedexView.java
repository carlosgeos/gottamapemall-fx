package be.ac.ulb.infof307.g07.views;

import java.io.IOException;
import java.util.HashMap;

import be.ac.ulb.infof307.g07.Main;
import be.ac.ulb.infof307.g07.PokemonViewListener;
import be.ac.ulb.infof307.g07.controllers.PokedexController;
import be.ac.ulb.infof307.g07.models.Pokedex;
import be.ac.ulb.infof307.g07.models.Pokemon;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class PokedexView {

	private final Pokedex pokedex;
	private HashMap<Integer,PokemonView> pokemonViews = new HashMap<Integer, PokemonView>();
	private static PokedexView instance = null;
	private boolean isMainHided;
	private boolean isPokedexMode = true;
	private double diffHeight = 0;
	private PokedexController controller;
	
	private Pane mainPane;
	private AnchorPane pokemonDetailContainer;
	private ScrollPane pokemonViewContainer;
	private TextField searchField;
	
	private Label[] pokemonDetailLabels;
	private AnchorPane pokemonDetailImageView;
	
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
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("views/Pokedex.fxml"));
			controller = PokedexController.getInstance();
			loader.setController(controller);
			mainPane = loader.load();
		} catch (IOException except) {
			
			except.printStackTrace();
		}
	}
	
	public void setSearchField(TextField newSearchField){
		
		searchField = newSearchField;
	}
	
	public void toggleMode( ScrollPane toPokedex ){
		
		if( toPokedex==null ){
			// pokedex mode
			showPokedex(true);
			isPokedexMode = true;
		}else{
			// selection mode
			hideAll(true);
			isPokedexMode = false;
		}
	}
	
	private void showPokemonView(){
		this.pokemonViews = createPokemoViews(Pokedex.getInstance().getPokemonsId(),true, controller);
		VBox newVBox = new VBox();
		System.out.println(this.pokemonViews.size());
		for( Integer id : this.pokemonViews.keySet() ){
		
			newVBox.getChildren().add(pokemonViews.get(id).getView());
		}
		pokemonViewContainer.setContent(newVBox);
	}
	
	public HashMap<Integer, PokemonView> createPokemoViews( Integer[] listId, boolean bindSignalListener, PokemonViewListener pokemonSelectionListener){
		
		HashMap<Integer, Pokemon> pokemons = pokedex.getPokemons();
		HashMap<Integer, PokemonView> list = new HashMap<Integer, PokemonView>();
		
		for( int id: listId ){
			PokemonView newPokemonView = new PokemonView(pokemons.get(id));
			if(bindSignalListener){
				pokemons.get(id).addListener(newPokemonView);
			}
			if( pokemonSelectionListener != null ){
				newPokemonView.addListener(pokemonSelectionListener);
			}
			newPokemonView.loadView();
			newPokemonView.setPokemonDataInView();
			list.put(id, newPokemonView);
		}
		
		return list;
	}
	
	public void setContainers( ScrollPane pVContainer, AnchorPane pDContainer ){
		
		pokemonViewContainer = pVContainer;
		pokemonDetailContainer = pDContainer;
	}
	public void init(){
		showPokemonView();
	}
	
	public static void setPaneVisibility( Pane container, boolean isVisible ){
		container.setVisible(isVisible);
		if( isVisible ){
			container.toFront();
		}else{
			container.toBack();
		}
	}
	
	public static void setPaneVisibility( ScrollPane container, boolean isVisible ){
		container.setVisible(isVisible);
		if( isVisible ){
			container.toFront();
		}else{
			container.toBack();
		}
	}
	
	public void hideAll(boolean hide){
		showDetailView(!hide);
		showPokedex(!hide);
	}
	
	public void showPokedex(boolean show){
		if( isPokedexMode ){
			PokedexView.setPaneVisibility(pokemonViewContainer, show);
			hideMain();
		}
	}
	
	public void showDetailView(boolean show){
		PokedexView.setPaneVisibility(pokemonDetailContainer, show);
		hideMain();
	}
	
	private void hideMain(){
		isMainHided = (!pokemonViewContainer.isVisible() && !pokemonDetailContainer.isVisible());
		mainPane.setVisible(!isMainHided);
	}
	
	public void displayPokemonInDetail(int pokemonId){
		Pokemon pokemon = pokedex.getPokemon(pokemonId);
		// set Image
		Image pokemonImage = new Image("gif_numeric/"+String.format("%03d", pokemon.getId())+ ".gif", pokemonDetailImageView.getWidth(), pokemonDetailImageView.getHeight(), true, true);
		pokemonDetailImageView.getChildren().clear();
		pokemonDetailImageView.getChildren().add(new ImageView(pokemonImage));
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
		showDetailView(true);
	}
	
	public static String arrayToString( String[] string, String separator ){
		
		String output = "";
		for( String elem : string ){
			
			output += elem + separator;
		}
		
		output = output.substring(0, output.length()-1);
		return output;
	}
	
	public void setDetailComponent(Label[] pokemonLabels, AnchorPane pokemonImage){
		pokemonDetailLabels = pokemonLabels;
		pokemonDetailImageView = pokemonImage;
	}
	
	public boolean getIsMainHided(){
		
		return isMainHided;
	}
	
	public Pane getView(){
		return mainPane;
	}
	
	public void setHeight( double newHeight ){
		double mainHeight = mainPane.getPrefHeight();
		mainPane.setPrefHeight(newHeight);
		if( diffHeight == 0 ){
			diffHeight = mainHeight - pokemonViewContainer.getPrefHeight()+35;
		}
		pokemonViewContainer.setPrefHeight(newHeight-diffHeight);
		pokemonDetailContainer.setPrefHeight(newHeight);
		
	}
}
