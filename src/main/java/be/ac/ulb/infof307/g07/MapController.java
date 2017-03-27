package be.ac.ulb.infof307.g07;

/**
 * Created by carlos on 3/11/17.
 */
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.javascript.event.GMapMouseEvent;
import com.lynden.gmapsfx.javascript.event.MouseEventHandler;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;

public class MapController {

	private GoogleMap map;
	private MarkerController markerController;
    
	public MapController(GoogleMap newMap){
	
		map = newMap;

		markerController = new MarkerController(map);
	}

	public void addMarker(LatLong posMarker) {
		markerController.addMarker(posMarker);
	}
}
