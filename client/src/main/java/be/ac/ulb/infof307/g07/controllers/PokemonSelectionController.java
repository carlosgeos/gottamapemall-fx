package be.ac.ulb.infof307.g07.controllers;


import be.ac.ulb.infof307.g07.views.PokemonSelectionView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class PokemonSelectionController {
	
	@FXML
    public void close(ActionEvent event)
    {
        PokemonSelectionView pSView = PokemonSelectionView.getInstance();
        pSView.setVisible(false);
    }
}
