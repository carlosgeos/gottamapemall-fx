package be.ac.ulb.infof307.g07.models;

import com.lynden.gmapsfx.javascript.event.GMapMouseEvent;
import org.bson.types.ObjectId;

/**
 * 
 * Cette classe contient les donneés relatives à une épingle pokemon, à savoir son identifiant unique et sa position sur la carte.
 * 
 * <p>
 * Un objet de cette classe est créé par les classes suivantes:  addNewPokeMarkerHandler (méthode onConfirm() ), PokeMarkerMouseClickHandler, PokeMarkerMouseDblClickHandler, 
 * PokeMarkerRemoveFromMapHandler et Map (plusieurs méthodes).
 * <p>
 * 
 * @version 1.1
 * 
 * 
 * @see be.ac.ulb.infof307.g07.controllers.Handlers.addNewPokeMarkerHandler
 * @see be.ac.ulb.infof307.g07.controllers.Handlers.addNewPokeMarkerHandler#onConfirm(Pokemon, String, String)
 * @see be.ac.ulb.infof307.g07.controllers.Handlers.PokeMarkerMouseClickHandler
 * @see be.ac.ulb.infof307.g07.controllers.Handlers.PokeMarkerMouseDblClickHandler
 * @see be.ac.ulb.infof307.g07.controllers.Handlers.PokeMarkerRemoveFromMapHandler
 * @see be.ac.ulb.infof307.g07.models.Map
 * @see be.ac.ulb.infof307.g07.models.Map#addPokeMarker(double, double, Pokemon, String, String)
 * @see be.ac.ulb.infof307.g07.controllers.Handlers.PokeMarkerMouseClickHandler#PokeMarkerMouseClickHandler(Marker, PokeMarker, GoogleMap)
 * 
 * @see be.ac.ulb.infof307.g07.models.Coordinate
 * @see be.ac.ulb.infof307.g07.models.Pokemon
 */
public class PokeMarker {
	
    /**
     * Identifiant unique du PokeMarker.
     */
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
     * Référence vers le pokémon sauvegardé.
     * 
     * @see be.ac.ulb.infof307.g07.models.Pokemon
     */
    private Pokemon pokemon;
    
    /**
     * Date de la sauvegarde du pokemon (= date de son repérage)
     */
    private String date;
    
    /**
     * Heure de la sauvegarde du pokemon (= heure de son repérage)
     */
    private String time;
    
    /**
     * Le constructeur de PokeMarker.
     * 
     * @param lat Latitude de l'épingle pokemon sur la carte.
     * @param lon Longitude de l'épingle pokemon sur la carte.
     * @param pokemon Pokemon référencé par le marker sur la carte.
     * @param date Date où le pokémon a été repéré.
     * @param time Heure à laquelle le pokemon a été repéré.
     * 
     * @see be.ac.ulb.infof307.g07.models.Map
     * @see be.ac.ulb.infof307.g07.models.Map#addPokeMarker(double, double, Pokemon, String, String)
     * @see be.ac.ulb.infof307.g07.controllers.Handlers.PokeMarkerMouseClickHandler
     * @see be.ac.ulb.infof307.g07.controllers.Handlers.PokeMarkerMouseClickHandler#PokeMarkerMouseClickHandler(Marker, PokeMarker, GoogleMap)
     * @see be.ac.ulb.infof307.g07.controllers.Handlers.PokeMarkerMouseDblClickHandler
     * @see be.ac.ulb.infof307.g07.controllers.Handlers.PokeMarkerRemoveFromMapHandler
     * @see be.ac.ulb.infof307.g07.models.Pokemon
     */
    public PokeMarker(double lat, double lon, Pokemon pokemon, String date, String time) {
        this.lat = lat;
        this.lon = lon;
        this.date = date;
        this.time = time;
        this.pokemon = pokemon;
    }
    
    /**
     * Retourne l'identifiant unique de l'épingle pokemon.
     * 
     * @return L'identifiant unique de l'épingle pokemon, sous forme d'un entier constant.
     */
    public final ObjectId getId() {
        return this.id;
    }
    
    /**
     * Renvoie la position sur la carte de l'épingle.
     * 
     * @return La position sur la carte de l'épingle, sous forme d'un objet Coordinate.
     * 
     * @see be.ac.ulb.infof307.g07.models.Coordinate
     * 
     */
    public Coordinate getOnMapPosition() {
        return new Coordinate(this.lat, this.lon);
    }
    
    //TODO: TBD...
    /**
     * 
     * @return les informations d'une épingle pokemon sous forme d'une chaine html?
     */
    public String getString() {
        String res = "<div><table>"
                + "<tr><td colspane=2 align=\"center\"><img src=\""+pokemon.getImagePath()+"\" alt=\""+pokemon.getName()+"\" style=\"\"></td></tr>"
                + "<tr><td>Id : </td><td>"+pokemon.getId()+"</td></tr>"
                + "<tr><td>Name : </td><td>"+pokemon.getName()+"</td></tr>"
                + "<tr><td>Creation : </td><td>"+date+" "+time+"h</td></tr>"
                + "</table></div>";
        return res;
    }
    
    /**
     * Renvoie l'icône (l'image) du pokémon référencé par le marker.
     *
     * @return Le chemin pour récupérer l'image du pokémon.
     */
    public String getIcon() {
        return pokemon.getImagePath();
    }
    
    /**
     * Renvoie le pokémon reférencé par le marker.
     *
     * @return Le pokemon reférencé.
     * @see be.ac.ulb.infof307.g07.models.Pokemon
     */
    public Pokemon getPokemon() {
        return this.pokemon;
    }

    /**
     * Renvoie l'id du pokémon reférencé par le marker.
     *
     * @return L'id du pokemon reférencé.
     * @see be.ac.ulb.infof307.g07.models.Pokemon
     * @see be.ac.ulb.infof307.g07.models.Pokemon#getId()
     */
    public int getPokemonId() {
        return this.pokemon.getId();
    }
 
    
    /**
     * Renvoie la date à laquelle le pokémon référencé par le marker a été aperçu.
     *
     * @return La date de signalisation du pokémon.
     */
    public String getDate() {
        return this.date;
    }
    
    /**
     * Renvoie l'heure à laquelle le pokémon reférencé par le marker a été aperçu.
     *
     * @return L'heure du repérage du pokémon.
     */
    public String getTime() {
        return this.time;
    }
    
    /**
     * Modifie la date où le pokémon a été aperçu.
     *
     * @param newDate La nouvelle date.
     */
    public void setDate(String newDate) {
        this.date = newDate;
    }
    
    /**
     * Modifie l'heure où le pokémon a été aperçu.
     *
     * @param newTime La nouvelle heure.
     */
    public void setTime(String newTime) {
        this.time = newTime;
    }

    //TODO: TBD... ?
    /**
     * 
     */
    public void remove () {
    
    }
}
