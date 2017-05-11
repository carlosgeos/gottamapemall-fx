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
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXComboBox;
import javafx.scene.control.TextField;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import com.lynden.gmapsfx.javascript.object.Marker;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;


import javafx.geometry.HPos;


import javafx.scene.layout.GridPane;

import be.ac.ulb.infof307.g07.views.PokeCell;


import com.google.gson.Gson;
import net.dongliu.requests.Requests;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.jfoenix.controls.JFXListView;


import be.ac.ulb.infof307.g07.models.Pokemon;

import static javafx.scene.input.MouseEvent.MOUSE_PRESSED;

public class FilteringController implements Initializable {

    @FXML
    private JFXTextField searchPokemonName;
    @FXML
    private JFXTextField searchPokemonHeight;
    @FXML
    private JFXTextField searchPokemonWeight;
    @FXML
    private JFXTextField searchPokemonExperience;

    @FXML
    private JFXButton searchButton;
    @FXML
    private JFXButton saveButton;

    @FXML
    private void handleSearchAction(ActionEvent e) {

    }

    @FXML
    private void handleSaveAction(ActionEvent e) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }
}
