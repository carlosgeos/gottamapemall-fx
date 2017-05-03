package be.ac.ulb.infof307.g07.controllers.Handlers;

import be.ac.ulb.infof307.g07.controllers.ChoosePokemonViewListener;
import be.ac.ulb.infof307.g07.models.Coordinate;
import be.ac.ulb.infof307.g07.models.Map;
import be.ac.ulb.infof307.g07.models.Pokemon;
import be.ac.ulb.infof307.g07.models.PokeMarker;
import be.ac.ulb.infof307.g07.views.MapView;

/**
 * 
 * Cette classe gère la gestion de l'ajout d'une nouvelle épingle pokemon
 * 
 * @version 1.0
 * 
 * @see be.ac.ulb.infof307.g07.models.Map
 * @see be.ac.ulb.infof307.g07.views.MapView
 */
public class addNewPokeMarkerHandler implements ChoosePokemonViewListener {
	
	/**
	 * le modèle sur la carte pokemon 
	 * 
	 * @see be.ac.ulb.infof307.g07.models.Map
	 */
    private Map pokeMap;
    
    /**
     * L'objet vue de la carte pokemon pour les actions à effectuer sur l'affichage.
     *
     * @see be.ac.ulb.infof307.g07.views.MapView
     */
    private MapView pokeMapView;
    
    /**
     * la latitude où placer la nouvelle épingle
     */
    private double lat;
    
    /**
     * la longitude où placer la nouvelle épingle
     */
    private double lon;
    
    /**
     * Le constructeur de addNewPokeMarkerHandler
     * 
     * @param pokeMap le modèle sur la carte pokemon
     * @param pokeMapView la vue sur la carte pokemon
     * @param lat la latitude pour placer la nouvelle épingle
     * @param lon la longitude pour placer la nouvelle épingle
     */
    public addNewPokeMarkerHandler(Map pokeMap, MapView pokeMapView, double lat, double lon) {
        this.pokeMap = pokeMap;
        this.pokeMapView = pokeMapView;
        this.lat = lat;
        this.lon = lon;
    }
    
    /**
     * La méthode qui s'occupe des actions à effectuer après avoir cliqué sur le bouton ok lors de l'ajout d une épingle.
     * Elle transmet les informations nécessaires à addPokeMarker de Map, pour faire l'ajout effectif de l'épingle avec ses informations.
     * 
     * @param pokemon le pokemon à ajouter
     * @param date la date à laquelle le pokemon a été vu
     * @param time l'heure à laquelle le pokemon a été vu
     * 
     * @see be.ac.ulb.infof307.g07.models.Map
     * @see be.ac.ulb.infof307.g07.models.Map#addPokeMarker(double, double, Pokemon, String, String)
     */
    @Override
    public void onConfirm(Pokemon pokemon, String date, String time) {
        PokeMarker marker = this.pokeMap.addPokeMarker(this.lat, this.lon, pokemon, date, time);
        this.pokeMapView.addMarker(marker);
    }
}
