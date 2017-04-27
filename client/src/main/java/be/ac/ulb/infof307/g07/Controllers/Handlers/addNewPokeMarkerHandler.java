package be.ac.ulb.infof307.g07.Controllers.Handlers;

import be.ac.ulb.infof307.g07.Controllers.ChoosePokemonViewListener;
import be.ac.ulb.infof307.g07.Models.Coordinate;
import be.ac.ulb.infof307.g07.Models.Map;
import be.ac.ulb.infof307.g07.Models.Pokemon;
import be.ac.ulb.infof307.g07.Views.MapView;

public class addNewPokeMarkerHandler implements ChoosePokemonViewListener{

    private Map pokeMap;
    private MapView pokeMapView;
    private Coordinate position;

    public addNewPokeMarkerHandler( Map pokeMap, MapView pokeMapView, Coordinate position) {

	this.pokeMap = pokeMap;
	this.pokeMapView = pokeMapView;
	this.position = position;

    }

    @Override
    public void onConfirm(Pokemon pokemon, String date, String time) {

	this.pokeMap.addPokeMarker( this.position, pokemon, date, time);
	// then add it in the map view
	this.pokeMapView.updateMarkers();

    }

}
