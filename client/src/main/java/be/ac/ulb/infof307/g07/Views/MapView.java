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
	


	private HashMap<Integer, Marker> markersOnMap= new HashMap<Integer, Marker>();
	
	
	/**
	 * Un objet GoogleMap pour afficher la carte google sur base de l'objet GoogleMapView.
	 * 
	 * @see MapView#getGoogleMap()
     * @see MapView#MapView()
     */
	private GoogleMap googleMap;


	
	/**
     * Constructeur de l'objet MapView.
	 * <p>
     * On cree on objet MapOptions avec certains parametres predefinis. 
     * On cree une googleMapView (sur base de ce MapOptions) via la methode createMap et on l'assigne a notre objet googleMap.
     * </p>
     * 
     *@param newGoogleMapView
	 * 						la vue pour la carte googlemaps.
	 * 
	 *@see MapView#googleMap
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
