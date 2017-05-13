package be.ac.ulb.infof307.g07.views;

import com.lynden.gmapsfx.ClusteredGoogleMapView;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.ClusteredGoogleMap;

import be.ac.ulb.infof307.g07.models.Map;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MapView{
	
	private ClusteredGoogleMapView googleMapView;
	private static MapView instance = null;
	private double layoutMouseX;
	private double layoutMouseY;
	
	public MapView( MapComponentInitializedListener mapInitialized ){
		
		googleMapView = new ClusteredGoogleMapView(null, Map.defaultApiKey);
		googleMapView.getChildren().add(PokeMarkerOptionsView.getInstance().getView());
		googleMapView.addMapInializedListener(mapInitialized);
		googleMapView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
	            public void handle(MouseEvent event) {
	            	layoutMouseX = event.getX();
	            	layoutMouseY = event.getY();
	             }
		});
		instance = this;
	}
	
	public static MapView getInstance(){
		
		return instance;
	}
	
	public final double getLayoutMouseX(){
		return layoutMouseX;
	}
	
	public final double getLayoutMouseY(){
		return layoutMouseY;
	}
	
	public GoogleMapView getView(){
		
		return googleMapView;
	}
	
	public ClusteredGoogleMap createMap(){
		return googleMapView.createMap(Map.createDefaultOptions());
	}
}
