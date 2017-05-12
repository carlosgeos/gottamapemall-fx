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
import com.lynden.gmapsfx.javascript.object.InfoWindow;
import com.lynden.gmapsfx.javascript.object.InfoWindowOptions;
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
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;

import be.ac.ulb.infof307.g07.models.PokemonList;
import be.ac.ulb.infof307.g07.models.Pokemon;
import be.ac.ulb.infof307.g07.models.PokeMarker;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import netscape.javascript.JSObject;
import static javafx.scene.input.MouseEvent.MOUSE_PRESSED;

public class MainController extends ClusteredMainApp implements Initializable {

    @FXML
    private StackPane rootStackPane;
    @FXML
    private JFXDrawer pokedex;
    @FXML
    private JFXDialog addPokemonPopup;
    @FXML
    private JFXDialogLayout addPokemonPopupContent;
    @FXML
    private JFXDatePicker pokemonDate;
    @FXML
    private JFXTimePicker pokemonTime;

    private LatLong clickCoordinates;

    @FXML
    private ClusteredGoogleMapView googleMapView;

    private ClusteredGoogleMap map;

    private DecimalFormat formatter = new DecimalFormat("###.00000");

    // Add doc
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        googleMapView.addMapInializedListener(() -> configureMap());
    }

    @FXML
    private void handleAddPokemonButton(MouseEvent e) {
        List<Pokemon> pokemons = PokemonList.get();
        Pokemon pokemon = pokemons.get(0);
        System.out.println(pokemonTime.getValue());

        String time = pokemonTime.getValue().toString();
        String date = pokemonDate.getValue().toString();

        PokeMarker newPokeMarker = new PokeMarker(new MarkerOptions().position(clickCoordinates), pokemon, date, time);
        map.addClusterableMarker(newPokeMarker);
        map.addUIEventHandler(newPokeMarker, UIEventType.click, (JSObject event) -> {
            InfoWindowOptions infoWindowOptions = new InfoWindowOptions();
            infoWindowOptions.content(newPokeMarker.getString());
                
            InfoWindow pokeMarkerInfoWindow = new InfoWindow(infoWindowOptions);
            pokeMarkerInfoWindow.open(map, newPokeMarker); 
        });
    }

    @FXML
    private void handleCancelPokemonButton(MouseEvent e) {
        clickCoordinates = null;
        addPokemonPopup.close();
    }


    // Add doc
    // MOVE TO SEPARATE STATIC MAP CONTROLLER
    protected void configureMap() {
        MapOptions mapOptions = new MapOptions();

        mapOptions.center(new LatLong(47.6097, -122.3331))
            .mapType(MapTypeIdEnum.ROADMAP)
            .zoom(9);
        map = googleMapView.createMap(mapOptions, false);

        addPokemonPopup.setDialogContainer(rootStackPane);

        // Map double click event
        map.addMouseEventHandler(UIEventType.dblclick, (GMapMouseEvent event) -> {
            map.setZoom(map.getZoom() - 1); // Compensate zoom
            // Save coordinates in class attribute
            clickCoordinates = event.getLatLong();
            addPokemonPopup.show();
        });
    }
}
