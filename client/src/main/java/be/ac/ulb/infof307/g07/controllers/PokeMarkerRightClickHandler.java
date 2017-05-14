package be.ac.ulb.infof307.g07.controllers;

import com.lynden.gmapsfx.javascript.event.UIEventHandler;

import be.ac.ulb.infof307.g07.models.PokeMarker;
import be.ac.ulb.infof307.g07.views.MapView;
import be.ac.ulb.infof307.g07.views.PokeMarkerOptionsView;
import netscape.javascript.JSObject;

public class PokeMarkerRightClickHandler implements UIEventHandler{
	
	private PokeMarker concernedPokeMarker;
	
	private static PokeMarkerRightClickHandler instance = null;
	
	public PokeMarkerRightClickHandler(PokeMarker newConcernedPokeMarker) {
			
		concernedPokeMarker = newConcernedPokeMarker;
		instance = this;
	}
	
	public static PokeMarkerRightClickHandler getInstance(){
	
		return instance;
	}
	
	public void show(){
		
		PokeMarkerOptionsView.getInstance().showView();
	}
	
	public void close(){
		
		PokeMarkerOptionsView.getInstance().closeView();
	}

	@Override
	public void handle(JSObject arg0) {
		// we set it x and y value to a bigger value than -1, to indicate that
		// it has user clicked on the Marker so that the correspondant class can know it
		MapView.getInstance().setMarkerLayoutMouseX(1);
		MapView.getInstance().setMarkerLayoutMouseY(1);
	}
}
