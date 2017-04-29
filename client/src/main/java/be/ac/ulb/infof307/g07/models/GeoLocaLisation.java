package be.ac.ulb.infof307.g07.models;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Cette classe calcule la distance entre deux points en utilisant les coordonnees decimales (latitude, longitude)
 * ici la premiere position represente la position de l'utilisateur sur la carte et la deuxiemme represente une 
 * epingle (pokemon).
 * finalement on aura une liste qui contient les id des epingles a afficher 
 * 
 * @see be.ac.ulb.infof307.g07.models.PokeMarker 
 * @author Pieer Lahdo
 * @version 1.0 
 */
public class GeoLocaLisation {
	
	/**
	 * calcule la distance entre deux points en utilisant les coordonnees decimales (latitude, longitude)
	 * 
	 * @param lon1
	 * 				Longitude de la position de l'utilisateur
	 * @param lat1
	 * 				Latitude de la position de l'utilisateur
	 * @param lon2
	 * 				Longitude de la position du pokemon
	 * @param lat2
	 * 				Latitude de la position du pokemon
	 * @return distance entre deux points 
	 */
	public static double distanceBetnTwoPoints(double lon1, double lat1, double lon2, double lat2){
		
    	double res;
    	res =  Math.sqrt(Math.pow((lon1 - lon2), 2) + Math.pow((lat1 - lat2), 2)); // pythagor
    	return res;
    }
	
	/**
	 * Convertit la distance entre deux points (en metres), en une distance decimale (latitude-longitude)  
	 * 
	 * @param metres
	 * 				la distance a convertir
	 * @return
	 * 			une distance decimale (latitude-longitude)  
	 */
	public static double metersToDecimalsCoordinates(int metres){
		double coordinate = metres * 0.0009 / 100 ;
		// regle de trois, 100 metres c'est 0.0009 entre deux points de coordonnées, 0.0009 == 0 degrés 0 minutes 3secondes
		return coordinate;
	}
    
    /**
     * Cette methode boucle sur la liste des epingles pokemon et compare la distance entre la position de l utilisateur et la position de ces epingles
     * Si cette distance est inferieure au rayon predefini alors on ajoute cette epingle dans une liste et on affichera ensuite sur la carte toutes les epingles de cette liste.
     * 
     * @see be.ac.ulb.infof307.g07.models.PokeMarker
     * 
     * @param ListMarker
     * 					la table de hachage contenant les epingles pokemon
     * @param distanceMetre
     * 						le rayon predefini, en metres
     * @param fromMarker
     * 					l epingle pokemon
     * @return la liste des epingles pokemons a afficher (comprises dans le rayon donc)
     */
    public static ArrayList<Integer> PokemonsAroundMe(HashMap<Integer,PokeMarker> ListMarker, int distanceMetre, PokeMarker fromMarker){
    	
    	
    	/*Boucle jusqu'à ce que tous les marqueurs aient été comparés. */
    	ArrayList<Integer> tempMarkerList = new ArrayList<Integer>();
    	for (Integer key : ListMarker.keySet()){
    		
    		/* Comparaison avec tous les marqueurs . */
    		
    		double distanceBetnTwoPointsTemp = distanceBetnTwoPoints(fromMarker.getOnMapPosition().getX(), fromMarker.getOnMapPosition().getY(), ListMarker.get(key).getOnMapPosition().getX(), ListMarker.get(key).getOnMapPosition().getY());
    		
    		
	    	if (distanceBetnTwoPointsTemp <= metersToDecimalsCoordinates(distanceMetre)){
	    			
	    		tempMarkerList.add(key);
	    	}
    	}
    	return tempMarkerList;
    }
}