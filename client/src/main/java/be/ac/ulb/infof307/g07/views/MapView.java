package be.ac.ulb.infof307.g07.views;

import com.lynden.gmapsfx.ClusteredGoogleMapView;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.ClusteredGoogleMap;

import be.ac.ulb.infof307.g07.controllers.MapDblClickHandler;
import be.ac.ulb.infof307.g07.controllers.MapRightClickHandler;
import be.ac.ulb.infof307.g07.models.Map;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MapView{
	
	private ClusteredGoogleMapView googleMapView;
	private ClusteredGoogleMap googleMap;
	private Map map; 
	
	public MapView( MapComponentInitializedListener mapInitialized ){
		
		googleMapView = new ClusteredGoogleMapView(null, Map.defaultApiKey);
		googleMapView.addMapInializedListener(mapInitialized);
		googleMapView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){

	            public void handle(MouseEvent e) {
	                 
	            	System.out.println(e.getX());
	            	System.out.println(e.getY());

	             }
		});
	}
	
	public GoogleMapView getView(){
		
		return googleMapView;
	}
	
	public void initMap(){
		
		googleMap = googleMapView.createMap(Map.createDefaultOptions());
		map = new Map(googleMap);
		googleMap.addMouseEventHandler(UIEventType.dblclick, new MapDblClickHandler());
        googleMap.addMouseEventHandler(UIEventType.rightclick, new MapRightClickHandler());
	}
}
