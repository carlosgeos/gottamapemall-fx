package be.ac.ulb.infof307.g07.Controllers.Handlers;

import be.ac.ulb.infof307.g07.Views.PokedexView;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Fan et Renato
 *
 */

public class SearchFieldOnKeyReleasedHandler implements EventHandler<KeyEvent>{

	private TextField criteriaInput;
	private PokedexView pokedexView;

	public SearchFieldOnKeyReleasedHandler(PokedexView pkView,TextField txtField){

		criteriaInput = txtField;
		pokedexView = pkView;

	}

	@Override
	public void handle(KeyEvent arg0) {


	}


}
