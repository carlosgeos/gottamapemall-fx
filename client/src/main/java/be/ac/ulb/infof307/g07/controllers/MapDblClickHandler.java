package be.ac.ulb.infof307.g07.controllers;

import com.lynden.gmapsfx.javascript.event.GMapMouseEvent;
import com.lynden.gmapsfx.javascript.event.MouseEventHandler;

import be.ac.ulb.infof307.g07.models.Map;


public class MapDblClickHandler implements MouseEventHandler{
	
	@Override
	public void handle(GMapMouseEvent mapMouseEvent) {
		
		Map.setLatitude(mapMouseEvent.getLatLong().getLatitude());
		Map.setLongitude(mapMouseEvent.getLatLong().getLongitude());
		PokemonSelectionController.getInstance().initSelection();
	}

}
