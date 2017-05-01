package be.ac.ulb.infof307.g07.controllers.Handlers;

import be.ac.ulb.infof307.g07.models.Map;
import be.ac.ulb.infof307.g07.models.PokeMarker;
import be.ac.ulb.infof307.g07.views.MapView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

/**
 * 
 * Gestion de la suppression d une epingle pokemon de la carte, a savoir la retirer de l affichage et decrementer son compteur d apparitions
 * 
 * @version 1.0
 * 
 * @see be.ac.ulb.infof307.g07.models.Map
 * @see be.ac.ulb.infof307.g07.views.MapView
 * @see be.ac.ulb.infof307.g07.models.Map#removePokeMarker(PokeMarker)
 * @see be.ac.ulb.infof307.g07.views.MapView#removeMarker(ObjectId)
 *
 */
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
    
    /**
     * Fait appel aux methodes removePokeMarker et removeMarker de Map et MapView, qui s occupent respectivement de decrementer le compteur 
     * de signalisations du pokemon et de retirer l epingle du pokemon de la carte.
     * 
     * @see be.ac.ulb.infof307.g07.models.Map
     * @see be.ac.ulb.infof307.g07.views.MapView
     * @see be.ac.ulb.infof307.g07.models.Map#removePokeMarker(PokeMarker)
     * @see be.ac.ulb.infof307.g07.views.MapView#removeMarker(ObjectId)
     */
    @Override
    public void handle(ActionEvent event) {
        this.pokeMap.removePokeMarker(this.pokeMarker);
        this.pokeMarkerView.removeMarker(this.pokeMarker.getId());
        this.mainStage.close();
    }
}
