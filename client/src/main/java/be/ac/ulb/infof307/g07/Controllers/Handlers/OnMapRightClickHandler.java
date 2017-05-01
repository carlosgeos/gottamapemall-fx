package be.ac.ulb.infof307.g07.Controllers.Handlers;

import java.util.ArrayList;
import java.util.HashMap;

import com.lynden.gmapsfx.javascript.event.GMapMouseEvent;
import com.lynden.gmapsfx.javascript.event.MouseEventHandler;

import be.ac.ulb.infof307.g07.Models.Coordinate;
import be.ac.ulb.infof307.g07.Models.GeoLocaLisation;
import be.ac.ulb.infof307.g07.Models.Map;
import be.ac.ulb.infof307.g07.Views.MapView;

public class OnMapRightClickHandler implements MouseEventHandler{
	
	
	private Map pokeMap;
	private MapView pokeMapView;
	
	public OnMapRightClickHandler(Map pokeMap, MapView pokeMapView){
		
		this.pokeMap = pokeMap;
		this.pokeMapView = pokeMapView;
	}
	@Override
	public void handle(GMapMouseEvent event) {
		
		Coordinate myPosition = new Coordinate(event.getLatLong().getLatitude(), event.getLatLong().getLongitude());
		HashMap<Integer,Integer> tempMarkerList = GeoLocaLisation.pokemonsAroundMe(pokeMap.getPokeMarkers(), GeoLocaLisation.radius, myPosition);
		pokeMapView.geoLocalisationSetMarkers(tempMarkerList);
		pokeMapView.geoLocalisationSetShape(myPosition, GeoLocaLisation.radius);
		
	}
	
	
	
}
