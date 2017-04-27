package be.ac.ulb.infof307.g07.Controllers.Handlers;

import com.lynden.gmapsfx.javascript.event.GMapMouseEvent;
import com.lynden.gmapsfx.javascript.event.MouseEventHandler;

import be.ac.ulb.infof307.g07.Models.Coordinate;
import be.ac.ulb.infof307.g07.Models.Map;
import be.ac.ulb.infof307.g07.Views.ChoosePokemonView;
import be.ac.ulb.infof307.g07.Views.MapView;

public class onMapDblClickHandler implements MouseEventHandler {
    private Map pokeMap;
    private MapView pokeMapView;
    
    public onMapDblClickHandler(Map pokeMap, MapView pokeMapView) {
        this.pokeMap = pokeMap;
        this.pokeMapView = pokeMapView;
    }
    
    @Override
    public void handle(GMapMouseEvent event) {
        this.pokeMapView.refreshMap();

        if(!ChoosePokemonView.isCreated) {
            Coordinate newPosition = new Coordinate(event.getLatLong().getLatitude(), event.getLatLong().getLongitude());
            addNewPokeMarkerHandler newHandler = new addNewPokeMarkerHandler(this.pokeMap, this.pokeMapView, newPosition);
            
            ChoosePokemonView newChooseWindow = new ChoosePokemonView();
            newChooseWindow.addListener(newHandler);
        }
    }
}
