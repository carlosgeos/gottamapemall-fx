package be.ac.ulb.infof307.g07.Models;

import com.lynden.gmapsfx.javascript.event.GMapMouseEvent;
import org.bson.types.ObjectId;

/**
 * 
 * Cette classe contient les donnees relatives a une epingle pokemon, a savoir son identifiant unique et sa position sur la carte.
 * 
 * <p>
 * Un objet de cette classe est cree par les classes Map, MapMouseDblClickHandler, et PokeMarkerMouseClickHandler.
 * <p>
 * 
 * @version 1.0
 * 
 * @see be.ac.ulb.infof307.g07.Models.Map
 * @see be.ac.ulb.infof307.g07.Models.Map#addPokeMarker(Coordinate, Pokemon, String, String)
 * @see be.ac.ulb.infof307.g07.Controllers.Handlers.PokeMarkerMouseDblClickHandler
 * @see be.ac.ulb.infof307.g07.Controllers.Handlers.PokeMarkerRemoveFromMapHandler
 * @see be.ac.ulb.infof307.g07.Controllers.Handlers.PokeMarkerMouseClickHandler
 * @see be.ac.ulb.infof307.g07.Controllers.Handlers.PokeMarkerMouseClickHandler#PokeMarkerMouseClickHandler(Marker, PokeMarker, GoogleMap)
 * @see be.ac.ulb.infof307.g07.Models.Coordinate
 */
public class PokeMarker {
    private ObjectId id;
    
    /**
     * La latitude sur la carte de l'épingle.
     */
    double lat;
    /**
     * La longitude sur la carte de l'épingle.
     */
    double lon;
    /**
     * Réfèrence vers le pokémon sauvegardé.
     */
    private Pokemon pokemon;
    /**
     * Date de la sauvegarde
     */
    private String date;
    /**
     * Heure de la sauvegarde
     */
    private String time;
    
    /**
     * Le constructeur de PokeMarker.
     * Il est appele par les classes Map, PokeMarkerMouseDblClickHandler, PokeMarkerMouseClickHandler et PokeMarkerRemoveFromMapHandler.
     * 
     * @param newPosition
     *                       La position de l epingle pokemon sur la carte.
     * 
     * @see be.ac.ulb.infof307.g07.Models.Map
     * @see be.ac.ulb.infof307.g07.Models.Map#addPokeMarker(Coordinate, Pokemon, String, String)
     * @see be.ac.ulb.infof307.g07.Controllers.Handlers.PokeMarkerMouseClickHandler
     * @see be.ac.ulb.infof307.g07.Controllers.Handlers.PokeMarkerMouseClickHandler#PokeMarkerMouseClickHandler(Marker, PokeMarker, GoogleMap)
     * @see be.ac.ulb.infof307.g07.Models.Coordinate
     * @see be.ac.ulb.infof307.g07.Controllers.Handlers.PokeMarkerMouseDblClickHandler
     * @see be.ac.ulb.infof307.g07.Controllers.Handlers.PokeMarkerRemoveFromMapHandler
     * 
     */
    public PokeMarker(double lat, double lon, Pokemon pokemon, String date, String time) {
        this.lat = lat;
        this.lon = lon;
        this.date = date;
        this.time = time;
        this.pokemon = pokemon;
    }
    
    /**
     * Retourne l identifiant unique de l epingle pokemon.
     * 
     * @return L'identifiant unique de l epingle pokemon, sous forme d un entier constant.
     * 
     */
    public final ObjectId getId() {
        return this.id;
    }
    
    /**
     * Renvoie la position sur la carte de l epingle.
     * 
     * @return
     *             la position sur la carte de l epingle, sous forme d un objet Coordinate.
     * 
     * @see be.ac.ulb.infof307.g07.Models.Coordinate
     * 
     */
    public Coordinate getOnMapPosition() {
        return new Coordinate(this.lat, this.lon);
    }
    
    public String getString() {
        String res = "<div><table>"
                + "<tr><td colspane=2 align=\"center\"><img src=\""+pokemon.getImagePath()+"\" alt=\""+pokemon.getName()+"\" style=\"\"></td></tr>"
                + "<tr><td>Id : </td><td>"+pokemon.getId()+"</td></tr>"
                + "<tr><td>Name : </td><td>"+pokemon.getName()+"</td></tr>"
                + "<tr><td>Creation : </td><td>"+date+" "+time+"h</td></tr>"
                + "</table></div>";
        return res;
    }
    
    public String getIcon() {
        return pokemon.getImagePath();
    }
    
    public Pokemon getPokemon() {
        return this.pokemon;
    }
    
    public String getDate() {
        return this.date;
    }
    
    public String getTime() {
        return this.time;
    }
    
    public void setDate(String newDate) {
        this.date = newDate;
    }
    
    public void setTime(String newTime) {
        this.time = newTime;
    }
}
