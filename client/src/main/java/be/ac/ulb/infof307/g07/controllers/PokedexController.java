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

import java.util.Collection;
import com.google.gson.Gson;
import net.dongliu.requests.Requests;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.jfoenix.controls.JFXListView;


import be.ac.ulb.infof307.g07.models.Pokemon;
import be.ac.ulb.infof307.g07.models.PokemonList;

import static javafx.scene.input.MouseEvent.MOUSE_PRESSED;

public class PokedexController implements Initializable {

    @FXML
    private JFXListView pokedexList;
    @FXML
    private JFXDrawer pokemonDetailView;

    private ObservableList<Pokemon> pokemonInPokedex;

    // Add doc
    private GridPane pokemonCellView(Pokemon pokemon) {
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

        pokemonGridPane.add(pokemonLabel, 1, 0);

        pokemonGridPane.setOnMouseClicked(mouseEvent -> {
                pokemonDetailView.setSidePane(fillPokemonDetailView(pokemon));
                pokemonDetailView.open();
            });

        return pokemonGridPane;
    }

    // Add doc
    private GridPane fillPokemonDetailView(Pokemon pokemon) {
        // Add close button (calling this.pokemonDetailView.close() to close drawer)
        GridPane result = new GridPane();

        Image pokemonImage = new Image("pokemon_gifs/" + pokemon.getId() + ".gif", 50, 50, true, true);
        ImageView pokemonImageView = new ImageView(pokemonImage);
        result.add(pokemonImageView, 0, 0);

        String pokemonId = pokemon.getIdAsString();
        result.add(new Label(pokemonId), 1, 1);
        result.add(new Label("ID:"), 0, 1);

        String pokemonName = pokemon.getName();
        Label pokemonNameLabel = new Label(pokemonName.substring(0, 1).toUpperCase() + pokemonName.substring(1));
        result.add(pokemonNameLabel, 1, 2);
        result.add(new Label("Nom:"), 0, 2);

        String pokemonTypes = pokemon.getTypesAsString();
        result.add(new Label(pokemonTypes), 1, 3);
        result.add(new Label("Types:"), 0, 3);

        String pokemonWeight = pokemon.getWeightAsString();
        result.add(new Label(pokemonWeight), 1, 4);
        result.add(new Label("Poid:"), 0, 4);

        String pokemonHeight = pokemon.getHeightAsString();
        result.add(new Label(pokemonHeight), 1, 5);
        result.add(new Label("Taille:"), 0, 5);

        return result;
    }

    // Add doc
    private void fillPokedex() {
        PokemonList.fill();
        Collection<Pokemon> pokemons = PokemonList.get();

        for (Pokemon poke : pokemons) {
            pokedexList.getItems().add(pokemonCellView(poke));
        }
    }


    // Add doc
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fillPokedex();
    }
}
