package be.ac.ulb.infof307.g07.controllers.Handlers;

import be.ac.ulb.infof307.g07.models.Map;
import be.ac.ulb.infof307.g07.models.PokeMarker;
import be.ac.ulb.infof307.g07.views.MapView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class PokeMarkerRemoveFromMapHandler implements EventHandler<ActionEvent> {
    private Map pokeMap;
    private MapView pokeMarkerView;
    private PokeMarker pokeMarker ;
    private Stage mainStage;
    
    public PokeMarkerRemoveFromMapHandler(Map pokeMap, MapView pokeMapView, PokeMarker pokeMarker, Stage mainStage){
        this.pokeMap = pokeMap;
        this.pokeMarkerView = pokeMapView;
        this.pokeMarker = pokeMarker;
        this.mainStage = mainStage;
    }
    
    @Override
    public void handle(ActionEvent event) {
        this.pokeMap.removePokeMarker(this.pokeMarker);
        this.pokeMarkerView.removeMarker(this.pokeMarker.getId());
        this.mainStage.close();
    }
}