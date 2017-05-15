package be.ac.ulb.infof307.g07.models;

import com.lynden.gmapsfx.javascript.object.InfoWindow;
import com.lynden.gmapsfx.javascript.object.InfoWindowOptions;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;

/**
 * Cette classe herite de la classe Marker du API GMapFX et elle sert a stocker l information supplementaire.
 * 
 */
public class PokeMarker extends Marker{
	
	private static int idCounter = 1;
	private final int id;
	private final double lat;
	private final double lon;
	private final Pokemon assignedPokemon;
	private String discoveredDate;
	private String discoveredTime;
	private InfoWindow infoWindow;
	
	/**
	 * Le constructeur de la classe PokeMarker.
	 * 
	 * @param newAssignedPokemon une reference vers l objet Pokemon
	 * @param newLat Latitude du Marker sur le Map
	 * @param newLon Longitude du Marker sur le Map
	 * @param newDiscoveredTime le timestamp de l ajout du Marker dans le Map
	 */
	public PokeMarker(MarkerOptions options, Pokemon newAssignedPokemon, double newLat, double newLon, String newDiscoveredDate, String newDiscoveredTime) {
		super(options);
		id = idCounter;
		++idCounter;
		lat = newLat;
		lon = newLon;
		assignedPokemon = newAssignedPokemon;
		discoveredTime = newDiscoveredTime;
		discoveredDate = newDiscoveredDate;
		createInfoWindow();
	}
	
	/**
	 * Cette classe construit un text HTML et le renvoie. Ce texte est utilise dans le GoogleMapView.
	 * 
	 * @return un texte HTML
	 */
	public String getHTML(){
		String output = "<div><table>"
                + "<tr><td colspane=2 align=\"center\"><img src=\""+assignedPokemon.getId()+".gif\" alt=\""+assignedPokemon.getName()+"\" style=\"\"></td></tr>"
                + "<tr><td>Id : </td><td>"+assignedPokemon.getId()+"</td></tr>"
                + "<tr><td>Name : </td><td>"+assignedPokemon.getName()+"</td></tr>"
                + "<tr><td>Creation : </td><td>"+discoveredDate+"</td><td>"+discoveredTime+"h</td></tr>"
                + "</table></div>";
        return output;
	}
	
	/**
	 * Retourne l id unique du Pokemon.
	 * 
	 * @return l id unique du Pokemon
	 */
	public final int getId(){
		return id;
	}
	
	/**
	 * Retourne Latitude du Marker.
	 *  
	 * @return Latitude du Marker
	 */
	public final double getLat(){
		return lat;
	}
	
	/**
	 * Retourne Longitude du Marker
	 * 
	 * @return Longitude du Marker
	 */
	public final double getLon(){
		return lon;
	}
	
	public void createInfoWindow(){
		InfoWindowOptions infoWindowOptions = new InfoWindowOptions();
		infoWindowOptions.content(getHTML());
		infoWindow = new InfoWindow(infoWindowOptions);
	}
	
	public void openWindow(){
		infoWindow.open(Map.getInstance().getGoogleMap(), this);
	}
	
	public void closeWindow(){
		infoWindow.close();
	}
	
	public Pokemon getAssignedPokemon(){
		return assignedPokemon;
	}
	
}
