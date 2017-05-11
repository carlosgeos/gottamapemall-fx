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

public class PokedexController implements Initializable {

    @FXML
    private TextArea pokemonText;

    @FXML
    private JFXListView pokedexList;

    private ObservableList<Pokemon> pokemonInPokedex;

    public GridPane createView(Pokemon pokemon) {
        GridPane pokemonGridPane = new GridPane();
        pokemonGridPane.setPrefWidth(160);
        pokemonGridPane.setPrefHeight(50);
        pokemonGridPane.setHgap(10);
        pokemonGridPane.setVgap(10);


        Image pokemonImage = new Image("pokemon_gifs/" + pokemon.getId() + ".gif", 50, 50, true, true);
        ImageView pokemonImageView = new ImageView(pokemonImage);

        pokemonGridPane.add(pokemonImageView, 0, 0);
        String pokemonName = pokemon.getName();
        Label pokemonLabel = new Label(pokemonName.substring(0, 1).toUpperCase() + pokemonName.substring(1));
        // pokemonLabel.setAlignment(Pos.CENTER_RIGHT);
        pokemonGridPane.setFillWidth(pokemonLabel, true);
        pokemonLabel.setMaxWidth(Double.MAX_VALUE);
        pokemonGridPane.setHalignment(pokemonLabel, HPos.RIGHT);
        pokemonGridPane.add(pokemonLabel, 1, 0);

        // pokemonGridPane.setOnMouseClicked(this);
        // pokemonGridPane.setOnMouseEntered(mouseEvent -> {
        //      this.holdGridStyle = this.pokemonGridPane.getStyle();
        //     this.pokemonGridPane.setStyle(this.hoverGridStyle); });
        // this.pokemonGridPane.setOnMouseExited(mouseEvent -> { this.pokemonGridPane.setStyle(this.holdGridStyle); });

        return pokemonGridPane;
    }

    private void fillPokedex() {
        this.pokemonInPokedex = FXCollections.observableArrayList();

        String response = Requests.get("http://127.0.0.1:4567/pokemons").send().readToText();
        Gson gson = new Gson();
        Pokemon[] pokemons = gson.fromJson(response, Pokemon[].class);

        for (int i = 0; i < pokemons.length; ++i) {
            Pokemon j = new Pokemon(pokemons[i]);
            pokemonInPokedex.add(j);
            pokedexList.getItems().add(createView(j));
        }

        // pokedexList.setItems(pokemonInPokedex);
        //pokedexList.getItems().add("asdf");
        //pokemonText.setText(pokemonInPokedex.get(1).getName());
        // items.add("asdf");
        // items.add("324f");
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //googleMapView.addMapInializedListener(() -> configureMap());
        fillPokedex();
	// pokemonText.setText("JOder uqe pasa");
    }

    // protected void configureMap() {
    //     MapOptions mapOptions = new MapOptions();

    //     mapOptions.center(new LatLong(47.6097, -122.3331))
    // 	    .mapType(MapTypeIdEnum.ROADMAP)
    // 	    .zoom(9);
    //     map = googleMapView.createMap(mapOptions, false);

    // 	// Pokedex button event
    // 	pokedex.setSidePane(new TextField("Holaa"));
    // 	pokedexButton.addEventHandler(MOUSE_PRESSED, e -> {
    // 		pokedex.open();
    // 	    });

    // 	// Map double click event
    //     map.addMouseEventHandler(UIEventType.dblclick, (GMapMouseEvent event) -> {
    // 		// add to map
    // 		map.setZoom(map.getZoom() - 1); // Compensate zoom
    // 		LatLong latLong = event.getLatLong();
    // 		map.addClusterableMarker(new Marker(new MarkerOptions().position(latLong)));
    // 		// add to database
    // 		// TODO
    // 	    });
    // }
}
