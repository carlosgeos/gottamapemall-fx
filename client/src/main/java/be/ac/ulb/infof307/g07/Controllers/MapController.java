package be.ac.ulb.infof307.g07.Controllers;

import com.lynden.gmapsfx.javascript.event.UIEventType;
import be.ac.ulb.infof307.g07.Controllers.Handlers.MapMouseDblClickHandler;
import be.ac.ulb.infof307.g07.Models.Map;
import be.ac.ulb.infof307.g07.Views.MapView;

/*
 * author : Fan
 * 
 * 
 * Description: Here, this class is only used to bind the listener with the handler. In fact, this class could implement
 * 				the UIEventHandler, but because of the gmapsFX isn't complete so that the Interface UIEventHandler has only one 
 * 				method can be called when the event happens. So to be able to bind more listener to different event, we created
 * 				a class each time for one handler.
 * 
 */

public class MapController{
	
	private Map pokeMap;
	private MapView pokeMapView;
	
	public MapController( Map newPokeMap, MapView newPokeMapView){
		
		pokeMap = newPokeMap;
		pokeMapView = newPokeMapView;
		setListener();
	}
	
	
	public void setListener(){
		
		// bind the listener with handler which is the event of double clicking on the Map
		pokeMapView.getGoogleMap().addMouseEventHandler(UIEventType.dblclick, new MapMouseDblClickHandler(pokeMapView, pokeMap));
	}

}
