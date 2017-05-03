package be.ac.ulb.infof307.g07.controllers.Handlers;

import com.lynden.gmapsfx.javascript.event.UIEventHandler;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.InfoWindow;
import com.lynden.gmapsfx.javascript.object.InfoWindowOptions;
import com.lynden.gmapsfx.javascript.object.Marker;

import be.ac.ulb.infof307.g07.models.PokeMarker;
import netscape.javascript.JSObject;

/**
 * 
 * La classe PokeMarkerMouseClickHandler s'occupe de gérer le clic sur une épingle de la carte 
 * et affiche une petite infobulle contenant des informations sur cette épingle (marker).
 * 
 * <p>
 * Un objet de cette classe est instancié par la classe MapView, dans sa méthode addMarker().
 * <p>
 * 
 * @version 1.0
 * @see PokeMarkerMouseClickHandler#handle(JSObject)
 * @see be.ac.ulb.infof307.g07.models.PokeMarker
 * @see be.ac.ulb.infof307.g07.views.MapView
 * @see be.ac.ulb.infof307.g07.views.MapView#addMarker(PokeMarker)
 *
 */
public class PokeMarkerMouseClickHandler implements UIEventHandler{
	
    /**
     * Un objet Marker de la bibliothèque gmpasfx, pour afficher une épingle sur la carte.
     * 
     */
    private Marker marker;
    
    /**
     * Un objet modèle pokeMarker qui contient les données relatives à une épingle (id, position...)
     * 
     * @see be.ac.ulb.infof307.g07.models.PokeMarker
     * 
     */
    private PokeMarker pokeMarker;
    
    /**
     * Un objet googleMap de la bibliothèque gmpasfx, pour afficher une carte de type googlemaps.
     * 
     */
    private GoogleMap googleMap;
    
    /**
     * 
     * Le constructeur de la classe PokeMarkerMouseClickHandler.
     * 
     * @param marker
     *               L'objet Marker (épingle) de la bibliothèque gmapsfx pour l'affichage.
     * @param pokeMarker
     *                 L'objet PokeMarker (épingle pokemon) contenant les données de l'épingle à afficher.
     * @param googleMap
     *                 L'objet GoogleMap de la bibliothèque gmapsfx, pour l'affichage de la carte.
     * 
     * @see PokeMarkerMouseClickHandler#marker
     * @see PokeMarkerMouseClickHandler#pokeMarker
     * @see PokeMarkerMouseClickHandler#googleMap
     * @see be.ac.ulb.infof307.g07.views.MapView
     * 
     */
    public PokeMarkerMouseClickHandler(Marker marker, PokeMarker pokeMarker, GoogleMap googleMap) {
        this.marker = marker;
        this.pokeMarker = pokeMarker;
        this.googleMap = googleMap;
    }

    @Override
    /**
     * 
     * La méthode handle gère le clic sur une épingle, càd affiche une petite infobulle contenant des informations sur cette épingle.
     * 
     * @param event
     *             Le clic sur l'épingle sur la carte.
     */
    public void handle(JSObject event) {
        InfoWindowOptions infoWindowOptions = new InfoWindowOptions();
        infoWindowOptions.content(this.pokeMarker.getString());
        
        InfoWindow pokeMarkerInfoWindow = new InfoWindow(infoWindowOptions);
        pokeMarkerInfoWindow.open(googleMap, marker);
    }
}
