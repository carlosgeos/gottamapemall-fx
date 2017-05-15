package be.ac.ulb.infof307.g07.controllers;

import be.ac.ulb.infof307.g07.models.Map;
import be.ac.ulb.infof307.g07.views.PokemonSelectionView;
import javafx.fxml.FXML;

public class PokeMarkerOptionsController {

	@FXML
	private void btnDelete(){
		Map.getInstance().removePokeMarker(Map.getInstance().getSelectedPokeMarker());
		PokemonSelectionView.getInstance().closeView();
	}
	
	@FXML
	private void btnEdit(){
		PokemonSelectionController.getInstance().switchToModifyMode(true);
		PokemonSelectionView.getInstance().setVisible(true);
		PokemonSelectionView.getInstance().fillModifyDataInView();
	}
}
