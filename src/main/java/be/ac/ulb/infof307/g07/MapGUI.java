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
	
	private GoogleMapView googleMapView;
	private GoogleMap googleMap;
	private String apikey = "AIzaSyA38gCIADhL0JWZbNmPYtsTgGJJWIyXZNI";
	private MapOptions defaultMapOptions;
	private Map map;
	private Coordinate defaultMapCenterPosition;
	
	private BorderPane mapGUI;
	
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
