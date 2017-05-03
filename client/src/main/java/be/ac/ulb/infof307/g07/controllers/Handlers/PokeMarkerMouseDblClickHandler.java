package be.ac.ulb.infof307.g07.controllers.Handlers;

import com.lynden.gmapsfx.javascript.event.UIEventHandler;

import be.ac.ulb.infof307.g07.models.Map;
import be.ac.ulb.infof307.g07.models.PokeMarker;
import be.ac.ulb.infof307.g07.views.MapView;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import netscape.javascript.JSObject;

/**
 * Cette classe gère le double clic sur une épingle, 
 * càd afficher les informations de cette épingle (image, id du pokemon et nom, date et heure de la signalisation) dans une fenêtre avec un bouton delete et un bouton modify, permettant respectivement de supprimer l'épingle ou modifier ses informations. 
 * 
 * @version 1.0
 * 
 * @see be.ac.ulb.infof307.g07.models.Map
 * @see be.ac.ulb.infof307.g07.views.MapView
 * @see be.ac.ulb.infof307.g07.models.PokeMarker
 *
 */
public class PokeMarkerMouseDblClickHandler implements UIEventHandler {
	
	/**
	 * fenêtre pour afficher les informations de l'épingle ainsi que la possibilité de les modifier ou de supprimer l'épingle
	 */
    private Stage mainStage = new Stage();
    
    /**
     * largeur de la fenêtre
     */
    private double mainWidth = 220;
    
    /**
     * hauteur de la fenêtre
     */
    private double mainHeight = 220;
    
    /**
	 * le modèle sur la carte pokemon 
	 * 
	 * @see be.ac.ulb.infof307.g07.models.Map
	 */
    private Map pokeMap;
    
    /**
     * L'objet vue de la carte pokemon pour les actions à effectuer sur l'affichage.
     *
     * @see be.ac.ulb.infof307.g07.views.MapView
     */
    private MapView pokeMapView;
    
    /**
     * l'objet modèle pour une épingle pokemon
     * 
     * @see be.ac.ulb.infof307.g07.models.PokeMarker
     */
    private PokeMarker pokeMarker;
    
    /**
     * la date du repérage du pokemon
     */
    private TextField date;
    
    /**
     * l'heure à laquelle le pokemon a été vu
     */
    private TextField time;
    
    /**
     * un bouton pour supprimer l'épingle pokemon
     */
    private Button deleteButton;
    
    /**
     * un bouton pour modifier les informations de l'épingle (date et heure du repérage)
     */
    private Button modifyButton;
    
    /**
     * Constructeur de PokeMarkerMouseDblClickHandler
     * 
     * @param pokeMap  le modèle sur la carte pokemon.
     * @param pokeMapView L'objet vue de la carte pokemon pour les actions à effectuer sur l'affichage.
     * @param pokeMarker l'objet modèle pour une épingle pokemon
     * 
     * @see be.ac.ulb.infof307.g07.models.Map
     * @see be.ac.ulb.infof307.g07.views.MapView
     * @see be.ac.ulb.infof307.g07.models.PokeMarker
     */
    public PokeMarkerMouseDblClickHandler(Map pokeMap, MapView pokeMapView, PokeMarker pokeMarker) {
        this.pokeMap = pokeMap;
        this.pokeMapView = pokeMapView;
        this.pokeMarker = pokeMarker;
        
        createWindow();
    }
    
    /**
     * Crée une fenêtre contenant les informations de l'épingle (image, id et nom du pokemon, date et heure de la signalisation) et deux boutons, modify et delete, pour modifier l'heure ou la date du repérage, ou supprimer l'épingle.
     */
    public void createWindow() {
        GridPane mainGridPane = new GridPane();
        
        Image pokeImage = new Image(pokeMarker.getIcon());
        Pane newPane = new Pane();
        newPane.getChildren().add(new ImageView(pokeImage));
        
        mainGridPane.add(newPane, 1, 0);
        
        mainGridPane.add(new Label("Id : "), 0, 1);
        mainGridPane.add(new Label("Name : "), 0, 2);
        mainGridPane.add(new Label("Date : "), 0, 3);
        mainGridPane.add(new Label("Time : "), 0, 4);
        
        mainGridPane.add(new Label(Integer.toString(pokeMarker.getPokemon().getId())), 1, 1);
        mainGridPane.add(new Label(pokeMarker.getPokemon().getName()), 1, 2);
        
        this.date = new TextField();
        mainGridPane.add( this.date, 1, 3);
        this.date.setText(this.pokeMarker.getDate());
        
        this.time = new TextField();
        mainGridPane.add( this.time, 1, 4);
        this.time.setText(this.pokeMarker.getTime());
        
        this.deleteButton = new Button();
        this.deleteButton.setText("Delete");
        this.deleteButton.setOnAction(new PokeMarkerRemoveFromMapHandler(pokeMap, pokeMapView, pokeMarker, this.mainStage));
        
        this.modifyButton = new Button();
        this.modifyButton.setText("Modify");
        this.modifyButton.setOnAction((event)->{
            this.pokeMarker.setDate(this.date.getText());
            this.pokeMarker.setTime(this.time.getText());
            
            this.mainStage.close();
        });
        
        mainGridPane.add(this.deleteButton, 0, 5);
        mainGridPane.add(this.modifyButton, 1, 5);
        mainGridPane.setVgap(5);
        mainGridPane.setHgap(5);
        mainGridPane.setPadding(new Insets(10,10,10,10));
        
        Scene mainScene = new Scene(mainGridPane, mainWidth, mainHeight);
        this.mainStage.setScene(mainScene);
        this.mainStage.setResizable(false);;
        this.mainStage.setTitle("Modify menu");
    }
    
    /**
     * Lance et affiche la fenêtre créée
     */
    @Override
    public void handle(JSObject event) {
        this.mainStage.show();
    }
}
