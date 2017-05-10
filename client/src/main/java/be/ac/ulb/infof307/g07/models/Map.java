package be.ac.ulb.infof307.g07.models;

import java.net.ConnectException;
import java.util.HashMap;

import com.lynden.gmapsfx.javascript.object.GoogleMap;


/**
 * Map est le modele qui stocke l ensemble de modeles (ex: PokerMarker) se trouvant sur la map.
 *
 */
public class Map extends GoogleMap{

	private static Map instance = null;
	private HashMap<Integer, PokeMarker> pokeMarkers;
	private Gson gson;
	
	/**
	 * Construit un objet du type Map
	 */
	public Map(){
		pokeMarkers = new HashMap<Integer, PokeMarker>();
		gson = CustomGson.get();
	}
	
	/**
	 * Methode singleton qui renvoie une instance de cette classe
	 * @return Objet Map
	 */
	public static Map getInstance(){
		if (instance == null){
			instance = new Map();
			
		}
		return instance;
	}

	/**
	 * Cette methode ajoute un PokerMarker dans le hashmap pokemarkers et il l envoie au serveur.
	 * 
	 * @param pokemon Pokemon que l on souhaite ajouter
	 * @param lat Latitude du marker
	 * @param lon Longitude du marker
	 * @param dateTime Timestamp
	 * @return Renvoie un objet PokeMarker si tout est sauvegarde correctement, null sinon.
	 */
	public PokeMarker addPokeMarker(Pokemon pokemon, double lat, double lon, String dateTime){
		
		PokeMarker pokeMarker;
		
		try{
			pokeMarker = new PokeMarker(pokemon, lat, lon, dateTime);
			savePokeMarkerOnServer(pokeMarker);
			pokeMarkers.put(pokeMarker.getId(),pokeMarker);
		}catch( Exception error ){
			
			pokeMarker = null;
			throw error;
						
		}finally{
			return pokeMarker;
			
		}
		
	}

	/**
	 * Sauvegarde un PokeMarker dans le serveur
	 * @param pokeMarker Pokemon que l on souhaite sauvegarder
	 */
	private void savePokeMarkerOnServer(PokeMarker pokeMarker){
		try{
			String response = Requests.post("http://127.0.0.1:4567/locations").body(gson.toJson(pokeMarker)).send().readToText();
			//PokeMarker created = gson.fromJson(response, PokeMarker.class);
		} catch (ConnectException error){
			throw error;
		}
		
	}
	
	
	/**
	 * Renvoie le totalite de PokeMarkers se trouvant dans le hashmap
	 * @return Hashmap avec PokeMarkers
	 */
	public final HashMap<Integer, PokeMarker> getPokeMarkers(){
		return pokeMarkers;
	}
	
	/**
	 * Renvoie le nombre de PokeMarkers sauvegardes dans le
	 * @return Taille du hashmap
	 */
	public int getNumberOfMarkers(){
		return pokeMarkers.size();
	}
	
	/**
	 * Supprime un PokeMarker du hashmap
	 * @param pokeMarker PokeMarker que l on souhaite supprimer
	 */
	public void removePokeMarker(PokeMarker pokeMarker){
		pokeMarkers.remove(pokeMarker.getId());
		
	}
}
