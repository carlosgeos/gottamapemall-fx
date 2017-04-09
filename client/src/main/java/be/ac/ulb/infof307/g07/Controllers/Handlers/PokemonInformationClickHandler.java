package be.ac.ulb.infof307.g07.Controllers.Handlers;

import be.ac.ulb.infof307.g07.MyClass;
import be.ac.ulb.infof307.g07.Views.PokemonCellView;
import be.ac.ulb.infof307.g07.Views.SideView;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.ListCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class PokemonInformationClickHandler implements EventHandler<MouseEvent>{
	private MyClass selectedPokemon;
	private Pane pane;
	
	public PokemonInformationClickHandler(MyClass item, Pane mainpane){
		selectedPokemon = item;
		pane = mainpane;
		
	}
	
	@Override
	public void handle(MouseEvent arg0) {
		if (arg0.getClickCount() == 2){
			//ask database for info bla bla
			SideView sideView = new SideView(selectedPokemon, pane);
			Pane sideviewPane = sideView.getSideView();
			pane.getChildren().add(sideviewPane);
			//Pane.setAlignment(sideviewPane, Pos.TOP_RIGHT);
			sideviewPane.toBack();
			System.out.println("YOOOOO "+pane.getChildren().size());
			System.out.println("double cick on pokemon in pokedex"+selectedPokemon.id);
			
		}
		
	}
	

}
