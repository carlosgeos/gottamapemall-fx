package be.ac.ulb.infof307.g07.models;

import java.net.ConnectException;
import java.util.HashMap;

import com.lynden.gmapsfx.javascript.event.MapStateEventType;
import com.lynden.gmapsfx.javascript.event.StateEventHandler;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.ClusteredGoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.LatLongBounds;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import com.lynden.gmapsfx.shapes.Circle;
import com.lynden.gmapsfx.shapes.CircleOptions;
import com.lynden.gmapsfx.util.MarkerImageFactory;

import be.ac.ulb.infof307.g07.controllers.CloseMarkerOptionHandler;
import be.ac.ulb.infof307.g07.controllers.MapDblClickHandler;
import be.ac.ulb.infof307.g07.controllers.MapRightClickHandler;
import be.ac.ulb.infof307.g07.controllers.PokeMarkerLeftClickHandler;
import be.ac.ulb.infof307.g07.controllers.PokeMarkerRightClickHandler;


/**
 * Map est le modele qui stocke l ensemble de modeles (ex: PokerMarker) se trouvant sur la map.
 *
 */
public class Map{

	public static final Double[] defaultLocation = {47.6097, -122.3331};
	public static final boolean defaultValue = false;
	public static final int defaultZoom = 11;
	public static final String defaultApiKey = "AIzaSyA38gCIADhL0JWZbNmPYtsTgGJJWIyXZNI";
	private static double lat;
	private static double lon;
	
	private static Map instance = null;
	private ClusteredGoogleMap googleMap;
	private HashMap<Integer, PokeMarker> pokeMarkers;
	private Circle shapeOfGeoLoc = null;
	private LatLong mapCenter;
	private LatLongBounds mapBound;
	
	/**
	 * Construit un objet du type Map
	 */
	public Map( ClusteredGoogleMap newGoogleMap ){
		googleMap = newGoogleMap;
		mapCenter = googleMap.getCenter();
		googleMap.addMouseEventHandler(UIEventType.dblclick, new MapDblClickHandler(this));
		googleMap.addMouseEventHandler(UIEventType.rightclick, new MapRightClickHandler(this));
		googleMap.addStateEventHandler(MapStateEventType.zoom_changed, new CloseMarkerOptionHandler());
		googleMap.addStateEventHandler(MapStateEventType.dragstart, new CloseMarkerOptionHandler());
		googleMap.addStateEventHandler(MapStateEventType.dragend, new StateEventHandler(){

			@Override
			public void handle() {
				mapCenter = googleMap.getCenter();
				mapBound = googleMap.getBounds();
				System.out.println(mapCenter);
				System.out.println(googleMap.getBounds());
				
			}
			
			
		});
		
		pokeMarkers = new HashMap<Integer, PokeMarker>();
		instance = this;
	}
	
	/**
	 * Methode singleton qui renvoie une instance de cette classe
	 * @return Objet Map
	 */
	public static Map getInstance( ClusteredGoogleMap newGoogleMap ){
		if (instance == null){
			instance = new Map(newGoogleMap);
		}
		return instance;
	}
	
	public static Map getInstance(){
		
		return instance;
		
	}
	
	public ClusteredGoogleMap getGoogleMap(){
		return googleMap;
	}

	/**
	 * Cette methode ajoute un PokerMarker dans le hashmap pokemarkers et il l envoie au serveur.
	 * 
	 * @param pokemon Pokemon que l on souhaite ajouter
	 * @param lat Latitude du marker
	 * @param lon Longitude du marker
	 * @param dateTime Timestamp
	 * @return Renvoie un objet PokeMarker si tout est sauvegarde correctement, null sinon.
	 */
	public PokeMarker addPokeMarker(Pokemon pokemon, String date, String time){
		
		PokeMarker pokeMarker = null;
		
		try{
			
			pokeMarker = new PokeMarker(createMarkerOption(pokemon), pokemon, lat, lon, date, time);
			savePokeMarkerOnServer(pokeMarker);
			pokeMarkers.put(pokeMarker.getId(),pokeMarker);
			googleMap.addClusterableMarker(pokeMarker);
			googleMap.addUIEventHandler(pokeMarker, UIEventType.click, new PokeMarkerLeftClickHandler(pokeMarker));
			googleMap.addUIEventHandler(pokeMarker, UIEventType.rightclick, new PokeMarkerRightClickHandler(pokeMarker));
		}catch( Exception error ){
			
			pokeMarker = null;
			throw error;
						
		}
		
		return pokeMarker;
	}
	
	public static MarkerOptions createMarkerOption( Pokemon pokemon ){
		
		MarkerOptions newMarkerOptions = new MarkerOptions();
		newMarkerOptions.position(new LatLong(lat, lon))
		.icon(MarkerImageFactory.createMarkerImage("file:src/main/resources/"+Integer.toString(pokemon.getId())+".png", "png"));
		
		return newMarkerOptions;
	}

	/**
	 * Sauvegarde un PokeMarker dans le serveur
	 * @param pokeMarker Pokemon que l on souhaite sauvegarder
	 */
	private void savePokeMarkerOnServer(PokeMarker pokeMarker){
		
		try{
			//String response = Requests.post("http://127.0.0.1:4567/locations").body(gson.toJson(pokeMarker)).send().readToText();
			//PokeMarker created = gson.fromJson(response, PokeMarker.class);
			throw new ConnectException();
		} catch (ConnectException error){
			//throw error;
		}
		
	}
	
	
	/**
	 * Renvoie le totalite de PokeMarkers se trouvant dans le hashmap
	 * @return Hashmap avec PokeMarkers
	 */
	public final HashMap<Integer, PokeMarker> getPokeMarkers(){
		return pokeMarkers;
	}
	
	/**
	 * Renvoie le nombre de PokeMarkers sauvegardes dans le
	 * @return Taille du hashmap
	 */
	public int getNumberOfMarkers(){
		return pokeMarkers.size();
	}
	
	/**
	 * Supprime un PokeMarker du hashmap
	 * @param pokeMarker PokeMarker que l on souhaite supprimer
	 */
	public void removePokeMarker(PokeMarker pokeMarker){
		pokeMarkers.remove(pokeMarker.getId());
	}
	
	public static void setLatitude( double newLat ){
		lat = newLat;
	}
	
	public static void setLongitude( double newLon ){
		lon = newLon;
		
	}
	
	public static MapOptions createDefaultOptions(){

		MapOptions defaultMapOptions = new MapOptions();
        LatLong defaultMapCenterPosition = new LatLong(defaultLocation[0], defaultLocation[1]);
        defaultMapOptions.center(defaultMapCenterPosition)
                .mapType(MapTypeIdEnum.ROADMAP)
                .mapTypeControl(defaultValue)
                .overviewMapControl(defaultValue)
                .panControl(defaultValue)
                .rotateControl(defaultValue)
                .scaleControl(defaultValue)
                .streetViewControl(defaultValue)
                .zoomControl(defaultValue)
                .zoom(defaultZoom);
        return defaultMapOptions;
	}
	
	public void setVisiblePokeMakers( HashMap<Integer, Integer> pokeMarkersId){
		
		boolean show = true;
		for(int key:pokeMarkers.keySet()){
			if( pokeMarkersId.containsKey(key) ){
				pokeMarkers.get(key).setVisible(show);
			}else{
				pokeMarkers.get(key).setVisible(!show);
			}
		}
		refreshMap();
	}
	
	
	public void refreshMap() {
		int current = googleMap.getZoom();
		googleMap.setZoom(current-1);
		googleMap.setZoom(current);
	}
	
	public int getMapZoom(){
		return googleMap.getZoom();
	}
	
	public void setMapZoom(int newZoom){
		googleMap.setZoom(newZoom);
	}
	
	public void geoLocalisationSetShape(double centerX, double centerY, int radius) {
		
        if (shapeOfGeoLoc != null) {
            this.googleMap.removeMapShape(shapeOfGeoLoc);
        }
        
        CircleOptions newCircleOption = new CircleOptions();
        newCircleOption.center(new LatLong(centerX, centerY))
            .radius(radius)
            .fillColor("#c9d4fc")
            .fillOpacity(0.6)
            .clickable(false)
            .draggable(false)
            .editable(false)
            .strokeColor("#bccbff")
            .strokeWeight(1)
            .strokeOpacity(0.6);
        
        shapeOfGeoLoc = new Circle(newCircleOption);
        this.googleMap.addMapShape(shapeOfGeoLoc);
   }
}
