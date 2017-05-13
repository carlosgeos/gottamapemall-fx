package be.ac.ulb.infof307.g07.controllers;


import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import be.ac.ulb.infof307.g07.models.Map;
import be.ac.ulb.infof307.g07.models.Pokedex;
import be.ac.ulb.infof307.g07.views.PokedexView;
import be.ac.ulb.infof307.g07.views.PokemonSelectionView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class PokemonSelectionController implements Initializable{
	
	private static PokemonSelectionController instance = null;
	
	@FXML
	private AnchorPane selectPokemonContainer;
	@FXML
	private DatePicker datePicker;
	@FXML
	private TextField timePicker;
	
	public PokemonSelectionController(){
		instance = this;
	}
	
	public static PokemonSelectionController getInstance(){
		if( instance == null ){
			instance = new PokemonSelectionController();
		}
		return instance;
	}
	
	@FXML
    public void close(ActionEvent event)
    {
		PokemonSelectionView.getInstance().closeView();
		PokedexController.getInstance().toggleMode(null, null);
    }
	
	@FXML
	public void onClickBtnAdd(){
		
		String date = datePicker.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		Map.getInstance().addPokeMarker(Pokedex.getInstance().getSelectedPokemon(), date, timePicker.getText());
		close(null);
		PokedexController.getInstance().toggleMode(null, null);
		
	}
	
	public void initSelection(){
		PokemonSelectionView.getInstance().setVisible(true);
		PokedexController.getInstance().toggleMode(null, selectPokemonContainer);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		PokemonSelectionView.getInstance().setTimeStampFields( datePicker, timePicker );
		PokemonSelectionView.getInstance().setPokemonContainer(selectPokemonContainer);
	}
}
