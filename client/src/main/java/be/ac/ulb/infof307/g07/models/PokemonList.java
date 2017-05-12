package be.ac.ulb.infof307.g07.models;

import java.util.Collection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.google.gson.Gson;
import net.dongliu.requests.Requests;
import be.ac.ulb.infof307.g07.models.Pokemon;

/**
 * Utilisé comme une manière d'acceder globalement aux pokémons dans l'application.
 */
public class PokemonList {
    static private ObservableList<Pokemon> pokemons;

    static public ObservableList<Pokemon> get() {
        return pokemons;
    }

    static public void fill() {
        pokemons = FXCollections.observableArrayList();

        String response = Requests.get("http://127.0.0.1:4567/pokemons").send().readToText();
        Gson gson = new Gson();
        Pokemon[] pokemonsResponse = gson.fromJson(response, Pokemon[].class);

        for (int i = 0; i < pokemonsResponse.length; ++i) {
            Pokemon j = new Pokemon(pokemonsResponse[i]);
            pokemons.add(j);
        }
    }
}
