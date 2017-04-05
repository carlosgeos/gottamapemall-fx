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


    private int mainWindowWidth = 800;
    private int mainWindowHeight = 600;

    private GoogleMapView googleMapView;
    private GoogleMap googleMap;
    private static String apikey = "AIzaSyA38gCIADhL0JWZbNmPYtsTgGJJWIyXZNI";

    private MapView pokeMapView;

    @Override
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

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void mapInitialized() {

	// this method is going to be called when the GoogleMap is totally loaded in GoogleMapView
	// So before the finish loading we can't do anything else, because the instance GoogleMap can't be created.
	Map pokeMap = new Map();
	MapView pokeMapView = new MapView(googleMapView);
	MapController mapController = new MapController(pokeMap, pokeMapView);


    }

}
