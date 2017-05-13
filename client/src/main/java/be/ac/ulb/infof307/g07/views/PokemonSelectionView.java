package be.ac.ulb.infof307.g07.views;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import be.ac.ulb.infof307.g07.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class PokemonSelectionView {
	
	private static PokemonSelectionView instance = null;
	private Pane mainPane;
	private AnchorPane selectPokemonContainer;
	private DatePicker date;
	private TextField time;
	
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
	
	public void setVisible(boolean visible){
		mainPane.setVisible(visible);
		if( visible ){
			fillTimestamp();
			PokedexView.getInstance().toggleMode(null, selectPokemonContainer);	
		}else{
			PokedexView.getInstance().toggleMode(null, null);
		}
	}
}
