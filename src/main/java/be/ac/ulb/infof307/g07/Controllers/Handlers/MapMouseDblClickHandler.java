package be.ac.ulb.infof307.g07.Controllers.Handlers;

import com.lynden.gmapsfx.javascript.event.GMapMouseEvent;
import com.lynden.gmapsfx.javascript.event.MouseEventHandler;

import be.ac.ulb.infof307.g07.Models.Coordinate;
import be.ac.ulb.infof307.g07.Models.Map;
import be.ac.ulb.infof307.g07.Models.PokeMarker;
import be.ac.ulb.infof307.g07.Views.MapView;

public class MapMouseDblClickHandler implements MouseEventHandler{

	private MapView pokeMapView;
	private Map pokeMap;
	
	public MapMouseDblClickHandler( MapView newPokeMapView, Map newPokeMap){
		
		pokeMapView = newPokeMapView;
		pokeMap = newPokeMap;
	}
	
	@Override
	public void handle(GMapMouseEvent event) {
		
		// instance the current mouse location as coordinate object
		double x = event.getLatLong().getLatitude();
		double y = event.getLatLong().getLongitude();
		Coordinate newPosition = new Coordinate(x,y);
		
		// add it first in the model map
		PokeMarker newPMarker = pokeMap.addPokeMarker(newPosition);
		// then add it in the view map
		pokeMapView.addMarker(newPMarker);
	}
	
	
	
}
