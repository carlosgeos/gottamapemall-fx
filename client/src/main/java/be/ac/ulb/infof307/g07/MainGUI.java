package be.ac.ulb.infof307.g07;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.GoogleMap;

import be.ac.ulb.infof307.g07.Controllers.MapController;
import be.ac.ulb.infof307.g07.Models.Map;
import be.ac.ulb.infof307.g07.Views.MapView;
import javafx.application.Application;


import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


/**
 * <b>MainGUI est la classe qui se charge de lancer l'interface graphique (afficher la carte dans la fenetre).</b>
 * Elle hérite de la classe Application de javafx.
 *
 * @see be.ac.ulb.infof307.g07.Views.MapView
 *
 * @version 1.0
 */
public class MainGUI extends Application implements MapComponentInitializedListener{

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
    private GoogleMapView googleMapView;
    
    /**
	 * Un objet GoogleMap pour afficher la carte google sur base de l'objet GoogleMapView.
	 * 
	 * @see be.ac.ulb.infof307.g07.Views.MapView#getGoogleMap()
     * @see be.ac.ulb.infof307.g07.Views.MapView#MapView()
     */
    private GoogleMap googleMap;
    
   /**
    * La cle d'authentification google necessaire pour l'utilisation de la carte google maps.
    * 
    * @see MainGUI#start()
   	*/
    private static String apikey = "AIzaSyA38gCIADhL0JWZbNmPYtsTgGJJWIyXZNI";

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

		googleMapView = new GoogleMapView(null, apikey);
		googleMapView.addMapInializedListener(this);
	
		primaryStage.setWidth(mainWindowWidth);
		primaryStage.setHeight(mainWindowHeight);
		primaryStage.setTitle("PokéMap");
	
		BorderPane mapBorderPane = new BorderPane();
		mapBorderPane.setCenter(googleMapView);
		mapBorderPane.setMinSize(mainWindowWidth, mainWindowHeight);
	
		GridPane mainGrid = new GridPane();
		mainGrid.add( mapBorderPane, 0, 0);
	
		Scene mainScene = new Scene(mainGrid);
		primaryStage.setScene(mainScene);
		primaryStage.show();
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

    @Override
    /**
     * this method is going to be called when the GoogleMap is totally loaded in GoogleMapView
	 * So before the loading is finished we can't do anything else, because the instance GoogleMap can't be created.
	 * 
	 * @see be.ac.ulb.infof307.g07.Models.Map
	 * @see be.ac.ulb.infof307.g07.Views.MapView
	 * @see be.ac.ulb.infof307.g07.Controllers.MapController
	 * 
     */
    public void mapInitialized() {

		Map pokeMap = new Map();
		MapView pokeMapView = new MapView(googleMapView);
		MapController mapController = new MapController(pokeMap, pokeMapView);

    }

}
