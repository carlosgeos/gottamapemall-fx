package be.ac.ulb.infof307.g07.controllers.Handlers;

import com.lynden.gmapsfx.javascript.event.GMapMouseEvent;
import com.lynden.gmapsfx.javascript.event.MouseEventHandler;

import be.ac.ulb.infof307.g07.models.Coordinate;
import be.ac.ulb.infof307.g07.models.Map;
import be.ac.ulb.infof307.g07.views.ChoosePokemonView;
import be.ac.ulb.infof307.g07.views.MapView;

/**
 * 
 * Cette classe gere le double clic sur la carte et envoie les coordonnees a addNewPokeMarkerHandler pour creer une nouvelle epingle a l endroit du clic.
 * 
 * @version 1.0
 *
 * @see be.ac.ulb.infof307.g07.controllers.Handlers.addNewPokeMarkerHandler
 * @see be.ac.ulb.infof307.g07.views.ChoosePokemonView
 */
public class onMapDblClickHandler implements MouseEventHandler {
    private Map pokeMap;
    private MapView pokeMapView;
    
    public onMapDblClickHandler(Map pokeMap, MapView pokeMapView) {
        this.pokeMap = pokeMap;
        this.pokeMapView = pokeMapView;
    }
    
    /**
     * Recupere les coordonnees du clic (latitude, longitude) et les envoie au handler addNewPokeMarkerHandler pour l ajout d une epingle pokemon.
     * ChoosePokemonView qui se charge d'afficher les differents pokemons selectionnables, est aussi appelee ici.
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
