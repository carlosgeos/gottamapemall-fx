package be.ac.ulb.infof307.g07;


import be.ac.ulb.infof307.g07.Views.MapView;
//import be.ac.ulb.infof307.g07.Views.PokedexView;
//import be.ac.ulb.infof307.g07.Views.PokemonCellView;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;



/**
 * <b>MainGUI est la classe qui se charge de lancer l'interface graphique (afficher la carte dans la fenetre).</b>
 * Elle hérite de la classe Application de javafx.
 *
<<<<<<< HEAD
 * @see be.ac.ulb.infof307.g07.Views.MapView
 *
=======
 * @see MapView
 * @author fan
>>>>>>> Pokedex graphical view-v1
 * @version 1.0
 */
public class MainGUI extends Application{

	/**
	 * la largeur de la fenetre en pixels
	 */
    private int mainWindowWidth = 800;
    
    /**
     * la hauteur de la fenetre en pixels
     */
    private int mainWindowHeight = 600;

    /**
     * La vue de la carte googleMap 
     */
    
    /**
	 * Un objet GoogleMap pour afficher la carte google sur base de l'objet GoogleMapView.
	 * 
	 * @see be.ac.ulb.infof307.g07.Views.MapView#getGoogleMap()
     * @see be.ac.ulb.infof307.g07.Views.MapView#MapView()
     */
    
   /**
    * La cle d'authentification google necessaire pour l'utilisation de la carte google maps.
    * 
    * @see MainGUI#start()
   	*/

    /**
	 * L'objet vue de la carte pokemon pour les actions a effectuer sur l affichage.
	 * 
	 * @see be.ac.ulb.infof307.g07.Views.MapView
	 */
    private MapView pokeMapView;
    


    @Override
    /**
     * La méthode qui lance l'interface graphique et l'affiche.
     * 
     * @param primaryStage
	 * 						le containeur parent.
     */
    public void start(Stage primaryStage) {


		primaryStage.setWidth(mainWindowWidth);
		primaryStage.setHeight(mainWindowHeight);
		primaryStage.setTitle("PokéMap");

		PokedexView pokedexView = new PokedexView();
		BorderPane pv = pokedexView.getView();

		pv.setMaxSize(mainWindowWidth/3, mainWindowHeight);
		pv.setMinSize(mainWindowWidth/3, mainWindowHeight);
		pv.setStyle("-fx-background-color:#ff0000");
		
		StackPane stackpane = new StackPane();
		stackpane.getChildren().add(this.pokeMapView.getView());
		stackpane.getChildren().add(pv);
		StackPane.setAlignment(pv, Pos.TOP_RIGHT);
	
		GridPane mainGrid = new GridPane();
		mainGrid.add(stackpane, 0, 0);
	
    }

    /**
     * le point d entree du programme
     * 
     * @param args
     * 				some parameters
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * this method is going to be called when the GoogleMap is totally loaded in GoogleMapView
	 * So before the loading is finished we can't do anything else, because the instance GoogleMap can't be created.
	 * 
	 * @see be.ac.ulb.infof307.g07.Models.Map
	 * @see be.ac.ulb.infof307.g07.Views.MapView
	 * @see be.ac.ulb.infof307.g07.Controllers.MapController
	 * 
     */


}
