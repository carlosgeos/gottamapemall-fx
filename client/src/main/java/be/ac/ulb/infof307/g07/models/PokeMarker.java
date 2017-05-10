package be.ac.ulb.infof307.g07.models;

import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;

public class PokeMarker extends Marker{

	private static int idCounter = 1;
	
	private final int id;
	private final double lat;
	private final double lon;
	private final Pokemon assignedPokemon;
	private final String discoveredTime;
	
	public PokeMarker(Pokemon newAssignedPokemon, double newLat, double newLon, String newDiscoveredTime) {
		super(null);
		id = idCounter;
		++idCounter;
		lat = newLat;
		lon = newLon;
		assignedPokemon = newAssignedPokemon;
		discoveredTime = newDiscoveredTime;
		setOptions(createDefaultOption());
	}
	
	public MarkerOptions createDefaultOption(){
		
		MarkerOptions newMarkerOptions = new MarkerOptions();
		
		return newMarkerOptions;
		
	}
	
	
	
}
