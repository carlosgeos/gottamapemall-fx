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

public class Map implements MapComponentInitializedListener{ 
	
	private GoogleMapView mapview;
	private GoogleMap map;
	private String apikey = "AIzaSyA38gCIADhL0JWZbNmPYtsTgGJJWIyXZNI";
	
	private MapController mapController;
	
	
	public Map(){
		
		mapview = new GoogleMapView(null, apikey);
		mapview.addMapInializedListener(this);
		
	}


	@Override
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
	
	public GoogleMapView getView(){
		
		return mapview;
		
	}
	
	public GoogleMap getMap(){
		
		return map;
	
	}
	
	public void onClickButton(LatLong posMarker){
		
		mapController.addMarker(posMarker);
		
	}
	
	
}
