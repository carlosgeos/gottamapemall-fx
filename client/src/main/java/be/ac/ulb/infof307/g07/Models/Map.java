package be.ac.ulb.infof307.g07.Models;

import net.dongliu.requests.Requests;
import org.bson.types.ObjectId;
import com.google.gson.Gson;
import be.ac.ulb.infof307.g07.libs.CustomGson;
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
 * @see be.ac.ulb.infof307.g07.Models.PokeMarker
 * @see be.ac.ulb.infof307.g07.Models.Coordinate
 *
 */
public class Map {
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
     * @see be.ac.ulb.infof307.g07.Models.PokeMarker
     */
    public PokeMarker addPokeMarker(double lat, double lon, Pokemon pokemon, String date, String time) {
        PokeMarker marker = new PokeMarker(lat, lon, pokemon, date, time);
        addPokeMarker(marker);
        return marker;
    }

    /**
     * Sauvegarde une instance de PokeMarker.
     * 
     * @param marker Un PokeMarker qui doit être sauvegardé.
     * 
     * @see Map#addPokeMarker(double, double, Pokemon, String, String)
     * @see be.ac.ulb.infof307.g07.Models.PokeMarker
     * @see be.ac.ulb.infof307.g07.Models.PokeMarker#getId() 
     */
    public PokeMarker addPokeMarker(PokeMarker marker) {
        Gson gson = CustomGson.get();
        System.out.println(gson.toJson(marker));
        String response = Requests.post("http://127.0.0.1:4567/locations").body(gson.toJson(marker)).send().readToText();
        System.out.println(response);
        PokeMarker created = gson.fromJson(response, PokeMarker.class);
        return created;
    }
    
    /**
     * Récupère les détails d'un PokeMarker en particulier.
     *
     * @param id Reference vers ce marker.
     * @return Détail du PokeMarker.
     */
    public final PokeMarker getPokeMarker(ObjectId id) {
        String response = Requests.get("http://127.0.0.1:4567/locations/" + id.toHexString()).send().readToText();
        Gson gson = CustomGson.get();
        PokeMarker marker = gson.fromJson(response, PokeMarker.class);
        return marker;
    }
    
    /**
     * Retourne le nombre de markers contenu sur la carte.
     * 
     * @return Nombew de markers sous forme d'un entier.
     */
    public int getNumberOfMarker() {
        String response = Requests.get("http://127.0.0.1:4567/locations").send().readToText();
        Gson gson = CustomGson.get();
        PokeMarker[] markers = gson.fromJson(response, PokeMarker[].class);
        return markers.length;
    }
    
    /**
     * TODO
     */
    public void removePokeMarker(PokeMarker pokeMarker) {
    }
}
