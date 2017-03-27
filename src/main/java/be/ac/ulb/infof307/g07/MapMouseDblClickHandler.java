package be.ac.ulb.infof307.g07;

import com.lynden.gmapsfx.javascript.event.GMapMouseEvent;
import com.lynden.gmapsfx.javascript.event.MouseEventHandler;

public class MapMouseDblClickHandler implements MouseEventHandler{

	private MapGUI mapGUI;
	private Map map;
	
	MapMouseDblClickHandler( MapGUI mG, Map m){
		
		mapGUI = mG;
		map = m;
	}
	
	
	@Override
	public void handle(GMapMouseEvent event) {
		
		double x = event.getLatLong().getLatitude();
		double y = event.getLatLong().getLongitude();
		Coordinate newPosition = new Coordinate(x,y);
		PokeMarker newPMarker = map.addPokeMarker(newPosition);
		mapGUI.addMarker(newPMarker);
	}
	
	
	
	public void test(){
		
		System.out.println("Test");
		
	}
}
