package be.ac.ulb.infof307.g07.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.ac.ulb.infof307.g07.models.Coordinate;
import be.ac.ulb.infof307.g07.models.Map;
import be.ac.ulb.infof307.g07.models.PokeMarker;
import be.ac.ulb.infof307.g07.models.Pokedex;
import be.ac.ulb.infof307.g07.models.Pokemon;

public class TestAddRemoveMarkers {
    Pokedex pokedex;
    Map map;
    private int size = 10;
    
    @Before
    public void setUp() throws Exception {
        this.pokedex = new Pokedex();
        this.map = new Map(this.pokedex);
    }

    // @Test
    // public void testAddMarker() {
    //     for(int i = 0; i < this.size; ++i){
    //         Pokemon newPokemon = new Pokemon(1, null, null, 0, 0, 0, null);
    //         this.map.addPokeMarker(41.40338, 2.17403, newPokemon, null, null);
    //     }

    //     assertEquals(this.map.getNumberOfMarkers(), this.size);
    // }

    // @Test
    // public void testRemoveMarker() {
    //     Pokemon newPokemon = new Pokemon(1, null, null, 0, 0, 0, null);
    //     PokeMarker pokemarker = this.map.addPokeMarker(23.44, 43.65, newPokemon, null, null);
    //     this.map.removePokeMarker(pokemarker);
    //     assertEquals(this.map.getNumberOfMarkers(),0);
    // }
}
