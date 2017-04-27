package be.ac.ulb.infof307.g07.Models.ModelsTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import be.ac.ulb.infof307.g07.Models.Coordinate;
import be.ac.ulb.infof307.g07.Models.Map;
import be.ac.ulb.infof307.g07.Models.Pokemon;

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
		
		for(int i = 0; i < this.size; ++i){
			
			Pokemon newPokemon = new Pokemon(1, null, null, 0, 0, 0, null);
			this.pokeMap.addPokeMarker(new Coordinate(41.40338, 2.17403), newPokemon.getId(), null, null);
			
		}
		
		assertEquals(this.pokeMap.getNumberOfMarker(), this.size);
		
	}

}
