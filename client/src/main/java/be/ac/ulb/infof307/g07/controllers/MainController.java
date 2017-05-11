import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.javascript.event.GMapMouseEvent;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.ClusteredMainApp;
import com.lynden.gmapsfx.ClusteredGoogleMapView;
import com.lynden.gmapsfx.javascript.object.ClusteredGoogleMap;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.web.WebView;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import javafx.scene.control.TextField;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import com.lynden.gmapsfx.javascript.object.Marker;

import static javafx.scene.input.MouseEvent.MOUSE_PRESSED;

public class MainController extends ClusteredMainApp implements Initializable {

    @FXML
    private JFXDrawer pokedex;
    @FXML
    private ClusteredGoogleMapView googleMapView;

    private ClusteredGoogleMap map;

    private DecimalFormat formatter = new DecimalFormat("###.00000");

    // Add doc
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        googleMapView.addMapInializedListener(() -> configureMap());
    }

    // Add doc
    // MOVE TO SEPARATE STATIC MAP CONTROLLER
    protected void configureMap() {
        MapOptions mapOptions = new MapOptions();

        mapOptions.center(new LatLong(47.6097, -122.3331))
            .mapType(MapTypeIdEnum.ROADMAP)
            .zoom(9);
        map = googleMapView.createMap(mapOptions, false);

        // Map double click event
        map.addMouseEventHandler(UIEventType.dblclick, (GMapMouseEvent event) -> {
                // add to map
                map.setZoom(map.getZoom() - 1); // Compensate zoom
                LatLong latLong = event.getLatLong();
                map.addClusterableMarker(new Marker(new MarkerOptions().position(latLong)));
            });
    }
}
