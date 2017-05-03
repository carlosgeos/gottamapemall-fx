package be.ac.ulb.infof307.g07.controllers.Handlers;

import com.lynden.gmapsfx.javascript.event.GMapMouseEvent;
import com.lynden.gmapsfx.javascript.event.MouseEventHandler;

import be.ac.ulb.infof307.g07.models.Coordinate;
import be.ac.ulb.infof307.g07.models.Map;
import be.ac.ulb.infof307.g07.views.ChoosePokemonView;
import be.ac.ulb.infof307.g07.views.MapView;

/**
 * 
 * Cette classe gère le double clic sur la carte et envoie les coordonnées à addNewPokeMarkerHandler pour créer une nouvelle épingle à l'endroit du clic.
 * 
 * @version 1.0
 *
 * @see be.ac.ulb.infof307.g07.controllers.Handlers.addNewPokeMarkerHandler
 * @see be.ac.ulb.infof307.g07.views.ChoosePokemonView
 */
public class onMapDblClickHandler implements MouseEventHandler {
   
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
     * Constructeur de onMapDblClickHandler
     * 
     * @param pokeMap le modèle sur la carte pokemon
     * @param pokeMapView la vue sur la carte pokemon
     */
    public onMapDblClickHandler(Map pokeMap, MapView pokeMapView) {
        this.pokeMap = pokeMap;
        this.pokeMapView = pokeMapView;
    }
    
    /**
     * Récupère les coordonnées du clic (latitude, longitude) et les envoie au handler addNewPokeMarkerHandler pour l'ajout d'une épingle pokemon.
     * ChoosePokemonView qui se charge d'afficher les différents pokemons sélectionnables, est aussi appelée ici.
     * 
     * @see be.ac.ulb.infof307.g07.views.ChoosePokemonView
     */
    @Override
    public void handle(GMapMouseEvent event) {
        this.pokeMapView.refreshMap();

        if(!ChoosePokemonView.isCreated) {
            double lat = event.getLatLong().getLatitude();
            double lon = event.getLatLong().getLongitude();

            addNewPokeMarkerHandler newHandler = new addNewPokeMarkerHandler(this.pokeMap, this.pokeMapView, lat, lon);
            
            ChoosePokemonView newChooseWindow = new ChoosePokemonView();
            newChooseWindow.addListener(newHandler);
        }
    }
}
