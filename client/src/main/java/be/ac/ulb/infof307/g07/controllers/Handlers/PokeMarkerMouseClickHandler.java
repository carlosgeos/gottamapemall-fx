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
 * La classe PokeMarkerMouseClickHandler s occupe de gerer le clic sur une epingle de la carte 
 * et affiche une petite infobulle contenant des informations sur cette epingle (marker).
 * 
 * <p>
 * Un objet de cette classe est instancie par la classe MapView, dans sa methode addMarker().
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
     * On objet Marker de la bibliotheque gmpasfx, pour afficher une epingle sur la carte.
     * 
     */
    private Marker marker;
    
    /**
     * Un objet modele pokeMarker qui contient les donnees relatives a une epingle (id, position...)
     * 
     * @see be.ac.ulb.infof307.g07.models.PokeMarker
     * 
     */
    private PokeMarker pokeMarker;
    
    /**
     * On objet googleMap de la bibliotheque gmpasfx, pour afficher une carte de type googlemaps.
     * 
     */
    private GoogleMap googleMap;
    
    /**
     * 
     * Le constructeur de la classe PokeMarkerMouseClickHandler.
     * 
     * @param marker
     *                 L objet Marker (epingle) de la bibliotheque gmapsfx pour l affichage.
     * @param pokeMarker
     *                     L objet PokeMarker (epingle pokemon) contenant les donnees de l epingle a afficher.
     * @param googleMap
     *                     L objet GoogleMap de la bibliotheque gmapsfx, pour l affichage de la carte.
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
     * La methode handle gere le clic sur une epingle, cad affiche une petite infobulle contenant des informations sur cette epingle.
     * 
     * @param event
     *                 Le clic sur l epingle sur la carte.
     */
    public void handle(JSObject event) {
        InfoWindowOptions infoWindowOptions = new InfoWindowOptions();
        infoWindowOptions.content(this.pokeMarker.getString());
        
        InfoWindow pokeMarkerInfoWindow = new InfoWindow(infoWindowOptions);
        pokeMarkerInfoWindow.open(googleMap, marker);
    }
}
