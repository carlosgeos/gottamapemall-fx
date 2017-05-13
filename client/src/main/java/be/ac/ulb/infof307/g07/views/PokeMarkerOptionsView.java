package be.ac.ulb.infof307.g07.views;

import java.io.IOException;

import be.ac.ulb.infof307.g07.Main;
import be.ac.ulb.infof307.g07.models.PokeMarker;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class PokeMarkerOptionsView {

	private static PokeMarkerOptionsView instance = null;
	private Pane mainPane;
	private PokeMarker concernedPokeMarker = null;
	
	public static PokeMarkerOptionsView getInstance(){
		if( instance == null ){
			instance = new PokeMarkerOptionsView();
			instance.loadView();
		}
		return instance;
	}
	
	public Pane getView(){
		
		return mainPane;
	}
	
	public void loadView(){
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("fxml/PokeMarkerOptions.fxml"));
			mainPane = loader.load();
		} catch (IOException except) {
			
			except.printStackTrace();
		}
	}
	
	public void setPokeMarker(PokeMarker pokeMarker){
		concernedPokeMarker = pokeMarker;
	}
	
	public void showView(double layoutX, double layoutY){
		mainPane.setLayoutX(layoutX);
		mainPane.setLayoutY(layoutY);
		mainPane.setVisible(true);
	}
	
	
	public PokeMarker getConcernedPokeMarker(){
		return concernedPokeMarker;
	}
}
