package be.ac.ulb.infof307.g07.controllers.Handlers;

import be.ac.ulb.infof307.g07.views.FilterView;
import be.ac.ulb.infof307.g07.models.FilterModel;
import net.dongliu.requests.Requests;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class FilterSaveHandler implements EventHandler<ActionEvent>{
    private FilterView view;

    public FilterSaveHandler(FilterView view) {
        this.view = view;    
    }

    @Override
    public void handle(ActionEvent event) {
        FilterModel filter = view.getFilter();
    }

}
