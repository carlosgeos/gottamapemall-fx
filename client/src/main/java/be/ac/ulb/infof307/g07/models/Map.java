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
 * Cette classe représente le modèle dans la structure MVC càd la classe contenant les données relatives à la carte.
 * Par exemple les épingles (markers) et les informations les concernant.
 * 
 * <p>
 * C est aussi ici qu'on crée les objets PokeMarkers et Pokedex.
 * Un objet de cette classe est crée par les classes suivantes:  MapView, PokeMarkerRemoveFromMapHandler, PokeMarkerMouseDblClickHandler, OnMapRightClickHandler, onMapDblClickHandler et addNewPokeMarkerHandler,  dans leurs constructeurs respectifs.
 * <p>
 * 
 * @version 1.2
 * @see be.ac.ulb.infof307.g07.models.PokeMarker
 * @see be.ac.ulb.infof307.g07.models.Pokedex
 *
 * @see be.ac.ulb.infof307.g07.views.MapView
 * @see be.ac.ulb.infof307.g07.controllers.Handlers.PokeMarkerRemoveFromMapHandler
 * @see be.ac.ulb.infof307.g07.controllers.Handlers.PokeMarkerMouseDblClickHandler
 * @see be.ac.ulb.infof307.g07.controllers.Handlers.OnMapRightClickHandler 
 * @see be.ac.ulb.infof307.g07.controllers.Handlers.onMapDblClickHandler
 * @see be.ac.ulb.infof307.g07.controllers.Handlers.addNewPokeMarkerHandler
 * 
 */
public class Map {
	
	//TODO: TBD...
	/**
	 * 
	 */
    private final static Logger LOGGER = Logger.getLogger(Map.class.getName());
    
    /**
     * l'objet modèle pour le pokedex
     * 
     * @see be.ac.ulb.infof307.g07.models.Pokedex
     */
    private Pokedex pokedex;

    //TODO: utilisé ? -> si oui ok et dire dans doc? sinon supprimer?
    /**
     * 
     */
    public Map () {}
    
    /**
     * Constructeur de Map
     * 
     * @param pokedex l'objet modèle pour le pokedex
     * @see be.ac.ulb.infof307.g07.models.Pokedex
     * 
     */
    public Map (Pokedex pokedex) {
        this.pokedex = pokedex;
    }

    /**
     * Sauvegarde et crée un PokeMarker.
     *
     * @param lat La latitude de l'épingle pokemon sur la carte.
     * @param lon La longitude de l'épingle pokemon sur la carte.
     * @param pokemon le pokemon à indiquer sur la carte comme épingle (image et caractéristiques).
     * @param date La date à laquelle le pokemon a été vu.
     * @param time L'heure à laquelle le pokemon a été vu.
     * @return une nouvelle épingle pokemon (avec un identifiant unique) sous la forme d'un objet PokeMarker, contenant sa position sur la carte.
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
     * @see be.ac.ulb.infof307.g07.models.Pokedex
     * @see be.ac.ulb.infof307.g07.models.PokeMarker
     * @see be.ac.ulb.infof307.g07.models.Pokedex#getPokemonWithId(int)
     * @see be.ac.ulb.infof307.g07.models.PokeMarker#getPokemon()
     * @see be.ac.ulb.infof307.g07.models.PokeMarker#getId() 
     * @see be.ac.ulb.infof307.g07.models.Pokemon
     * @see be.ac.ulb.infof307.g07.models.Pokemon#increaseGlobalCounting()
     * @see be.ac.ulb.infof307.g07.libs.CustomGson
     * 
     * @see Map#addPokeMarker(double, double, Pokemon, String, String)
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
     * @param id Référence vers ce marker.
     * @return Détails du PokeMarker.
     * 
     * @see be.ac.ulb.infof307.g07.models.PokeMarker
     * @see be.ac.ulb.infof307.g07.libs.CustomGson
     * 
     */
    public PokeMarker getPokeMarker(ObjectId id) {
        String response = Requests.get("http://127.0.0.1:4567/locations/" + id.toHexString()).send().readToText();
        Gson gson = CustomGson.get();
        PokeMarker marker = gson.fromJson(response, PokeMarker.class);
        return marker;
    }

    /**
     * Récupère tous les PokeMarker.
     *
     * @return Tous les PokeMarkers.
     * 
     * @see be.ac.ulb.infof307.g07.models.PokeMarker
     * @see be.ac.ulb.infof307.g07.libs.CustomGson
     */
    public PokeMarker[] getPokeMarkers() {
        String response = Requests.get("http://127.0.0.1:4567/locations").send().readToText();
        Gson gson = CustomGson.get();
        PokeMarker[] markers = gson.fromJson(response, PokeMarker[].class);
        return markers;
    }

    /**
     * Retourne le nombre de markers présents sur la carte.
     * 
     * @return Nombre de markers sur la carte, sous forme d'un entier.
     * 
     * @see be.ac.ulb.infof307.g07.models.PokeMarker
     * @see be.ac.ulb.infof307.g07.libs.CustomGson
     */
    public int getNumberOfMarkers() {
        String response = Requests.get("http://127.0.0.1:4567/locations").send().readToText();
        Gson gson = CustomGson.get();
        PokeMarker[] markers = gson.fromJson(response, PokeMarker[].class);
        return markers.length;
    }
    
    /**
     * Retire une épingle pokemon: décrémente son compteur de signalisations et fait appel à la méthode remove de pokeMarker.
     * 
     * @param pokeMarker l'épingle pokemon à supprimer
     * 
     * @see be.ac.ulb.infof307.g07.models.PokeMarker
     * @see be.ac.ulb.infof307.g07.models.PokeMarker#remove()
     */
    public void removePokeMarker(PokeMarker pokeMarker) {
        Pokemon pokemon = this.pokedex.getPokemonWithId(pokeMarker.getPokemon().getId());
        pokemon.decreaseGlobalCounting();
        pokeMarker.remove(); 
    }
}
