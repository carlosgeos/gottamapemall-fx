package be.ac.ulb.infof307.g07.models;

import java.util.HashMap;

import org.junit.Before;

public class TestPokemonsAroundMe {
    private HashMap<Integer, PokeMarker> listPokeMarker; 

    private PokeMarker marker1;
    private PokeMarker marker2;
    private PokeMarker marker3;
    private HashMap<Integer, Integer> PokemonsAroundMe;

    @Before
    public void setUp() throws Exception {
        listPokeMarker = new HashMap<Integer, PokeMarker> ();
        marker1 = new PokeMarker(null,null,41.40338, 2.17403,null,null) ;// my position 
        marker2 = new PokeMarker(null,null,41.40345, 2.17402,null,null) ;
        marker3 = new PokeMarker(null,null,51.40344, 2.17402,null,null) ;
    }


}
