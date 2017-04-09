package be.ac.ulb.infof307.g07.Views;

import be.ac.ulb.infof307.g07.MyClass;
import be.ac.ulb.infof307.g07.Controllers.Handlers.PokemonInformationClickHandler;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 * 
 * @author Fan && Renato
 * 
 */

public class PokemonCellView extends ListCell<MyClass>{
		Pane pane;
		
		public PokemonCellView(Pane mainpane){
			pane = mainpane;
			
		}
	
		@Override
		public void updateItem(MyClass item, boolean empty){
			
			super.updateItem(item, empty);
			GridPane gr = new GridPane();
			
			String name = null;

			// Format name
			if (item == null || empty){
			}else{
				
				Image im = new Image(item.path);
				gr.add(new Label(Integer.toString(item.id)), 0, 0);
				gr.add(new ImageView(im), 1, 0);
				gr.add(new Label(item.name), 2, 0);
			}
			
			
			this.setText(null);
			setGraphic(gr);
			this.setOnMouseClicked(new PokemonInformationClickHandler(item, pane));
		}	

}
