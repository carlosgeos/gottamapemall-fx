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
import com.jfoenix.controls.JFXSlider;


import be.ac.ulb.infof307.g07.models.GeolocationModel;

public class GeolocationController implements Initializable {

    @FXML
    private JFXSlider geoSlider;
    @FXML
    private JFXButton geoCancel;

    private GeolocationModel geoLoc;

    @FXML
    private void handleCancelAction(ActionEvent e) {

    }

    @FXML
    private void handleSliderAction(ActionEvent e) {
        double value = geoSlider.getValue();

        geoLoc.setRadius((int) value);
    }

    public void setCenter(LatLong coord) {
        geoLoc.setCenter(coord);
    }

    // Add doc
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
