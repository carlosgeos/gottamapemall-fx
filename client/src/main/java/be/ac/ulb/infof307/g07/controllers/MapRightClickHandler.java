package be.ac.ulb.infof307.g07.controllers;

import java.util.HashMap;

import com.lynden.gmapsfx.javascript.event.GMapMouseEvent;
import com.lynden.gmapsfx.javascript.event.MouseEventHandler;

import be.ac.ulb.infof307.g07.models.GeoLocaLisation;
import be.ac.ulb.infof307.g07.models.Map;

public class MapRightClickHandler implements MouseEventHandler {

	private Map map;
	
	public MapRightClickHandler(Map newMap){
		map = newMap;
	}
	
	@Override
	public void handle(GMapMouseEvent event) {
		HashMap<Integer,Integer> pokemonTobeShown = GeoLocaLisation.pokemonsAroundMe(map.getPokeMarkers(), GeoLocaLisation.radius, event.getLatLong().getLatitude(), event.getLatLong().getLongitude());
		map.setVisiblePokeMakers(pokemonTobeShown);
		map.geoLocalisationSetShape(event.getLatLong().getLatitude(), event.getLatLong().getLongitude(), GeoLocaLisation.radius);
		map.refreshMap(1);
	}

	
	
}
