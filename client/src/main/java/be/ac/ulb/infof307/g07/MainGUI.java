package be.ac.ulb.infof307.g07;

import be.ac.ulb.infof307.g07.libs.CustomGson;
import be.ac.ulb.infof307.g07.views.GeoLocalisationView;
import be.ac.ulb.infof307.g07.views.MapView;
import be.ac.ulb.infof307.g07.views.PokedexView;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import javafx.stage.Stage;

/**
 * <b>MainGUI est la classe qui se charge de lancer l'interface graphique (afficher la carte dans la fenetre).</b>
 * Elle herite de la classe Application de javafx.
 *
 * @see be.ac.ulb.infof307.g07.views.MapView
 *
 * @see MapView
 * @author fan
 * @version 1.0
 */
public class MainGUI extends Application {
    /**
     * la largeur de la fenetre en pixels
     */
    private int mainWindowWidth = 1200;

    /**
     * la hauteur de la fenetre en pixels
     */
    private int mainWindowHeight = 600;

    /**
     * L'objet vue de la carte pokemon pour les actions a effectuer sur l affichage.
     *
     * @see be.ac.ulb.infof307.g07.views.MapView
     */
    private MapView pokeMapView;
    
    
    
    private PokedexView pokedexView;

    @Override
    /**
     * La méthode qui lance l'interface graphique et l'affiche.
     *
     * @param primaryStage
     *                         le containeur parent.
     */
    public void start(Stage primaryStage) {
        CustomGson.create();

        // configure the main window
        primaryStage.setWidth(mainWindowWidth);
        primaryStage.setHeight(mainWindowHeight);
        primaryStage.setTitle("PokéMap");
        primaryStage.getIcons().add(new Image("https://pro-rankedboost.netdna-ssl.com/wp-content/uploads/2016/08/Togepi-Pokemon-Go.png"));

        this.pokedexView = new PokedexView(mainWindowWidth/3, mainWindowHeight);
        this.pokeMapView = new MapView(mainWindowWidth, mainWindowHeight, this.pokedexView);

        // configure map view and pokedex view
        StackPane pokedexViewStackPane = pokedexView.getView();
        StackPane stackpane = new StackPane();
        stackpane.getChildren().add(this.pokeMapView.getView());
        stackpane.getChildren().add(pokedexViewStackPane);
        StackPane.setAlignment(pokedexViewStackPane, Pos.TOP_RIGHT);
        
        Slider slider = GeoLocalisationView.createView(mainWindowWidth/3*2, 200);
        stackpane.getChildren().add(slider);
        StackPane.setAlignment(slider, Pos.TOP_LEFT);
        
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
     *                 some parameters
     */
    public static void main(String[] args) {
        launch(args);
    }
}
