package be.ac.ulb.infof307.g07.controllers;


import java.net.URL;
import java.util.ResourceBundle;

import be.ac.ulb.infof307.g07.views.PokedexView;
import be.ac.ulb.infof307.g07.views.PokemonSelectionView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class PokemonSelectionController implements Initializable{
	
	@FXML
	private AnchorPane selectPokemonContainer;
	
	@FXML
    public void close(ActionEvent event)
    {
        PokemonSelectionView pSView = PokemonSelectionView.getInstance();
        pSView.setVisible(false);
        PokedexView.getInstance().displayPokemon(null, null);
    }
	
	@FXML
	public void onClickBtnAdd(){
		
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		PokemonSelectionView.getInstance().setPokemonContainer(selectPokemonContainer);
		//PokemonSelectionView.getInstance().setLabel(time);
		
	}
}
