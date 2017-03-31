package be.ac.ulb.infof307.g07.Controllers;

import com.lynden.gmapsfx.javascript.event.UIEventType;
import be.ac.ulb.infof307.g07.Controllers.Handlers.MapMouseDblClickHandler;
import be.ac.ulb.infof307.g07.Models.Map;
import be.ac.ulb.infof307.g07.Views.MapView;

/*
 * 
 * Here, this class is only used to bind the listener with the handler. In fact, this class could implement
 * the UIEventHandler, but because the gmapsFX isn't complete the Interface UIEventHandler has only one 
 * method that can be called when the event happens. So to be able to bind more listeners to different events, we created
 * a class each time for one handler.
 * 
 * @author Fan
 * @version 1.0
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
