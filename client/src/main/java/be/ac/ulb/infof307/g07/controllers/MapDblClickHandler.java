package be.ac.ulb.infof307.g07.controllers;

import com.lynden.gmapsfx.javascript.event.GMapMouseEvent;
import com.lynden.gmapsfx.javascript.event.MouseEventHandler;

public class MapDblClickHandler implements MouseEventHandler{

	@Override
	public void handle(GMapMouseEvent mapMouseEvent) {
		
		System.out.println("Map double clicked.");
		// PokeMarkerInfoWindow.createInfoWindow(newPokeMarker);
		
	}

}
