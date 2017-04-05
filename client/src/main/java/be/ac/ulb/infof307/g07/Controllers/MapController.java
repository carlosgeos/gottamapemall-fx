package be.ac.ulb.infof307.g07.Controllers;

import com.lynden.gmapsfx.javascript.event.UIEventType;
import be.ac.ulb.infof307.g07.Controllers.Handlers.MapMouseDblClickHandler;
import be.ac.ulb.infof307.g07.Models.Map;
import be.ac.ulb.infof307.g07.Views.MapView;

/**
 * 
 * Here, this class is only used to bind the listener with the handler. In fact, this class could implement
 * the UIEventHandler, but because the gmapsFX isn't complete the Interface UIEventHandler has only one 
 * method that can be called when the event happens. So to be able to bind more listeners to different events, we created
 * a class each time for one handler.
 * 
 * <p>
 * An object of this class is created by the class MainGUI, in its method mapInitialized(). 
 * <p>
 * 
 * @author Fan
 * @version 1.0
 * @see be.ac.ulb.infof307.g07.MainGUI
 * @see be.ac.ulb.infof307.g07.Models.Map
 * @see be.ac.ulb.infof307.g07.Views.MapView
 * @see be.ac.ulb.infof307.g07.Controllers.Handlers.MapMouseDblClickHandler
 * 
 */
public class MapController{
	
	
	/**
	 * 
	 * L objet modele de la carte, pour les actions a effectuer sur les donnees.
	 * 
	 * @see be.ac.ulb.infof307.g07.Models.Map
	 */
	private Map pokeMap;
	
	
	/**
	 * L'objet vue de la carte pour les actions a effectuer sur l affichage.
	 * 
	 * @see be.ac.ulb.infof307.g07.Views.MapView
	 */
	private MapView pokeMapView;
	

	/**
     * Constructeur de MapController.
     * <p>
     * Ce constructeur lie le controleur avec la vue et le modele via les objets pokeMap et pokeMapView.
     * Et appelle la methode setListener() qui lie le double clic avec son gestionnaire associe.
     * </p>
     * 
     * @param newPokeMap
     *				 Le modele de la carte, pour les actions a effectuer sur les donnees.
     * @param newPokeMapView
     *               La vue de la carte pour les actions a effectuer sur l affichage.
     * 
     * @see MapController#pokeMap
     * @see MapController#pokeMapView
     * @see MapController#setListener()
     * @see be.ac.ulb.infof307.g07.Models.Map
     * @see be.ac.ulb.infof307.g07.Views.MapView
     */
	public MapController( Map newPokeMap, MapView newPokeMapView){
		
		pokeMap = newPokeMap;
		pokeMapView = newPokeMapView;
		setListener();
	}
	
	/**
	 * 
	 * La methode qui lie le double clic (sur la carte) avec le handler qui s en occupe.
	 * 
	 * @see be.ac.ulb.infof307.g07.Controllers.Handlers.MapMouseDbblClickHandler
	 * @see be.ac.ulb.infof307.g07.Controllers.Handlers.MapMouseDblClickHandler#handle(GMapMouseEvent)
	 * @see MapController#pokeMapView
	 * @see be.ac.ulb.infof307.g07.Views.MapView
	 * @see be.ac.ulb.infof307.g07.Models.Map
	 * 
	 */
	public void setListener(){
		
		// bind the listener with handler which is the event of double clicking on the Map
		pokeMapView.getGoogleMap().addMouseEventHandler(UIEventType.dblclick, new MapMouseDblClickHandler(pokeMapView, pokeMap));
	}

}
