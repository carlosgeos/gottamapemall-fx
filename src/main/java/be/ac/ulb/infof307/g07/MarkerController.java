package be.ac.ulb.infof307.g07;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;

import netscape.javascript.JSObject;

public class MarkerController {

	
	private MarkerView markerView;
	private HashMap<Integer, MarkerModel> markerModels = new HashMap<Integer, MarkerModel>();
	private GoogleMap map;
	
	public MarkerController(GoogleMap newMap){
		
		markerView = new MarkerView(newMap);
		map = newMap;
	}

	
    public void addMarker(LatLong newPosMarker){
    	
    	MarkerOptions testOptions = new MarkerOptions();
    	testOptions.position(newPosMarker);
    	//testOptions.icon("https://pldh.net/media/pokemon/gen6/xy/175.png");
    	MarkerModel markerModel = new MarkerModel(testOptions);
        markerModels.put(markerModel.getId(), markerModel);
    	
    	markerView.addMarker(markerModel);
    	//map.addUIEventHandler(markerModel, UIEventType.click, (JSObject obj) -> {onClickMarker(markerModel,null);});
    	
    	
    }
    
    private void onClickMarker(MarkerModel currentMarker, LatLong newPosition){
    	
    	//markerModels.get(0).setPosition(new LatLong(55.6197, -120.3231));
    	markerView.refreshMap();
    	
    }
}
