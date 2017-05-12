package be.ac.ulb.infof307.g07.models;

import org.bson.types.ObjectId;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import be.ac.ulb.infof307.g07.models.Pokemon;

import com.lynden.gmapsfx.javascript.event.GMapMouseEvent;

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
 * @see be.ac.ulb.infof307.g07.models.Map
 * @see be.ac.ulb.infof307.g07.models.Map#addPokeMarker(double, double, Pokemon, String, String)
 * @see be.ac.ulb.infof307.g07.controllers.Handlers.PokeMarkerMouseDblClickHandler
 * @see be.ac.ulb.infof307.g07.controllers.Handlers.PokeMarkerRemoveFromMapHandler
 * @see be.ac.ulb.infof307.g07.controllers.Handlers.PokeMarkerMouseClickHandler
 * @see be.ac.ulb.infof307.g07.controllers.Handlers.PokeMarkerMouseClickHandler#PokeMarkerMouseClickHandler(Marker, PokeMarker, GoogleMap)
 * @see be.ac.ulb.infof307.g07.models.Coordinate
 */
public class PokeMarker extends Marker {
    /**
     * Identifiant unique du PokeMarker.
     */
    private ObjectId id;
    private LatLong coord;

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
     * @param lat Latitude de l'épingle pokemon sur la carte.
     * @param lon Longitude de l'épingle pokemon sur la carte.
     * @param pokemon Pokemon réfèrencé par le marker sur la carte.
     * @param date Date où le pokémon a été repéré.
     * @param time Heures à laquelle le pokemon a été repéré.
     */
    public PokeMarker(MarkerOptions markerOptions, Pokemon pokemon, String date, String time) {
        super(markerOptions);
        this.date = date;
        this.time = time;
        this.pokemon = pokemon;
    }

    /**
     * Retourne l identifiant unique de l epingle pokemon.
     *
     * @return L'identifiant unique de l epingle pokemon, sous forme d un entier constant.
     */
    public final ObjectId getId() {
        return this.id;
    }

    /**
     * Renvoie la position sur la carte de l epingle.
     *
     * @return La position sur la carte de l epingle, sous forme d un objet Coordinate.
     *
     * @see be.ac.ulb.infof307.g07.models.Coordinate
     *
     */
    public LatLong getPosition() {
        return this.coord;
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

    /**
     * Renvoie l'icone du pokémon reférencé par le marker.
     *
     * @return Chemin pour récupérer l'icone.
     */
    // public String getIcon() {
    //     return this.icon();
    // }

    /**
     * Renvoie l'id du pokémon reférencé par le marker.
     *
     * @return L'id du pokemon reférencé.
     */
    public int getPokemonId() {
        return this.pokemon.getId();
    }

    /**
     * Renvoie la date à laquelle le pokémon reférencé par le marker a été aperçu.
     *
     * @return La date.
     */
    public String getDate() {
        return this.date;
    }

    /**
     * Renvoie l'heure à laquelle le pokémon reférencé par le marker a été aperçu.
     *
     * @return L'heure.
     */
    public String getTime() {
        return this.time;
    }

    /**
     *
     */
    public void remove () {

    }
}
