package be.ac.ulb.infof307.g07;

import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;

public class MarkerModel extends Marker{
	
	public static int markerCounter = 0;
	
	private int markerId = -1;
	
	
	public MarkerModel(MarkerOptions markerOptions) {
		super(markerOptions);
		
		markerId = markerCounter;
		MarkerModel.markerCounter += 1;
	
	}
	
	public int getId(){
		return markerId;
	}
}
