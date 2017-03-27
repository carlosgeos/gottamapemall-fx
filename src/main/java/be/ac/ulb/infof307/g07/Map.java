package be.ac.ulb.infof307.g07;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;

import netscape.javascript.JSObject;

/**
 * Map est la classe representant la vue de la carte, c'est a dire sa presentation graphique.
 * A contrario MapController contient les actions possibles sur cette carte.
 *
 *@see Map#Map()
 *@see MapController()
 *
 *@version 1.0
 */
public class Map implements MapComponentInitializedListener{ 
	
	/**
     * Un objet GoogleMapView representant la vue pour afficher une carte de type google maps.
     * 
     * 
     * @see Map#Map()
     * @see Map#map
     */
	private GoogleMapView mapview;
	
	/**
     * Un objet GoogleMap pour afficher la carte google sur base de l'objet GoogleMapView.
     * 
     * @see Map#mapview
     * @see Map#Map()
     */
	private GoogleMap map;
	
	/**
     * La cle d'authentification google necessaire pour l'utilisation de la carte google map.
     * 
     * @see Map#Map()
     */
	private String apikey = "AIzaSyA38gCIADhL0JWZbNmPYtsTgGJJWIyXZNI";
	
	
	/**
     * Le controleur de la carte, c'est a dire l'objet qui contient les actions possibles sur la carte.
     * 
     * @see MapController
     * @see MapController#MapController(GoogleMap)
     */
	private MapController mapController;
	
	 /**
     * Constructeur de l'objet Map.
     * <p>
     * On cree on objet GoogleMapView auquel on donne la cle apikey en parametre.
     * Et on initialise la carte avec certaines options, grace a la methode mapInitialized().
     * </p>
     * 
     * 
     * @see Map#apikey
     * @see Map#mapview
     * @see Map#mapInitialized()
     * 
     */
	public Map(){
		
		mapview = new GoogleMapView(null, apikey);
		mapview.addMapInializedListener(this);
		
	}


	@Override
	 /**
     * 
     * Cree un objet MapOptions avec certaines options predefinies (zoom, pas de rotation...) et assigne ensuite le resultat de la methode createMap de l'objet mapView a l'objet map.
     * Cree aussi le controleur de cet objet map.
     * 
     * @see Map#mapview
     * @see Map#map
     * @see MapController
     * @see MapController#MapController(GoogleMap)
     * 
     */
	public void mapInitialized() {
	    //Set the initial properties of the map.
	    MapOptions mapOptions = new MapOptions();
	
	    mapOptions.center(new LatLong(47.6097, -122.3331))
        		.mapType(MapTypeIdEnum.ROADMAP)
	            .overviewMapControl(false)
	            .panControl(false)
	            .rotateControl(false)
	            .scaleControl(false)
	            .streetViewControl(false)
	            .zoomControl(false)
	            .zoom(12);
	
	    map = mapview.createMap(mapOptions);
	    
	    mapController = new MapController(map);
	
	}
	
	 /**
     * Retourne l'objet vue de la carte google maps.
     * 
     * @return L'objet mapview de type GoogleMapView.
     */
	public GoogleMapView getView(){
		
		return mapview;
		
	}
	
	 /**
     * Retourne l'objet de la carte google maps.
     * 
     * @return L'objet map de type GoogleMap.
     */
	public GoogleMap getMap(){
		
		return map;
	
	}
	
	/**
     * Retire un Zero de la liste des amis.
     * 
     * @param posMarker
     *            Un objet contenant une longitude et une latitude pour une nouvelle epingle a ajouter sur la carte.
     * 
     * @see MapController
     * @see MapController#addMarker(LatLong)
     * @see MarkerController
     * @see MarkerController#addMarker(LatLong)
     * 
     */
	public void onClickButton(LatLong posMarker){
		
		mapController.addMarker(posMarker);
		
	}
	
	
}
