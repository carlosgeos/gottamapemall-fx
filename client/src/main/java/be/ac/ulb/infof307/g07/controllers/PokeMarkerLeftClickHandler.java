package be.ac.ulb.infof307.g07.controllers;

import com.lynden.gmapsfx.javascript.event.UIEventHandler;
import be.ac.ulb.infof307.g07.models.PokeMarker;
import netscape.javascript.JSObject;

/**
 * Un click sur le Marker, cette handler sera appele pour afficher la fenetre d info sur le map.
 *
 */
public class PokeMarkerLeftClickHandler implements UIEventHandler{
	
	private PokeMarker pokeMarker;
	/**
	 * Le constructeur de PokeMarkerLeftClickHandler
	 * 
	 * @param concernedPokeMarker reference du Marker concerne
	 */
	public PokeMarkerLeftClickHandler( PokeMarker concernedPokeMarker ){
		pokeMarker = concernedPokeMarker;
	}

	/**
	 * La methode qui sera appele apres un click sur le Marker. Cette methode est override et le parametre ne sera pas utilise.
	 * 
	 */
	@Override
	public void handle(JSObject obj) {
		
		pokeMarker.openWindow();
		
	}
}
