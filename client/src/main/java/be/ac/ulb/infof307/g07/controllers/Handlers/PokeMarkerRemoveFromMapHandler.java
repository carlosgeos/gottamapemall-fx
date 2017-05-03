package be.ac.ulb.infof307.g07.controllers.Handlers;

import be.ac.ulb.infof307.g07.models.Map;
import be.ac.ulb.infof307.g07.models.PokeMarker;
import be.ac.ulb.infof307.g07.views.MapView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

/**
 * 
 * Gestion de la suppression d'une épingle pokemon de la carte, à savoir la retirer de l'affichage et décrémenter son compteur d'apparitions
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
	
   /**
    * le modèle sur la carte pokemon 
    * 
    * @see be.ac.ulb.infof307.g07.models.Map
    */
    private Map pokeMap;
    
    //TODO: Changer nom pokeMarkerView -> pokeMapView 
    /**
     * L'objet vue de la carte pokemon pour les actions à effectuer sur l'affichage.
     *
     * @see be.ac.ulb.infof307.g07.views.MapView
     */
    private MapView pokeMarkerView;
    
    /**
     * l'objet modèle pour une épingle pokemon
     * 
     * @see be.ac.ulb.infof307.g07.models.PokeMarker
     */
    private PokeMarker pokeMarker ;
    
    //TODO: TBD...
    /**
     * 
     */
    private Stage mainStage;
    
    //TODO: mainStage TBD...
    /**
     * Constructeur de PokeMarkerRemoveFromMapHandler
     * 
     * @param pokeMap le modèle sur la carte pokemon 
     * @param pokeMapView L'objet vue de la carte pokemon pour les actions à effectuer sur l'affichage
     * @param pokeMarker l'objet modèle pour une épingle pokemon
     * @param mainStage //TODO: TBD...
     */
    public PokeMarkerRemoveFromMapHandler(Map pokeMap, MapView pokeMapView, PokeMarker pokeMarker, Stage mainStage){
        this.pokeMap = pokeMap;
        this.pokeMarkerView = pokeMapView;
        this.pokeMarker = pokeMarker;
        this.mainStage = mainStage;
    }
    
    /**
     * Fait appel aux méthodes removePokeMarker et removeMarker de Map et MapView, qui s'occupent respectivement de décrémenter le compteur 
     * de signalisations du pokemon et de retirer l'épingle du pokemon de la carte.
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
