package be.ac.ulb.infof307.g07.Views;

import java.util.ArrayList;

import com.lynden.gmapsfx.javascript.object.Marker;

public class ClusterMarkers {
	
	static final int offset = 268435456; //  It is half of the earth circumference in pixels at zoom level 21
	static final double radius =  85445659.4471;
	

	public static double LonToX(double lon) {
        return Math.round(offset + radius * lon * Math.PI / 180);
    }

    public static double LatToY(double lat) {
        return Math.round(offset - radius * Math.log((1 + Math.sin(lat * Math.PI / 180)) / (1 - Math.sin(lat * Math.PI / 180))) / 2);
    }
	
    
    public static int PixelDistance(double lon1, double lat1, double lon2, double lat2, int zoom){
		
    	int res;
    	
    	double X1 = LonToX(lon1);
    	double Y1 = LatToY(lat1);
    	
    	double Y2 = LatToY(lat2);
    	double X2 = LonToX(lon2);
    	
    	res = (int) Math.sqrt(Math.pow((X1 - X2), 2) + Math.pow((Y1 - Y2), 2)) >> (21 - zoom);
    	return res;
    }
    
    
    static ArrayList<Cluster> ClusterFunction(ArrayList<Marker> ListMarker, int distance, int zoom){
    	
    	
    	ArrayList<Cluster> ListCluster = new ArrayList<Cluster>();
    	ArrayList<Marker> ListMarkerCopy = new ArrayList<Marker>();
    	
    	for (Marker marker : ListMarker){ // clone ListMarker
    		ListMarkerCopy.add(marker);
    	}
    	
    	/* Loop until all markers have been compared. */
    	
    	for (int i = 0; i < ListMarkerCopy.size();){
    		
    		/* Compare against all markers which are left. */
    		ArrayList<Marker> tempMarkerList = new ArrayList<Marker>();
    		for (int j = i+1; j < ListMarkerCopy.size();){
    			// change getLatitude ...
    			int pixelDistance = PixelDistance(ListMarkerCopy.get(i).getLatitude(), ListMarkerCopy.get(i).getLongitude(), ListMarkerCopy.get(j).getLatitude(), ListMarkerCopy.get(j).getLongitude(), zoom);
    		
	    		if (pixelDistance < distance){
	    			
	    			tempMarkerList.add(ListMarkerCopy.get(i));
	    			tempMarkerList.add(ListMarkerCopy.get(j));
	    			
	    			//ListMarker.remove(j);
	    			ListMarkerCopy.remove(j);
	    			j = i+1;
	    		}
	    		else{
	    			j++;
	    		}
    		}
    		
    		/* If a marker has been added to cluster, add also the one  */
            /* we were comparing to and remove the original from array. */
    		if (tempMarkerList.size() > 0){
    			Cluster cluster = new Cluster( tempMarkerList,tempMarkerList.size()+1, ListMarkerCopy.get(i).getLatitude(), ListMarkerCopy.get(i).getLongitude());
    			ListCluster.add(cluster);
    			ListMarkerCopy.remove(i);
    			//ListMarker.remove(i);
    			i = 0;
    		}
    		else{
    			i++;
    		}

    	}

		return ListCluster;
    	
    }
}
