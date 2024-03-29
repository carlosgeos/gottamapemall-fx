package be.ac.ulb.infof307.g07.models;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import be.ac.ulb.infof307.g07.models.Coordinate;
import be.ac.ulb.infof307.g07.models.Map;
import be.ac.ulb.infof307.g07.models.Pokemon;

public class TestAddPokeMarker {
    private Map pokeMap;
    private int size = 10;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        this.pokeMap = new Map();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test_addPokeMarker() {
        Pokemon newPokemon = new Pokemon(1, null, null, 0, 0, 0, null);
        this.pokeMap.addPokeMarker(41.40338, 2.17403, newPokemon, null, null);
    }
}
