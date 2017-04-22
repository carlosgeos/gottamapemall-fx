package be.ac.ulb.infof307.g07.Views;

import java.util.HashMap;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;

import be.ac.ulb.infof307.g07.Controllers.Handlers.PokeMarkerMouseClickHandler;
import be.ac.ulb.infof307.g07.Controllers.Handlers.PokeMarkerMouseDblClickHandler;
import be.ac.ulb.infof307.g07.Controllers.Handlers.onMapDblClickHandler;
import be.ac.ulb.infof307.g07.Models.Coordinate;
import be.ac.ulb.infof307.g07.Models.Map;
import be.ac.ulb.infof307.g07.Models.PokeMarker;
import javafx.scene.layout.BorderPane;

/**
 * 
 * Cette classe represente la vue dans la structure MVC cad la classe s occupant de l affichage de la carte et de ses composantes graphiques.
 * 
 * <p>
 * Un objet de cette classe est cree par les classes suivantes: MapController, MapMouseDblClickHandler et MainGUI, dans leurs constructeurs respectifs et la methode mapInitialized() de MainGUI.
 * <p>
 * 
 * @version 1.0
 *
 * @see be.ac.ulb.infof307.g07.MainGUI
 * @see be.ac.ulb.infof307.g07.Controllers.Handlers.PokeMarkerMouseDblClickHandler
 * @see MapView#mapInitialized()
 *
 */
public class MapView  implements MapComponentInitializedListener{ 
	

	/**
	 * Une table de hachage contenant les markers (epingles) presents sur la carte et leurs identifiants (nombre entier servant de clef).
	 * 
	 * @see be.ac.ulb.infof307.g07.Models.Map#pokeMarkers
	 * 
	 */
	private HashMap<Integer, Marker> markersOnMap= new HashMap<Integer, Marker>();
	
	
	/**
	 * Un objet GoogleMap pour afficher la carte google sur base de l'objet GoogleMapView.
	 * 
	 * @see MapView#getGoogleMap()
     * @see MapView#MapView()
     */
	
	private static String apikey = "AIzaSyA38gCIADhL0JWZbNmPYtsTgGJJWIyXZNI";
	public static Coordinate position;
	
	private GoogleMap googleMap;
	private GoogleMapView googleMapView;
	
	private Map pokeMap;
	
	private double mapWidth;
	private double mapHeight;
	
	private BorderPane mapViewBorderPane;

	

	
	/**
     * Constructeur de l'objet MapView.
	 * <p>
     * On cree on objet MapOptions avec certains parametres predefinis. 
     * On cree une googleMapView (sur base de ce MapOptions) via la methode createMap et on l'assigne a notre objet googleMap.
     * </p>
     * 
     *@param width
	 * 						la largeur de la carte a afficher.
     *@param height
	 * 						la hauteur de la carte a afficher.
	 * 
	 *@see MapView#googleMap
	 * 
	 */
	public MapView( double width, double height){
		
		this.mapWidth = width;
		this.mapHeight = height;
		
		this.pokeMap = new Map();
		
		this.googleMapView = new GoogleMapView(null, apikey);
		googleMapView.addMapInializedListener(this);
		
		this.mapViewBorderPane = new BorderPane();
		this.mapViewBorderPane .setCenter(googleMapView);
		this.mapViewBorderPane .setMinSize(this.mapWidth, this.mapHeight);
		
		this.mapViewBorderPane.setOpacity(0);
		
	}
	
	public MapView(){
		
		this.pokeMap = new Map();
		this.googleMap = null;
		this.googleMapView = null;
	}
	
	
	
	/**
	 * Retourne l'objet de la carte google maps.
     * 
     * @return L'objet map de type GoogleMap.
     */
	public GoogleMap getGoogleMap(){
		
		return googleMap;
	}
	
	public BorderPane getView(){
		
		
		return this.mapViewBorderPane;
		
	}
	
	public final int getNumberOfMarkerOnMap(){
		
		return this.markersOnMap.size();
	}
	
	public Map getMap(){
		
		
		return this.pokeMap;
		
	}
	
	/**
	 * 
	 * This method waits for the new created PokeMarker to create a Marker on Map.
	 * PokeMarker is different than Marker. PokeMarker is stored in Map and Marker is an object of the GoogleMap.
	 * PokeMarker is the model and Marker is the view.
	 * 	 
	 * @param pokeMarker
	 * 					the custom pokemon marker object.					
	 * 
	 * @see be.ac.ulb.infof307.g07.Controllers.Handlers.PokeMarkerMouseClickHandler
	 * @see MapView#googleMap
	 * 
	 */
	public void addMarker(PokeMarker pokeMarker){
		
		MarkerOptions markerOption = new MarkerOptions();
		markerOption.position(new LatLong(pokeMarker.getOnMapPosition().getX(), pokeMarker.getOnMapPosition().getY()));
		markerOption.icon(pokeMarker.getIcon());
		Marker newMarker = new Marker(markerOption);
		
		markersOnMap.put(pokeMarker.getId(), newMarker);
		
		// this if is only used for the test unit
		if(googleMap != null){
			
			googleMap.addMarker(newMarker);
			googleMap.addUIEventHandler(newMarker, UIEventType.click, new PokeMarkerMouseClickHandler(newMarker, pokeMarker, googleMap));
			googleMap.addUIEventHandler(newMarker, UIEventType.dblclick, new PokeMarkerMouseDblClickHandler(pokeMap, this, pokeMarker));
		
			refreshMap();
		}
		
	}
	
	
	public void updateMarkers(){
		
		Integer idOfPokeMarker = this.pokeMap.getIdOfPokeMarkerNotOnMap();
		Integer empty = -1;
		
		while(idOfPokeMarker != empty){
			
			addMarker(this.pokeMap.getPokeMarker(idOfPokeMarker));
			
			this.pokeMap.removePokeMarkerJustAddedOnMapView(idOfPokeMarker);
			
			idOfPokeMarker = this.pokeMap.getIdOfPokeMarkerNotOnMap();
		}
		
		
	}
	
	/**
	 * refreshing the map by zooming in and zooming out by 1
	 * -1 of current is because, when double clicking on map it will automatically zoom by 1, so to keep the same zoom level
	 * -1 is necessary
	 * 
	 * @see MapView#googleMap
	 */
	public void refreshMap(){
		
		int current = googleMap.getZoom() - 1;
		googleMap.setZoom(googleMap.getZoom() + 1);
		googleMap.setZoom(current);
		
	}
	
	public void removeMarker(Integer id){
		
		googleMap.removeMarker(markersOnMap.get(id));
		markersOnMap.remove(id);
		
	}

	@Override
	public void mapInitialized() {
		
		MapOptions defaultMapOptions = new MapOptions();
		// here we set the default location as 47.6097, -122.3331
		LatLong defaultMapCenterPosition = new LatLong(47.6097, -122.3331);
		
		defaultMapOptions.center(defaultMapCenterPosition)
        		.mapType(MapTypeIdEnum.ROADMAP)
        		
                .mapTypeControl(false)
	            .overviewMapControl(false)
	            .panControl(false)
	            .rotateControl(false)
	            .scaleControl(false)
	            .streetViewControl(false)
	            .zoomControl(false)
	            .zoom(11);
				
		googleMap = this.googleMapView.createMap(defaultMapOptions);
		googleMap.addMouseEventHandler(UIEventType.dblclick, new onMapDblClickHandler(this.pokeMap, this));
		
		this.mapViewBorderPane.setOpacity(1);
		
	}
}

