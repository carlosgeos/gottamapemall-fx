package be.ac.ulb.infof307.g07;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.event.GMapMouseEvent;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;

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
	
	    mapOptions.center(new LatLong(50.839183, 4.3665867))
        		.mapType(MapTypeIdEnum.ROADMAP)
	            .overviewMapControl(false)
	            .panControl(false)
	            .rotateControl(false)
	            .scaleControl(false)
	            .streetViewControl(false)
	            .zoomControl(false)
	            .zoom(13);
	
	    map = mapview.createMap(mapOptions);

		mapController = new MapController(map);

		map.addMouseEventHandler(UIEventType.click, (GMapMouseEvent event) -> {
			LatLong latLong = event.getLatLong();
			mapController.addMarker(latLong);
		});

	}
	
	public GoogleMapView getView(){
		
		return mapview;
		
	}
	
	public GoogleMap getMap(){
		
		return map;
	
	}
}
