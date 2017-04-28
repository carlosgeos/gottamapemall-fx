package be.ac.ulb.infof307.g07.Controllers.Handlers;

import be.ac.ulb.infof307.g07.Controllers.ChoosePokemonViewListener;
import be.ac.ulb.infof307.g07.Models.Coordinate;
import be.ac.ulb.infof307.g07.Models.Map;
import be.ac.ulb.infof307.g07.Models.Pokemon;
import be.ac.ulb.infof307.g07.Models.PokeMarker;
import be.ac.ulb.infof307.g07.Views.MapView;

public class addNewPokeMarkerHandler implements ChoosePokemonViewListener {
    private Map pokeMap;
    private MapView pokeMapView;
    private double lat;
    private double lon;
    
    public addNewPokeMarkerHandler(Map pokeMap, MapView pokeMapView, double lat, double lon) {
        this.pokeMap = pokeMap;
        this.pokeMapView = pokeMapView;
        this.lat = lat;
        this.lon = lon;
    }
    
    @Override
    public void onConfirm(Pokemon pokemon, String date, String time) {
        PokeMarker marker = this.pokeMap.addPokeMarker(this.lat, this.lon, pokemon, date, time);
        this.pokeMapView.addMarker(marker);
    }
}
