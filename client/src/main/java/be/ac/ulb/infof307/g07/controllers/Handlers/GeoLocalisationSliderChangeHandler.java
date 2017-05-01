package be.ac.ulb.infof307.g07.controllers.Handlers;

import be.ac.ulb.infof307.g07.models.GeoLocaLisation;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class GeoLocalisationSliderChangeHandler implements ChangeListener<Number> {
    @Override
    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        GeoLocaLisation.radius = newValue.intValue();
    }
} 
