package be.ac.ulb.infof307.g07.controllers.Handlers;

import be.ac.ulb.infof307.g07.controllers.ChoosePokemonViewListener;
import be.ac.ulb.infof307.g07.models.Coordinate;
import be.ac.ulb.infof307.g07.models.Map;
import be.ac.ulb.infof307.g07.models.Pokemon;
import be.ac.ulb.infof307.g07.models.PokeMarker;
import be.ac.ulb.infof307.g07.views.MapView;

/**
 *
 * Cette classe gere la gestion d une nouvelle epingle pokemon
 *
 * @version 1.0
 *
 * @see be.ac.ulb.infof307.g07.models.Map
 * @see @see be.ac.ulb.infof307.g07.views.MapView
 */
public class addNewPokeMarkerHandler implements ChoosePokemonViewListener {

	/**
	 * le modele sur la carte pokemon
	 */
    private Map pokeMap;

    /**
     * la vue sur la carte pokemon
     */
    private MapView pokeMapView;

    /**
     * la latitude pour placer la nouvelle epingle
     */
    private double lat;

    /**
     * la longitude pour placer la nouvelle epingle
     */
    private double lon;

    /**
     * Le constructeur de addNewPokeMarkerHandler
     *
     * @param pokeMap le modele sur la carte pokemon
     * @param pokeMapView la vue sur la carte pokemon
     * @param lat la latitude pour placer la nouvelle epingle
     * @param lon la longitude pour placer la nouvelle epingle
     */
    public addNewPokeMarkerHandler(Map pokeMap, MapView pokeMapView, double lat, double lon) {
        this.pokeMap = pokeMap;
        this.pokeMapView = pokeMapView;
        this.lat = lat;
        this.lon = lon;
    }

    /**
     * La methode qui s occupe des actions a effectuer apres avoir clique sur le bouton ok lors de l ajout d une epingle.
     * Elle transmet les informations necessaire a addPokeMarker de Map, pour faire l ajout effectif de l epingle avec ses informations.
     *
     * @param pokemon le pokemon a ajouter
     * @param date la date a laquelle le pokemon a ete vu
     * @param time l heure a laquelle le pokemon a ete vu
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
