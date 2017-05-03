package be.ac.ulb.infof307.g07.controllers.Handlers;

import be.ac.ulb.infof307.g07.models.GeoLocaLisation;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * Cette classe s'occupe de gérer les changements effectués sur le curseur (slider) pour le rayon de la géolocalisation.
 * 
 * @version 1.0
 *
 */
public class GeoLocalisationSliderChangeHandler implements ChangeListener<Number> {
    
	/**
	 * Lorsque l on change le curseur on récupère la nouvelle valeur pour l'affecter au rayon.
	 */
	@Override
    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        GeoLocaLisation.radius = newValue.intValue();
    }
} 
