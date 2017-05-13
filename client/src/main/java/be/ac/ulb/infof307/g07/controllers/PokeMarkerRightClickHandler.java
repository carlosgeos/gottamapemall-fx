package be.ac.ulb.infof307.g07.controllers;

import com.lynden.gmapsfx.javascript.event.UIEventHandler;

import be.ac.ulb.infof307.g07.models.PokeMarker;
import be.ac.ulb.infof307.g07.views.MapView;
import be.ac.ulb.infof307.g07.views.PokeMarkerOptionsView;
import netscape.javascript.JSObject;

public class PokeMarkerRightClickHandler implements UIEventHandler{
	
	private PokeMarker concernedPokeMarker;
	
	public PokeMarkerRightClickHandler(PokeMarker newConcernedPokeMarker) {
			
		concernedPokeMarker = newConcernedPokeMarker;
	}

	@Override
	public void handle(JSObject arg0) {
		System.out.println("PokeMarker rightClicked...");
		PokeMarkerOptionsView.getInstance().showView(MapView.getInstance().getLayoutMouseX(), MapView.getInstance().getLayoutMouseY());
		
	}
}
