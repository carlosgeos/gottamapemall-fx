package be.ac.ulb.infof307.g07.controllers.Handlers;

import be.ac.ulb.infof307.g07.views.FilterView;
import net.dongliu.requests.Requests;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class FilterSearchHandler implements EventHandler<ActionEvent> {
    private FilterView view;
    
    public FilterSearchHandler(FilterView view) {
        this.view = view;
    }
    
    @Override
    public void handle(ActionEvent event) {
    }
}
