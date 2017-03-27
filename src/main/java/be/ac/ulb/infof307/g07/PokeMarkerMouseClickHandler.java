package be.ac.ulb.infof307.g07;

import com.lynden.gmapsfx.javascript.event.UIEventHandler;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.InfoWindow;

import netscape.javascript.JSObject;

public class PokeMarkerMouseClickHandler implements UIEventHandler{

	private PokeMarker pokeMarker;
	private InfoWindow pokeMarkerInfoWindow;
	private GoogleMap googleMap;
	
	public PokeMarkerMouseClickHandler(PokeMarker pMarker, InfoWindow pMarkerInfoWindow, GoogleMap gMap){
		
		pokeMarker = pMarker;
		pokeMarkerInfoWindow = pMarkerInfoWindow;
		googleMap = gMap;
	}

	@Override
	public void handle(JSObject arg0) {
		// TODO Auto-generated method stub
		pokeMarkerInfoWindow.open(googleMap, pokeMarker);
		
		System.out.println("UIEventhandler : PokeMarker ID "+Integer.toString(pokeMarker.getId())+" clicked!");
		
	}

}
