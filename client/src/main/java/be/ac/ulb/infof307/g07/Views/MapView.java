package be.ac.ulb.infof307.g07.Views;

import java.util.HashMap;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;

import be.ac.ulb.infof307.g07.Controllers.Handlers.PokeMarkerMouseClickHandler;
import be.ac.ulb.infof307.g07.Models.Map;
import be.ac.ulb.infof307.g07.Models.PokeMarker;

public class MapView{ 
	
	/**
	 * Un objet GoogleMapView representant la vue pour afficher une carte de type google maps.
	 * 
	 * 
	 * @see MapView#MapGUI()
     * @see MapView#map
     * @see MapView#mapInitialized()
	 */
	
	/**
	 * Un objet GoogleMap pour afficher la carte google sur base de l'objet GoogleMapView.
	 * 
	 * @see MapView#googleMapView
	 * @see MapView#mapInitialized()
     * @see Map#Map()
     */
	private HashMap<Integer, Marker> markersOnMap= new HashMap<Integer, Marker>();
	private GoogleMap googleMap;
	/**
	* La cle d'authentification google necessaire pour l'utilisation de la carte google maps.
	* 
	* @see MapView#MapGUI()
	*/
	
	/**
	 * L'objet qui contient la carte à afficher. Cette carte est modifiable (on peut notamment lui ajouter des épingles).
     * 
     * @see Map#addPokeMarker(Coordinate)
     * @see Map#Map()
     */

	
	/**
     * Constructeur de l'objet Map.
	 * <p>
     * On cree on objet GoogleMapView auquel on donne la cle apikey en parametre.
     * Et on initialise la carte avec certaines options, grace a la methode addMapInializedListener().
     * </p>
     * 
	 * 
     * @see MapView#apikey
	 * @see MapView#googleMapView
	 * n'existe pas
	 * @see MapView#map
	 * @see Map#Map()
	 * 
	 */
	public MapView( GoogleMapView newGoogleMapView){
		
		MapOptions defaultMapOptions = new MapOptions();
		// here we set the default location as 47.6097, -122.3331
		LatLong defaultMapCenterPosition = new LatLong(47.6097, -122.3331);
		
		defaultMapOptions.center(defaultMapCenterPosition)
        		.mapType(MapTypeIdEnum.ROADMAP)
	            .overviewMapControl(false)
	            .panControl(false)
	            .rotateControl(false)
	            .scaleControl(false)
	            .streetViewControl(false)
	            .zoomControl(false)
	            .zoom(11);
		
		googleMap = newGoogleMapView.createMap(defaultMapOptions);
		
	}
	
	/**
     * 
     * Fait appel a la methode initDefaultMapOptions()
     * Cree un objet goodleMap avec certaines options predefinies (zoom, pas de rotation...) et assigne ensuite le resultat de la methode createMap de l'objet googleMapView a l'objet goodleMap.
     * Cree aussi le listener qui va gerer le double clic sur la carte.
     * 
     * @see MapView#initDefaultMapOptions()
     * @see MapView#googleMapView
     * @see MapView#map
     * @see Map#Map()
     * 
     */
	
	
	 /**
	 * Retourne l'objet de la carte google maps.
     * 
     * @return L'objet map de type GoogleMap.
     */
	
	public GoogleMap getGoogleMap(){
		
		return googleMap;
	}
	
	public void addMarker(PokeMarker pokeMarker){
		
		/*
		 * This method waits for the new created PokeMarker to create a Marker on Map.
		 * PokeMarker is different than Marker. PokeMarker is stored in Map and Marker is an object of the GoogleMap.
		 * PokeMarker is the model and Marker is the view.
		 */
		MarkerOptions markerOption = new MarkerOptions();
		markerOption.position(new LatLong(pokeMarker.getOnMapPosition().getX(), pokeMarker.getOnMapPosition().getY()));
		Marker newMarker = new Marker(markerOption);
		googleMap.addMarker(newMarker);
		googleMap.addUIEventHandler(newMarker, UIEventType.click, new PokeMarkerMouseClickHandler(newMarker, pokeMarker, googleMap));
		
		refreshMap();
		
	}
	
	
	public void refreshMap(){
		
		/* refreshing the map by zooming in and zooming out by 1
		 * -1 of current is because, when double clicking on map it will automatically zoom by 1, so to keep the same zoom level
		 * -1 is necessary
		*/
		int current = googleMap.getZoom() - 1;
		googleMap.setZoom(googleMap.getZoom() + 1);
		googleMap.setZoom(current);
		
	}
}
