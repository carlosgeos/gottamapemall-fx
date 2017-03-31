package be.ac.ulb.infof307.g07.Controllers.Handlers;

import com.lynden.gmapsfx.javascript.event.UIEventHandler;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.InfoWindow;
import com.lynden.gmapsfx.javascript.object.InfoWindowOptions;
import com.lynden.gmapsfx.javascript.object.Marker;

import be.ac.ulb.infof307.g07.Models.PokeMarker;
import netscape.javascript.JSObject;

public class PokeMarkerMouseClickHandler implements UIEventHandler{

	private Marker marker;
	private PokeMarker pokeMarker;
	private GoogleMap googleMap;
	
	public PokeMarkerMouseClickHandler(Marker marker, PokeMarker pokeMarker, GoogleMap googleMap){
		
		this.marker = marker;
		this.pokeMarker = pokeMarker;
		this.googleMap = googleMap;
	}

	@Override
	public void handle(JSObject event) {
		
		System.out.println("UIEventhandler : PokeMarker ID "+Integer.toString(pokeMarker.getId())+" clicked!");
		
		InfoWindowOptions infoWindowOptions = new InfoWindowOptions();
        infoWindowOptions.content("<h2>Marker"+Integer.toString(pokeMarker.getId())+"</h2>");

        InfoWindow pokeMarkerInfoWindow = new InfoWindow(infoWindowOptions);
        pokeMarkerInfoWindow.open(googleMap, marker);
		
	}

}
