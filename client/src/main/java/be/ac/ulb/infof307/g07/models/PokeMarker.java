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
 */
public class PokeMarker extends Marker {
    /**
     * Identifiant unique du PokeMarker.
     */
    private ObjectId id;
    private double lat;
    private double lon;
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
     * Constructeur de copie.
     */
    public PokeMarker(PokeMarker other) {
        super(new MarkerOptions());
        this.date = other.getDate();
        this.time = other.getTime();
        this.pokemon = other.getPokemon();
        LatLong pos = other.getPosition();
        this.lat = pos.getLatitude();
        this.lon = pos.getLongitude();

        this.setOptions(new MarkerOptions().position(pos));
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
        return new LatLong(this.lat, this.lon);
    }

    /**
     */
    @Override
    public void setPosition(LatLong pos) {
        super.setPosition(pos);

        this.lat = pos.getLatitude();
        this.lon = pos.getLongitude();
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
     * Renvoie le pokémon reférencé par le marker.
     *
     * @return Le pokemon reférencé.
     */
    public Pokemon getPokemon() {
        return this.pokemon;
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
