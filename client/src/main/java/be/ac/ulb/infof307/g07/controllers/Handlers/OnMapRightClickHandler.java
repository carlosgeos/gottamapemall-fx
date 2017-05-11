package be.ac.ulb.infof307.g07.controllers.Handlers;

import java.util.ArrayList;
import java.util.HashMap;
import org.bson.types.ObjectId;

import com.lynden.gmapsfx.javascript.event.GMapMouseEvent;
import com.lynden.gmapsfx.javascript.event.MouseEventHandler;

import be.ac.ulb.infof307.g07.models.Coordinate;
import be.ac.ulb.infof307.g07.models.GeoLocaLisation;
import be.ac.ulb.infof307.g07.models.Map;
import be.ac.ulb.infof307.g07.views.MapView;

/**
 * Definit la position de l utilisateur a l endroit du clic droit sur la carte.
 * 
 * @author pierre et fan
 *
 */
public class OnMapRightClickHandler implements MouseEventHandler {
    private Map pokeMap;
    private MapView pokeMapView;
    
    public OnMapRightClickHandler(Map pokeMap, MapView pokeMapView) {
        this.pokeMap = pokeMap;
        this.pokeMapView = pokeMapView;
    }

    @Override
    public void handle(GMapMouseEvent event) {
        Coordinate myPosition = new Coordinate(event.getLatLong().getLatitude(), event.getLatLong().getLongitude());
        HashMap<ObjectId, Integer> tempMarkerList = GeoLocaLisation.pokemonsAroundMe(pokeMap.getPokeMarkers(), GeoLocaLisation.radius, myPosition);
        pokeMapView.geoLocalisationSetMarkers(tempMarkerList);
        pokeMapView.geoLocalisationSetShape(myPosition, GeoLocaLisation.radius);
    }
} 