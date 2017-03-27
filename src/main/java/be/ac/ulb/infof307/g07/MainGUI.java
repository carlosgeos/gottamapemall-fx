package be.ac.ulb.infof307.g07; /**
 * Created by carlos on 3/11/17.
 */

import javafx.application.Application;


import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;



public class MainGUI extends Application{

	@Override
    public void start(Stage primaryStage) {
        
		MapGUI pokeMap = new MapGUI();
		
		primaryStage.setWidth(800);
		primaryStage.setHeight(600);
		primaryStage.setTitle("PokéMap");
		
		
		GridPane mainGrid = new GridPane();
		mainGrid.add( pokeMap.getMapGUI(800, 600),0, 0);
		
		Scene mainScene = new Scene(mainGrid);
		primaryStage.setScene(mainScene);
		primaryStage.show();
    }
	
	
	public static void main(String[] args) {
        launch(args);
    }

}