package be.ac.ulb.infof307.g07.controllers;

import be.ac.ulb.infof307.g07.views.MapView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class GoogleMapViewMouseClickHandler implements EventHandler<MouseEvent>{

	private MapView mapView;
	
	public GoogleMapViewMouseClickHandler(MapView newMapView){
		mapView = newMapView;
	}
	
	@Override
	public void handle(MouseEvent event) {
		
    	if( (mapView.getMarkerLayoutMouseX() != MapView.notSet) && (mapView.getMarkerLayoutMouseY() != MapView.notSet)){
    		mapView.fixeMarkerLayoutPosition(event.getX(), event.getY());
    		if( PokeMarkerRightClickHandler.getInstance() != null ){
    			PokeMarkerRightClickHandler.getInstance().show();
    		}
    		mapView.setMarkerLayoutMouseX(MapView.notSet);
    		mapView.setMarkerLayoutMouseY(MapView.notSet);
    	}
		
	}

}
