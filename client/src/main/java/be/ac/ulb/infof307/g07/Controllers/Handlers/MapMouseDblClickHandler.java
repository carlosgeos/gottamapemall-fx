package be.ac.ulb.infof307.g07.Controllers.Handlers;

import com.lynden.gmapsfx.javascript.event.GMapMouseEvent;
import com.lynden.gmapsfx.javascript.event.MouseEventHandler;

import be.ac.ulb.infof307.g07.Models.Coordinate;
import be.ac.ulb.infof307.g07.Models.Map;
import be.ac.ulb.infof307.g07.Models.PokeMarker;
import be.ac.ulb.infof307.g07.Views.MapView;

/**
 * 
 * MapMouseDblClickHandler est la classe qui gere le double clic sur la carte pour afficher une pingle a l endroit du clic.
 * Ceci est fait via la methode handle de cette classe, qui appelle la methode addPokeMarker de la vue pokeMapView (objet MapView).
 * 
 * <p>
 * Un objet de cette classe est instancie par la classe MapController, dans sa methode setListener()..
 * <p>
 * 
 * @version 1.0
 * @see MapMouseDblClickHandler#handle(GMapMouseEvent)
 * @see be.ac.ulb.infof307.g07.Views.MapView
 * @see be.ac.ulb.infof307.g07.Controllers.MapController
 * @see be.ac.ulb.infof307.g07.Controllers.MapController#setListener()
 * 
 */
public class MapMouseDblClickHandler implements MouseEventHandler{

	/**
	 * 
	 * L objet modele de la carte, pour les actions a effectuer sur les donnees.
	 * 
	 * @see be.ac.ulb.infof307.g07.Models.Map
	 */
	private Map pokeMap;
	
	
	/**
	 * L'objet vue de la carte pour les actions a effectuer sur l affichage.
	 * 
	 * @see be.ac.ulb.infof307.g07.Views.MapView
	 */
	private MapView pokeMapView;
	
	
	/**
     * Constructeur de MapMouseDblClickHandler.
     * <p>
     * Ce constructeur lie le gestionnaire (handler) du double clic MapMouseDblClickHandler du controleur avec la vue et le modele via les objets pokeMapView et pokeMap. 
     * Le constructeur est instancie lors de l appel a la methode setListener() d un objet MapController.
     * </p>
     * 
     * @param newPokeMapView
     *            La vue de la carte pour les actions a effectuer sur l affichage.
     * @param newPokeMap
     *            Le modele de la carte, pour les actions a effectuer sur les donnees.
     * 
     * @see MapMouseDblClickHandler#pokeMapView
     * @see MapMouseDblClickHandler#pokeMap
     * @see be.ac.ulb.infof307.g07.Controllers.MapController
     * @see be.ac.ulb.infof307.g07.Controllers.MapController#setListener()
     * @see be.ac.ulb.infof307.g07.Models.Map
     * @see be.ac.ulb.infof307.g07.Views.MapView
     */
	public MapMouseDblClickHandler( MapView newPokeMapView, Map newPokeMap){
		
		pokeMap = newPokeMap;
		pokeMapView = newPokeMapView;
	}
	
	@Override
	/**
	 * 
	 * La methode qui s occupe de la gestion du double clic sur la carte.
	 * Elle cree un nouvel objet Coordinate contenant les coordonnees du clic et les transmet a un nouvel objet PokeMarker (epingle) 
	 * lui meme transmis a pokemapview pour etre affiche au bon endroit sur la carte.
	 * 
	 * @see be.ac.ulb.infof307.g07.Models.Coordinate
	 * @see MapMouseDblClickHandler#pokeMapView
	 * @see MapMouseDblClickHandler#pokeMap
	 * @see be.ac.ulb.infof307.g07.Models.Map
	 * @see be.ac.ulb.infof307.g07.Views.MapView
	 */
	public void handle(GMapMouseEvent event) {
		
		// instance the current mouse location as coordinate object
		double x = event.getLatLong().getLatitude();
		double y = event.getLatLong().getLongitude();
		Coordinate newPosition = new Coordinate(x,y);
		
		// add it first in the model map
		PokeMarker newPMarker = pokeMap.addPokeMarker(newPosition);
		// then add it in the view map
		pokeMapView.addMarker(newPMarker);
	}
	
	
	
}
