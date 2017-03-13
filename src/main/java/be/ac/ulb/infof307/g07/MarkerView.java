package be.ac.ulb.infof307.g07;

import com.lynden.gmapsfx.javascript.object.GoogleMap;

public class MarkerView {
	private GoogleMap map = null;
	
	public MarkerView(){
		
		map = new GoogleMap();
		
	}
	
	public MarkerView(GoogleMap newMap){
	
		map = newMap;
		
	}
	
	public void addMarker(MarkerModel markerModel){
		
		
		map.addMarker(markerModel);
	}
	
	public void refreshMap(){
		int current = map.getZoom();
		map.setZoom(map.getZoom() + 1);
		map.setZoom(current);

	}
	
	
}
