package be.ac.ulb.infof307.g07.views;

import java.io.IOException;

import be.ac.ulb.infof307.g07.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class PokemonSelectionView {
	
	private static PokemonSelectionView instance = null;
	private Pane mainPane;
	public AnchorPane selectPokemonContainer;
	private boolean isFilled = false;
	
	public PokemonSelectionView(){
		
		instance = this;
	}
	
	public void loadView(){
		try {
			
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("fxml/PokemonSelection.fxml"));
			mainPane = loader.load();
		} catch (IOException except) {
			except.printStackTrace();
		}
	}
	
	public static PokemonSelectionView getInstance(){
		
		if( instance == null ){
			instance = new PokemonSelectionView();	
		}
		return instance;
	}
	
	public void setPokemonContainer(AnchorPane newContainer){
		selectPokemonContainer = newContainer;
	}

	public Pane getView(){
		return mainPane;
	}
	
	public void fillPokemonList(){
		
		if( !isFilled ){
			PokedexView.getInstance().displayPokemon(null, selectPokemonContainer);
			isFilled = true;
		}
		
	}
	
	public void setVisible(boolean visible){
		mainPane.setVisible(visible);
	}
}
