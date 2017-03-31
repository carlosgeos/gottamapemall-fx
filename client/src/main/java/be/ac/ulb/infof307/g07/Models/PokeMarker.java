package be.ac.ulb.infof307.g07.Models;


public class PokeMarker{
	
	private static int idIncrement = 0;
	private final int uniqueId;
	private Coordinate onMapPosition;
	
	
	public PokeMarker( Coordinate newPosition) {
		idIncrement += 1;
		uniqueId = idIncrement;
		onMapPosition = newPosition;
		
	}
	
	public final int getId(){
		
		return uniqueId;
		
	}
	
	public Coordinate getOnMapPosition(){
		
		return onMapPosition;
	}
	
}
