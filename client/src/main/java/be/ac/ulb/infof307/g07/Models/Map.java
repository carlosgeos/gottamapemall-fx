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
     * Constructeur de Map
     */
    public Map() {
        //...
    }
    
    /**
     * Cette methode cree un objet PokeMarker grace a l objet Coordinate renvoye (passe en parametre) par la methode addPokeMarker(double x, double y, Pokemon pokemon, String date, String time).
     * et aux autres parametres de cette meme methode.
     * 
     * <p>
     * La methode cree un objet PokeMarker et fait appel a la methode addPokeMarker(PokeMarker newPMarker) qui ajoute 
     * le pokemarker dans la table de hachage (pokeMarkers.put(newPMarker.getId(), newPMarker) avec son id unique.
     * <p>
     * 
     * @param lat La latitude de l'épingle pokemon sur la carte.
     * @param lon La longitude de l'épingle pokemon sur la carte.
     * @param pokemon le pokemon a indiquer sur la carte comme epingle (image et caracteristiques).
     * @param date La date a laquelle le pokemon a ete vu.
     * @param time L'heure a laquelle le pokemon a ete vu.
     * @return une nouvelle epingle pokemon (avec un identifiant unique) sous la forme d un objet PokeMarker, contenant sa position sur la carte.
     *
     * @see Map#addPokeMarker(PokeMarker)
     * @see be.ac.ulb.infof307.g07.Models.PokeMarker
     * @see Map#pokeMarkers
     */
    public PokeMarker addPokeMarker(double lat, double lon, Pokemon pokemon, String date, String time) {
        PokeMarker marker = new PokeMarker(lat, lon, pokemon, date, time);
        addPokeMarker(marker);
        return marker;
    }

    /**
     * Cette methode ajoute l'objet PokeMarker cree par la methode addPokeMarker(Coordinate position) dans la table de hachage pokeMarkers grace a sa methode put().
     * 
     * @param newPMarker L epingle pokemon (pokemarker) creee par la methode addPokeMarker(Coordinate position, Pokemon pokemon, String date, String time).
     * 
     * @see Map#addPokeMarker(Coordinate, Pokemon, String, String)
     * @see be.ac.ulb.infof307.g07.Models.PokeMarker
     * @see be.ac.ulb.infof307.g07.Models.PokeMarker#getId() 
     */
    public PokeMarker addPokeMarker(PokeMarker marker) {
        Gson gson = CustomGson.get();
        String response = Requests.post("http://127.0.0.1:4567/locations").body(gson.toJson(marker)).send().readToText();
        System.out.println(response);
        PokeMarker created = gson.fromJson(response, PokeMarker.class);
        return created;
    }
    
    public final PokeMarker getPokeMarker(ObjectId id) {
        String response = Requests.get("http://127.0.0.1:4567/locations/" + id.toHexString()).send().readToText();
        Gson gson = CustomGson.get();
        PokeMarker marker = gson.fromJson(response, PokeMarker.class);
        return marker;
    }
    
    /**
     * Retourne le nombre d epingle contenues dans la table de hachage (et donc le nombre d epingles presentes sur la carte) grace a sa methode size().
     * 
     * @return
     *             la taille de pokeMarkers (table de hachage des epingles), sous forme d un entier.
     * 
     * @see Map#pokeMarkers
     * 
     */
    public int getNumberOfMarker() {
        String response = Requests.get("http://127.0.0.1:4567/locations").send().readToText();
        Gson gson = CustomGson.get();
        PokeMarker[] markers = gson.fromJson(response, PokeMarker[].class);
        return markers.length;
    }
    
    public void removePokeMarker(PokeMarker pokeMarker) {
        // pokeMarkers.remove(pokeMarker.getId());
    }
}
