package be.ac.ulb.infof307.g07.controllers.Handlers;

import be.ac.ulb.infof307.g07.views.FilterView;
import be.ac.ulb.infof307.g07.models.FilterModel;
import be.ac.ulb.infof307.g07.models.PokeMarker;
import net.dongliu.requests.Requests;
import com.google.gson.Gson;
import be.ac.ulb.infof307.g07.libs.CustomGson;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class FilterSearchHandler implements EventHandler<ActionEvent> {
    private FilterView view;
    
    public FilterSearchHandler(FilterView view) {
        this.view = view;
    }
    
    @Override
    public void handle(ActionEvent event) {
        FilterModel model = this.view.getFilter();
        String response = Requests.get("http://127.0.0.1:4567/locations" + model.createQuery()).send().readToText();
        Gson gson = new Gson();
        PokeMarker[] markers = gson.fromJson(response, PokeMarker[].class);
        this.view.filterOnMap(markers);
    }
}
