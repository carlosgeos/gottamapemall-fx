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
 * Définit la position de l'utilisateur à l'endroit du clic droit sur la carte.
 * 
 * @author pierre et fan
 *
 */
public class OnMapRightClickHandler implements MouseEventHandler {
	
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
     * Constructeur de OnMapRightClickHandler
     * 
     * @param pokeMap le modèle sur la carte pokemon
     * @param pokeMapView la vue sur la carte pokemon
     */
    public OnMapRightClickHandler(Map pokeMap, MapView pokeMapView) {
        this.pokeMap = pokeMap;
        this.pokeMapView = pokeMapView;
    }

    /**
     * Récupère les coordonnées du clic droit sur la carte (latitude et longitude) et crée un objet Coordinate avec celles-ci, pour représenter la position de l'utilisateur sur la carte.
     * On fait ensuite appel à la méthode pokemonsAroundMe() de GeoLocaLisation, pour récupérer les pokemons autour de la position de l'utilisateur (dans un cercle de rayon égal au rayon choisi) et les sauvegarder dans une table de hachage (tempMarkerList).
     * Cette table de hachage est alors utilisée par la méthode geoLocalisationSetMarkers() de MapView qui va cacher (rendre invisibles) les épingles sur la carte qui ne sont pas dans cette table.
     * Enfin on fait appel à geoLocalisationSetShape() de MapView qui va créer une zone circulaire colorée autour de l'utilisateur, délimitant ainsi les pokemons qui seront affichés sur la carte.
     * 
     * @see be.ac.ulb.infof307.g07.models.GeoLocaLisation
     * @see be.ac.ulb.infof307.g07.models.GeoLocaLisation#pokemonsAroundMe(PokeMarker[], int, Coordinate)
     * @see be.ac.ulb.infof307.g07.views.MapView
     * @see be.ac.ulb.infof307.g07.views.MapView#geoLocalisationSetMarkers(HashMap)
     * @see be.ac.ulb.infof307.g07.views.MapView#geoLocalisationSetShape(Coordinate, int)
     * 
     */
    @Override
    public void handle(GMapMouseEvent event) {
        Coordinate myPosition = new Coordinate(event.getLatLong().getLatitude(), event.getLatLong().getLongitude());
        HashMap<ObjectId, Integer> tempMarkerList = GeoLocaLisation.pokemonsAroundMe(pokeMap.getPokeMarkers(), GeoLocaLisation.radius, myPosition);
        pokeMapView.geoLocalisationSetMarkers(tempMarkerList);
        pokeMapView.geoLocalisationSetShape(myPosition, GeoLocaLisation.radius);
    }
} 
