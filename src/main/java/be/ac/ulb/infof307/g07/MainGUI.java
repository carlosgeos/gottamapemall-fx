package be.ac.ulb.infof307.g07; 
/**
 * Created by carlos on 3/11/17.
 */

import javafx.application.Application;


import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


/**
 * <b>MainGUI est la classe qui se charge de lancer l'interface graphique (afficher la carte dans la fenetre).</b>
 * Elle hérite de la classe Application de javafx.
 * 
 * @see MapGUI
 * 
 * @author carlos
 * @version 1.0
 */
public class MainGUI extends Application{

	
	@Override
	/**
	 * 
	 * La méthode qui lance l'interface graphique et l'affiche.
	 * 
	 * @see MapGUI
	 * 
	 * @param primaryStage
	 * 						le containeur parent.
	 * 
	 */
    public void start(Stage primaryStage) {
		
	   /**
		* Un objet GoogleMapView representant la vue et le modèle pour afficher une carte de type google maps.
		* 
		* 
		* @see MapGUI
		* @see MapGUI#MapGUI()
        */
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
	
	/**
	 * 
	 * TBD...
	 * 
	 */
	public static void main(String[] args) {
        launch(args);
    }

}