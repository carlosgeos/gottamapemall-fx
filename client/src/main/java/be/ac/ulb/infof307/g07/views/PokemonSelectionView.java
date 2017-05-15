package be.ac.ulb.infof307.g07.views;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;

import be.ac.ulb.infof307.g07.controllers.PokemonSelectionController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class PokemonSelectionView {
	
	private static PokemonSelectionView instance = null;
	private Pane mainPane;
	private ScrollPane selectPokemonContainer;
	private DatePicker date;
	private TextField time;
	private PokemonSelectionController controller;
	private HashMap<Integer, PokemonView> pokemonViews;
	
	public PokemonSelectionView(){
		
		instance = this;
	}
	
	public void loadView(){
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("views/PokemonSelection.fxml"));
			controller=PokemonSelectionController.getInstance();
			loader.setController(controller);
			mainPane = loader.load();
			loadPokemonContainer();
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
	
	public void setPokemonContainer(ScrollPane newContainer){
		selectPokemonContainer = newContainer;
	}
	
	public void setTimeStampFields(DatePicker newDate, TextField newTime){
		date = newDate;
		time = newTime;
	}

	public Pane getView(){
		return mainPane;
	}
	
	private void fillTimestamp(){
		
		date.setValue(LocalDate.now());
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		Date date = new Date();
		time.setText(dateFormat.format(date));
		
	}
	
	public void closeView(){
		setVisible(false);
	}
	
	public void setVisible(boolean visible){
		mainPane.setVisible(visible);
		if( visible ){
			fillTimestamp();
		}
	}
	
	public void loadPokemonContainer(){
		VBox newVBox = new VBox();
		pokemonViews = PokedexView.getInstance().createPokemoViews(false, controller);
		for( Integer id : pokemonViews.keySet() ){
			pokemonViews.get(id).addListener(controller);
			newVBox.getChildren().add(pokemonViews.get(id).getView());
		}
		selectPokemonContainer.setContent(newVBox);
	}
}
