package be.ac.ulb.infof307.g07.controllers;


import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import be.ac.ulb.infof307.g07.PokemonViewListener;
import be.ac.ulb.infof307.g07.models.Map;
import be.ac.ulb.infof307.g07.models.Pokedex;
import be.ac.ulb.infof307.g07.models.Pokemon;
import be.ac.ulb.infof307.g07.views.PokedexView;
import be.ac.ulb.infof307.g07.views.PokemonSelectionView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.ScrollPane;

public class PokemonSelectionController implements Initializable, PokemonViewListener{
	
	private static PokemonSelectionController instance = null;
	
	@FXML
	private ScrollPane selectPokemonContainer;
	@FXML
	private DatePicker datePicker;
	@FXML
	private TextField timePicker;
	@FXML
	private Button btnModify;
	@FXML
	private Button btnAdd;
	
	private Pokemon selectedPokemon;
	
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
		Map.getInstance().addPokeMarker(selectedPokemon, date, timePicker.getText());
		close(null);
		PokedexController.getInstance().toggleMode(null, null);
		
	}
	@FXML
	public void onClickBtnModify(){
		
		String date = datePicker.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		Map.getInstance().modifyPokeMarker( date, timePicker.getText());
		close(null);
		
	}
	
	public void initSelection(){
		PokemonSelectionView.getInstance().setVisible(true);
		PokemonSelectionView.getInstance().loadPokemonContainer();
		PokedexController.getInstance().toggleMode(null, selectPokemonContainer);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		PokemonSelectionView.getInstance().setTimeStampFields( datePicker, timePicker );
		PokemonSelectionView.getInstance().setPokemonContainer(selectPokemonContainer);
	}

	@Override
	public void onSelect(Pokemon pokemon) {
		selectedPokemon = pokemon;
		PokedexView.getInstance().displayPokemonInDetail(pokemon.getId());
	}
	
	public void switchToModifyMode(boolean isModify){
		btnModify.setVisible(isModify);
		btnAdd.setVisible(!isModify);
	}
	
	
}
