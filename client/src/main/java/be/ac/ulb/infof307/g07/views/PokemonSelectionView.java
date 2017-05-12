package be.ac.ulb.infof307.g07.views;

import java.io.IOException;

import be.ac.ulb.infof307.g07.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class PokemonSelectionView {
	
	private static PokemonSelectionView instance = null;
	private Pane mainPane;
	
	public PokemonSelectionView(){
		try {
			mainPane = FXMLLoader.load(Main.class.getResource("fxml/PokemonSelection.fxml"));
			mainPane.setVisible(false);
			instance = this;
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
	
	public Pane getView(){
		return mainPane;
	}
	
	public void setVisible(boolean visible){
		mainPane.setVisible(visible);
	}
}
