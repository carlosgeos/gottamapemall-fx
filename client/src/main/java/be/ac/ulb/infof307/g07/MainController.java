package be.ac.ulb.infof307.g07;

import java.net.URL;
import java.util.ResourceBundle;

import be.ac.ulb.infof307.g07.controllers.PokedexController;
import be.ac.ulb.infof307.g07.views.PokedexView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class MainController implements Initializable{

	@FXML
	private AnchorPane menuContainer;
	
	@FXML
	public void btnPokedexMenu(){
		PokedexController.getInstance().toggleMainView();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		menuContainer.toFront();
	}
	
}
