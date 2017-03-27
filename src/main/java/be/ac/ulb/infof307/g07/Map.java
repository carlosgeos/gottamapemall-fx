package be.ac.ulb.infof307.g07;

import java.util.HashMap;

import com.lynden.gmapsfx.javascript.object.MarkerOptions;

public class Map {

	private HashMap<Integer, PokeMarker> pokeMarkers = new HashMap<Integer, PokeMarker>();
	private final MarkerOptions defaultMarkerOptions;
	
	public Map(){
		
		defaultMarkerOptions = new MarkerOptions();
		
	}
	
	public PokeMarker addPokeMarker( Coordinate position  ){
	
		defaultMarkerOptions.position(position);
		PokeMarker newPMarker = new PokeMarker( defaultMarkerOptions );
		addPokeMarker(newPMarker);
		
		return newPMarker;
	}
	
	public void addPokeMarker( PokeMarker newPMarker  ){
		
		pokeMarkers.put(newPMarker.getId(), newPMarker);
		
	}
	
	public void test(){
		
		System.out.println("map test");
		
	}
	
	
}
