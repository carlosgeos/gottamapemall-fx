package be.ac.ulb.infof307.g07;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.InfoWindow;
import com.lynden.gmapsfx.javascript.object.InfoWindowOptions;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;

import javafx.scene.layout.BorderPane;

public class MapGUI implements MapComponentInitializedListener{ 
	
	/**
	 * Un objet GoogleMapView representant la vue pour afficher une carte de type google maps.
	 * 
	 * 
	 * @see MapGUI#MapGUI()
     * @see MapGUI#map
     * @see MapGUI#mapInitialized()
	 */
	private GoogleMapView googleMapView;
	
	/**
	 * Un objet GoogleMap pour afficher la carte google sur base de l'objet GoogleMapView.
	 * 
	 * @see MapGUI#googleMapView
	 * @see MapGUI#mapInitialized()
     * @see Map#Map()
     */
	private GoogleMap googleMap;
	
	/**
	* La cle d'authentification google necessaire pour l'utilisation de la carte google maps.
	* 
	* @see MapGUI#MapGUI()
	*/
	private String apikey = "AIzaSyA38gCIADhL0JWZbNmPYtsTgGJJWIyXZNI";
	
	
	private MapOptions defaultMapOptions;
	
	/**
	 * L'objet qui contient la carte à afficher. Cette carte est modifiable (on peut notamment lui ajouter des épingles).
     * 
     * @see Map#addPokeMarker(Coordinate)
     * @see Map#Map()
     */
	private Map map;
	
	
	
	private Coordinate defaultMapCenterPosition;
	
	

	private BorderPane mapGUI;
	
	/**
     * Constructeur de l'objet Map.
	 * <p>
     * On cree on objet GoogleMapView auquel on donne la cle apikey en parametre.
     * Et on initialise la carte avec certaines options, grace a la methode addMapInializedListener().
     * </p>
     * 
	 * 
     * @see MapGUI#apikey
	 * @see MapGUI#googleMapView
	 * @see MapGUI#addMapInializedListener()
	 * @see MapGUI#map
	 * @see Map#Map()
	 * 
	 */
	public MapGUI(){
		
		googleMapView = new GoogleMapView(null, apikey);
		googleMapView.addMapInializedListener(this);
		map = new Map();
		
	}
	
	
	private void initDefaultMapOptions(){
		
		defaultMapOptions= new MapOptions();
		defaultMapCenterPosition = new Coordinate(47.6097, -122.3331);
		
		defaultMapOptions.center(defaultMapCenterPosition)
        		.mapType(MapTypeIdEnum.ROADMAP)
	            .overviewMapControl(false)
	            .panControl(false)
	            .rotateControl(false)
	            .scaleControl(false)
	            .streetViewControl(false)
	            .zoomControl(false)
	            .zoom(11);
	}
	
	@Override
	 /**
      * 
      * Fait appel a la methode initDefaultMapOptions()
      * Cree un objet goodleMap avec certaines options predefinies (zoom, pas de rotation...) et assigne ensuite le resultat de la methode createMap de l'objet googleMapView a l'objet goodleMap.
      * Cree aussi le listener qui va gerer le double clic sur la carte.
      * 
      * @see MapGUI#initDefaultMapOptions()
      * @see MapGUI#googleMapView
      * @see MapGUI#map
      * @see Map#Map()
      * 
      */
	public void mapInitialized() {
		
		initDefaultMapOptions();
		googleMap = googleMapView.createMap(defaultMapOptions);
		googleMap.addMouseEventHandler(UIEventType.dblclick, new MapMouseDblClickHandler(this, map));
		
	}
	
	public void setWidth(double nbSize ){
		
		mapGUI.setMinWidth(nbSize);
	}
	
	public void setHeight(double nbSize){
			
		mapGUI.setMinHeight(nbSize);
		
	}
	
	public BorderPane getMapGUI(double width, double height){
		
		mapGUI = new BorderPane();
		mapGUI.setCenter(googleMapView);
		mapGUI.setMinSize(width, height);
		return mapGUI;
		
	}
	
	 /**
	 * Retourne l'objet de la carte google maps.
     * 
     * @return L'objet map de type GoogleMap.
     */
	public GoogleMap getMap(){
		
		return googleMap;
		
	}
	
	public void addMarker(PokeMarker newPMarker){
		
		googleMap.addMarker(newPMarker);
		InfoWindowOptions infoWindowOptions = new InfoWindowOptions();
        infoWindowOptions.content("<h2>Marker"+Integer.toString(newPMarker.getId())+"</h2>"
                                + "Current Location: Safeway<br>"
                                + "ETA: 45 minutes" );

        InfoWindow pokeMarkerInfoWindow = new InfoWindow(infoWindowOptions);
        pokeMarkerInfoWindow.open(googleMap, newPMarker);
		googleMap.addUIEventHandler(newPMarker, UIEventType.click, new PokeMarkerMouseClickHandler(newPMarker, pokeMarkerInfoWindow, googleMap));
		
		refreshMap();
	}
	
	public void refreshMap(){
		
		int current = googleMap.getZoom()-1;
		googleMap.setZoom(googleMap.getZoom() + 1);
		googleMap.setZoom(current);
		
	}
	
	public void test(){
		
		System.out.println("MapGUI test");
		map.test();
	}

}
