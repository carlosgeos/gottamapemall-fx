package be.ac.ulb.infof307.g07.views;

import com.lynden.gmapsfx.ClusteredGoogleMapView;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.ClusteredGoogleMap;

import be.ac.ulb.infof307.g07.controllers.GoogleMapViewMouseClickHandler;
import be.ac.ulb.infof307.g07.models.Map;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class MapView{
	
	private ClusteredGoogleMapView googleMapView;
	public static final double notSet = -1;
	private static MapView instance = null;
	private double onMarkerLayoutMouseX;
	private double onMarkerLayoutMouseY;
	private final double radius = 70;
	
	public MapView( MapComponentInitializedListener mapInitialized ){
		
		googleMapView = new ClusteredGoogleMapView(null, Map.defaultApiKey);
		for(Button elem:PokeMarkerOptionsView.getInstance().getView()){
			googleMapView.getChildren().add(elem);
		}
		googleMapView.addMapInializedListener(mapInitialized);
		googleMapView.addEventHandler(MouseEvent.MOUSE_CLICKED, new GoogleMapViewMouseClickHandler(this));
		
		instance = this;
	}
	
	public double[][] calcMenuPosition(int nbElement){
		double[][] res = new double[nbElement][2];
		double radians = Math.toRadians(360/nbElement);
		for( int i = 0; i<nbElement;++i){
			res[i][0] = onMarkerLayoutMouseX + radius * Math.cos(i*radians);
			res[i][1] = onMarkerLayoutMouseY + radius * Math.sin(i*radians);
		}
		return res;
	}
	
	public void fixeMarkerLayoutPosition(double newX, double newY  ){
		onMarkerLayoutMouseX = newX;
		onMarkerLayoutMouseY = newY;
	}
	
	public static MapView getInstance(){
		
		return instance;
	}
	
	public final double getMarkerLayoutMouseX(){
		return onMarkerLayoutMouseX;
	}
	
	public final double getMarkerLayoutMouseY(){
		return onMarkerLayoutMouseY;
	}
	
	public void setMarkerLayoutMouseX(double newVal){
		onMarkerLayoutMouseX = newVal;
	}
	
	public void setMarkerLayoutMouseY(double newVal){
		onMarkerLayoutMouseY = newVal;
	}
	
	public GoogleMapView getView(){
		
		return googleMapView;
	}
	
	public ClusteredGoogleMap createMap(){
		return googleMapView.createMap(Map.createDefaultOptions());
	}
}
