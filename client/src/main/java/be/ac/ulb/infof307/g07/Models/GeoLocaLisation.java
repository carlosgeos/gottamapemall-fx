package be.ac.ulb.infof307.g07.Models;

import java.util.ArrayList;
import java.util.HashMap;

public class GeoLocaLisation {
	

	public static double distanceBetnTwoPoints(double lon1, double lat1, double lon2, double lat2){
		
    	double res;
		
    	res =  Math.sqrt(Math.pow((lon1 - lon2), 2) + Math.pow((lat1 - lat2), 2)); // pythagor
    	return res;
    }
    
    
    public static ArrayList<Integer> PokemonsAroundMe(HashMap<Integer,PokeMarker> ListMarker, double distance, PokeMarker fromMarker){
    	
    	
    	/* Loop until all markers have been compared. */
    	ArrayList<Integer> tempMarkerList = new ArrayList<Integer>();
    	for (Integer key : ListMarker.keySet()){
    		
    		/* Compare against all markers which are left. */
    		
    		double distanceBetnTwoPointsTemp = distanceBetnTwoPoints(fromMarker.getOnMapPosition().getX(), fromMarker.getOnMapPosition().getY(), ListMarker.get(key).getOnMapPosition().getX(), ListMarker.get(key).getOnMapPosition().getY());
    		
	    	if (distanceBetnTwoPointsTemp <= distance){
	    			
	    		tempMarkerList.add(key);
	    			
	    		//ListMarker.remove(i);
	    	}
    	}
    	return tempMarkerList;
    }
}