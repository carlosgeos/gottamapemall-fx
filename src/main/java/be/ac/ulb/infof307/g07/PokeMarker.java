package be.ac.ulb.infof307.g07;

import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;

public class PokeMarker extends Marker{
	
	private static int idIncrement = 0;
	private final int id;
	
	public PokeMarker(MarkerOptions markerOptions) {
		super(markerOptions);
		idIncrement += 1;
		id = idIncrement;
		
	}
	
	public final int getId(){
		
		return id;
		
	}	
	
}
