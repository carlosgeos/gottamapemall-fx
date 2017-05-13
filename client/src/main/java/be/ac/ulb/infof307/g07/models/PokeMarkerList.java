package be.ac.ulb.infof307.g07.models;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener;
import com.google.gson.Gson;
import net.dongliu.requests.Requests;
import be.ac.ulb.infof307.g07.models.PokeMarker;

/**
 * Utilisé comme une manière d'acceder globalement aux markers dans l'application.
 */
public class PokeMarkerList {
    static private ObservableList<PokeMarker> markers;

    static public ObservableList<PokeMarker> get() {
        return markers;
    }

    static public void add(PokeMarker marker) {
        markers.add(marker);
    }

    static public void setAll(PokeMarker[] set) {
        Collection<PokeMarker> markersList = new ArrayList<PokeMarker>();

        for (int i = 0; i < set.length; ++i) {
            markersList.add(new PokeMarker(set[i]));
        }

        markers.setAll(markersList);
    }

    static public void save(PokeMarker marker) {
        Gson gson = new Gson();
        String data = gson.toJson(marker);
        Requests.post("http://127.0.0.1:4567/locations").body(data).send().readToText();
        add(marker);
    }

    static public void init(ListChangeListener<PokeMarker> listener) {
        markers = FXCollections.observableArrayList();
        markers.addListener(listener);

        String response = Requests.get("http://127.0.0.1:4567/locations").send().readToText();
        Gson gson = new Gson();
        PokeMarker[] pokeResponse = gson.fromJson(response, PokeMarker[].class);

        for (int i = 0; i < pokeResponse.length; ++i) {
            add(new PokeMarker(pokeResponse[i]));
        }
    }
}
