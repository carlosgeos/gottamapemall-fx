package be.ac.ulb.infof307.g07;

import be.ac.ulb.infof307.g07.Views.MapView;
import be.ac.ulb.infof307.g07.Views.PokedexView;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import javafx.stage.Stage;



/**
 * <b>MainGUI est la classe qui se charge de lancer l'interface graphique (afficher la carte dans la fenetre).</b>
 * Elle hérite de la classe Application de javafx.
 *
 * @see be.ac.ulb.infof307.g07.Views.MapView
 *
 * @see MapView
 * @author fan
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
    private PokedexView pokedexView;


    @Override
    /**
     * La méthode qui lance l'interface graphique et l'affiche.
     *
     * @param primaryStage
     * 						le containeur parent.
     */
    public void start(Stage primaryStage) {

    	// configure the main window
	primaryStage.setWidth(mainWindowWidth);
	primaryStage.setHeight(mainWindowHeight);
	primaryStage.setTitle("PokéMap");
	primaryStage.getIcons().add(new Image("https://pro-rankedboost.netdna-ssl.com/wp-content/uploads/2016/08/Togepi-Pokemon-Go.png"));

	this.pokeMapView = new MapView(mainWindowWidth, mainWindowHeight);
	this.pokedexView = new PokedexView(mainWindowWidth/3, mainWindowHeight);

	// configure map view and pokedex view
	StackPane pokedexViewStackPane = pokedexView.getView();
	StackPane stackpane = new StackPane();
	stackpane.getChildren().add(this.pokeMapView.getView());
	stackpane.getChildren().add(pokedexViewStackPane);
	StackPane.setAlignment(pokedexViewStackPane, Pos.TOP_RIGHT);

	StackPane.setMargin(pokedexViewStackPane, new Insets(0, 15, 0, 0));

	GridPane mainGrid = new GridPane();
	mainGrid.add(stackpane, 0, 0);


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
