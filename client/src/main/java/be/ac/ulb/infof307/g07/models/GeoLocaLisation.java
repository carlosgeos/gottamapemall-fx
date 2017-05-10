package be.ac.ulb.infof307.g07.models;

import java.util.HashMap;

import org.bson.types.ObjectId;



/**
 * Cette classe calcule la distance entre deux points en utilisant les coordonnees decimales (latitude, longitude)
 * ici la premiere position represente la position de l'utilisateur sur la carte et la deuxiemme represente une
 * epingle (pokemon).
 * 
 * @see be.ac.ulb.infof307.g07.models.PokeMarker 
 * @author Pierre
 * @version 1.0 
 */
public class GeoLocaLisation {
	
	public static int radius = 100;
	
	/**
	 * calcule la distance entre deux points en utilisant les coordonnees decimales (latitude, longitude)
	 * @param lat1 Latitude de la position de l'utilisateur
	 * @param lon1 Longitude de la position de l'utilisateur
	 * @param lat2 Latitude de la position du pokemon
	 * @param lon2 Longitude de la position du pokemon
	 * 
	 * @return distance entre les deux points
	 */
	public static double distanceBetweenTwoPoints(double lat1,double lon1, double lat2, double lon2){
		double res;
		res = Math.sqrt(Math.pow((lat1 - lat2), 2) +Math.pow((lon1-lon2),2)); // pythagor 
		return res; 
	}
	
	/**
	 * Convertit la distance entre deux points (en metres), en une distance decimale (latitude-longitude) 
	 * 
	 * @param metres la distance a convertir
	 * @return une distance decimale (latitude-longitude)  
	 */
	public static double metersToDecimalsCoordinates(int metres){
		double coordinate = metres * 0.0009 / 100 ;
		//  regle de trois, 100 metres c'est 0.0009 entre deux points de coordonn¨¦es, 0.0009 == 0 degr¨¦s 0 minutes 3secondes
		return coordinate;
	}
	
	/**
	 * Cette methode boucle sur la liste des epingles pokemon et compare la distance entre la position de l utilisateur et la position de ces epingles
	 * Si cette distance est inferieure au rayon predefini alors on ajoute cette epingle dans une liste et on affichera ensuite sur la carte toutes les epingles de cette liste.
	 * 
	 * @see be.ac.ulb.infof307.g07.models.PokeMarker
	 * 
	 * @param markers la table de hachage contenant les epingles pokemon
	 * @param distanceMetre le rayon predefini, en metres
	 * @param userLat l epingle pokemon
	 * @param userLon
	 * @return la liste des epingles pokemons
	 */
	public static HashMap<ObjectId, Integer> pokemonsAroundMe(PokeMarker[] markers, int distanceMetre, double userLat, double userLon){
		
		HashMap<ObjectId, Integer> tempMarkerList = new HashMap<ObjectId, Integer>();
		int count = 0;
		for (int i = 0; i < markers.length; ++i) {
			double distanceBetweenTwoPointsTemp = distanceBetweenTwoPoints(userLat, userLon, markers[i].getOnMapPosition().getX(), markers[i].getOnMapPosition().getY());
			if (distanceBetweenTwoPointsTemp <= metersToDecimalsCoordinates(distanceMetre)){
				tempMarkerList.put(markers[i].getId(), count);
				++count;
			}
		}
		return tempMarkerList;
	}
}
