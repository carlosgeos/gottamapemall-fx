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

public class PokeMarkerMouseDblClickHandler implements UIEventHandler {
    private Stage mainStage = new Stage();
    private double mainWidth = 220;
    private double mainHeight = 220;
    private Map pokeMap;
    private MapView pokeMapView;
    private PokeMarker pokeMarker;
    
    private TextField date;
    private TextField time;
    private Button deleteButton;
    private Button modifyButton;
    
    public PokeMarkerMouseDblClickHandler(Map pokeMap, MapView pokeMapView, PokeMarker pokeMarker) {
        this.pokeMap = pokeMap;
        this.pokeMapView = pokeMapView;
        this.pokeMarker = pokeMarker;
        
        createWindow();
    }
    
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
    
    @Override
    public void handle(JSObject event) {
        this.mainStage.show();
    }
}
