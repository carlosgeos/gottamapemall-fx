package be.ac.ulb.infof307.g07.Models;

import java.util.HashMap;

public class Map {

	private HashMap<Integer, PokeMarker> pokeMarkers = new HashMap<Integer, PokeMarker>();

	 /**
     * Cette classe représente le model dans la structure MVC. Ainsi pour stocker les marqueurs
     * 
     * <p>
     * On cree on objet MarkerOptions (defaultMarkerOptions) de gmapsfx.
     * </p>
     *
     *
     */
	public Map(){
		
	}
	
	public PokeMarker addPokeMarker( double x, double y){
		
		Coordinate position = new Coordinate(x,y);
		
		return addPokeMarker(position);
		
	}

	public PokeMarker addPokeMarker( Coordinate position  ){
		
		PokeMarker newPMarker = new PokeMarker( position );
		addPokeMarker(newPMarker);
		return newPMarker;
	}

	public void addPokeMarker( PokeMarker newPMarker  ){

		pokeMarkers.put(newPMarker.getId(), newPMarker);

	}
	
	public int getNumberMarker(){
		
		return pokeMarkers.size();
	}

}
