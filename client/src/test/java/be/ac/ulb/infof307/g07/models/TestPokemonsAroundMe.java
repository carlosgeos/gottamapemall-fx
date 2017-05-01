package be.ac.ulb.infof307.g07.models;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import be.ac.ulb.infof307.g07.models.Coordinate;
import be.ac.ulb.infof307.g07.models.GeoLocaLisation;
import be.ac.ulb.infof307.g07.models.PokeMarker;

public class TestPokemonsAroundMe {
    private HashMap<Integer, PokeMarker> listPokeMarker; 
    
    private Coordinate position1;
    private Coordinate position2;
    private Coordinate position3;
    
    private PokeMarker marker1;
    private PokeMarker marker2;
    private PokeMarker marker3;
    private HashMap<Integer, Integer> PokemonsAroundMe;

    @Before
    public void setUp() throws Exception {
        listPokeMarker = new HashMap<Integer, PokeMarker> ();
        marker1 = new PokeMarker(41.40338, 2.17403, null, null, null) ;// my position 
        marker2 = new PokeMarker(41.40345, 2.17402, null, null, null) ;
        marker3 = new PokeMarker(51.40344, 2.17402, null, null, null) ;
    }

    // @Test
    // public void test() {
    //     PokeMarker[] list1 = {marker1, marker2};
    //     PokemonsAroundMe = GeoLocaLisation.pokemonsAroundMe(list1, 100, position1);
    //     assertEquals(PokemonsAroundMe.size(), 1);
    //     // ajouter un marker mais il est plus loin aue le rayon de recherche   
    //     PokeMarker[] list2 = {marker1, marker2, marker3};
    //     PokemonsAroundMe = GeoLocaLisation.pokemonsAroundMe(list2, 100, position1);
    //     assertEquals(PokemonsAroundMe.size(), 1);
    // }
}
