package be.ac.ulb.infof307.g07.Views;

import java.util.ArrayList;

import com.lynden.gmapsfx.javascript.object.Marker;

public class Cluster {
	

	private ArrayList<Marker> tempMarkerList;
	private final int tempMarkerListSize;
	private final double latitude;
	private final double longitude;
		
	public Cluster( ArrayList<Marker> newTempMarkerList, int newTempMarkerListSize, double newLatitude, double newLongitude){
		
		
		tempMarkerList = newTempMarkerList;
		tempMarkerListSize = newTempMarkerListSize;
		latitude = newLatitude;
		longitude = newLongitude;
		
	}

	public ArrayList<Marker> getTempMarkerList() {
		return tempMarkerList;
	}

	public int getTempMarkerListSize() {
		return tempMarkerListSize;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}




}
