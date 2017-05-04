package be.ac.ulb.infof307.g07.models;

import be.ac.ulb.infof307.g07.models.Pokemon;
import be.ac.ulb.infof307.g07.models.Pokedex;
import net.dongliu.requests.Requests;
import org.bson.types.ObjectId;
import com.google.gson.Gson;
import be.ac.ulb.infof307.g07.libs.CustomGson;
import java.lang.NullPointerException;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Cette classe represente le modele dans la structure MVC cad la classe contenant les donnees relatives a la carte.
 * Par exemple les epingles (markers) et les informations les concernant.
 * 
 * <p>
 * C est aussi ici qu on cree les objets PokeMarker et Coordinate.
 * Un objet de cette classe est cree par les classes suivantes: MapMouseDblClickHandler et MapController dans leurs constructeurs respectifs.
 * <p>
 * 
 * @version 1.2
 * @see be.ac.ulb.infof307.g07.models.PokeMarker
 * @see be.ac.ulb.infof307.g07.models.Coordinate
 *
 */
public class Map {
	
    private final static Logger LOGGER = Logger.getLogger(Map.class.getName());
    
    private Pokedex pokedex;

    
    public Map () {}

    public Map (Pokedex pokedex) {
        this.pokedex = pokedex;
    }

    /**
     * Sauvegarde et crée un PokeMarker.
     *
     * @param lat La latitude de l'épingle pokemon sur la carte.
     * @param lon La longitude de l'épingle pokemon sur la carte.
     * @param pokemon le pokemon a indiquer sur la carte comme epingle (image et caracteristiques).
     * @param date La date a laquelle le pokemon a ete vu.
     * @param time L'heure a laquelle le pokemon a ete vu.
     * @return une nouvelle epingle pokemon (avec un identifiant unique) sous la forme d un objet PokeMarker, contenant sa position sur la carte.
     *
     * @see be.ac.ulb.infof307.g07.models.PokeMarker
     */
    public PokeMarker addPokeMarker(double lat, double lon, Pokemon pokemon, String date, String time) {
        PokeMarker marker = new PokeMarker(lat, lon, pokemon, date, time);
        try {
            addPokeMarker(marker);
        } catch (NullPointerException e) {
            LOGGER.info("Failed to save the pokemon.");
        }
        return marker;
    }

    /**
     * Sauvegarde une instance de PokeMarker.
     * 
     * @param marker Un PokeMarker qui doit être sauvegardé.
     * 
     * @see Map#addPokeMarker(double, double, Pokemon, String, String)
     * @see be.ac.ulb.infof307.g07.models.PokeMarker
     * @see be.ac.ulb.infof307.g07.models.PokeMarker#getId() 
     * 
     */
    public PokeMarker addPokeMarker(PokeMarker marker) {
        Pokemon pokemon = this.pokedex.getPokemonWithId(marker.getPokemon().getId());
        pokemon.increaseGlobalCounting();
        Gson gson = CustomGson.get();
        String response = Requests.post("http://127.0.0.1:4567/locations").body(gson.toJson(marker)).send().readToText();
        PokeMarker created = gson.fromJson(response, PokeMarker.class);
        return created;
    }
    
    /**
     * Récupère les détails d'un PokeMarker en particulier.
     *
     * @param id Reference vers ce marker.
     * @return Détail du PokeMarker.
     */
    public PokeMarker getPokeMarker(ObjectId id) {
        String response = Requests.get("http://127.0.0.1:4567/locations/" + id.toHexString()).send().readToText();
        Gson gson = CustomGson.get();
        PokeMarker marker = gson.fromJson(response, PokeMarker.class);
        return marker;
    }

    /**
     * Récupère tout les PokeMarker.
     *
     * @return Tout les PokeMarkers.
     */
    public PokeMarker[] getPokeMarkers() {
        String response = Requests.get("http://127.0.0.1:4567/locations").send().readToText();
        Gson gson = CustomGson.get();
        PokeMarker[] markers = gson.fromJson(response, PokeMarker[].class);
        return markers;
    }

    /**
     * Retourne le nombre de markers contenu sur la carte.
     * 
     * @return Nombew de markers sous forme d'un entier.
     */
    public int getNumberOfMarkers() {
        String response = Requests.get("http://127.0.0.1:4567/locations").send().readToText();
        Gson gson = CustomGson.get();
        PokeMarker[] markers = gson.fromJson(response, PokeMarker[].class);
        return markers.length;
    }
    
    /**
     * Retire une epingle pokemon: decremente son compteur de signalisations et fait appel a la methode remove de pokeMarker.
     * 
     * @param pokeMarker l epingle pokemon a supprimer
     */
    public void removePokeMarker(PokeMarker pokeMarker) {
        Pokemon pokemon = this.pokedex.getPokemonWithId(pokeMarker.getPokemon().getId());
        pokemon.decreaseGlobalCounting();
        pokeMarker.remove(); 
    }
}
