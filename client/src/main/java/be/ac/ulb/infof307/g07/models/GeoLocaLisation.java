package be.ac.ulb.infof307.g07.models;

import java.util.ArrayList;
import java.util.HashMap;
import org.bson.types.ObjectId;

import com.lynden.gmapsfx.shapes.Circle;


//TODO: Changer nom du fichier ! GeoLocaLisation -> GeoLocalisation

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
	 * le rayon du cercle pour afficher les pokemons autour de l'utilisateur qui peut d'ailleurs le modifier grâce à un slider (curseur).
	 */
    public static int radius = 100;
    
    /**
     * le centre du cerlcu pour afficher les pokemons autour de l'utilisateur, sous forme d'un objet Coordinate (coordonées latitude et longtitude).
     */
    public static Coordinate center = null;
        
    /**
     * calcule la distance entre deux points en utilisant les coordonnees decimales (latitude, longitude)
     * 
     * @param lon1 Longitude de la position de l'utilisateur
     * @param lat1 Latitude de la position de l'utilisateur
     * @param lon2 Longitude de la position du pokemon
     * @param lat2 Latitude de la position du pokemon
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
     * @param metres la distance a convertir
     * @return une distance decimale (latitude-longitude)  
     * 
     */
    public static double metersToDecimalsCoordinates(int metres){
        double coordinate = metres * 0.0009 / 100 ;
        // regle de trois, 100 metres c'est 0.0009 entre deux points de coordonnées, 0.0009 == 0 degrés 0 minutes 3secondes
        return coordinate;
    }

    /**
     * Cette methode boucle sur la liste des épingles pokemon et compare la distance entre la position de l'utilisateur et la position de ces épingles.
     * Si cette distance est inférieure au rayon choisi alors on ajoute cette épingle dans une liste (HashMap tempMarkerList) et on affichera ensuite sur la carte toutes les épingles de cette liste.
     * 
     * @see be.ac.ulb.infof307.g07.models.PokeMarker
     * 
     * @param markers la table de hachage contenant toutes les épingles pokemon
     * @param distanceMetre le rayon sélectionné, en mètres
     * @param fromMarker la position de l'utilisateur sur la carte
     * @return la liste des épingles pokemons à afficher (qui sont donc comprises dans le cercle de rayon distanceMetre)
     */
    public static HashMap<ObjectId, Integer> pokemonsAroundMe(PokeMarker[] markers, int distanceMetre, Coordinate fromMarker) {
        /*Boucle jusqu'à ce que tous les marqueurs aient été comparés. */
        HashMap<ObjectId, Integer> tempMarkerList = new HashMap<ObjectId, Integer>();
        int count = 0;
        for (int i = 0; i < markers.length; ++i) {
            /* Comparaison avec tous les marqueurs . */
            double distanceBetnTwoPointsTemp = distanceBetnTwoPoints(fromMarker.getX(), fromMarker.getY(), markers[i].getOnMapPosition().getX(), markers[i].getOnMapPosition().getY());

            if (distanceBetnTwoPointsTemp <= metersToDecimalsCoordinates(distanceMetre)) {
                tempMarkerList.put(markers[i].getId(), count);
                ++count;
            }
        }
        return tempMarkerList;
    }
}
