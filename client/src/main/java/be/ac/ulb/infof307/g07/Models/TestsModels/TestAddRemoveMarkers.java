package be.ac.ulb.infof307.g07.Models.TestsModels;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.ac.ulb.infof307.g07.Models.Coordinate;
import be.ac.ulb.infof307.g07.Models.Map;
import be.ac.ulb.infof307.g07.Models.PokeMarker;
import be.ac.ulb.infof307.g07.Models.Pokedex;
import be.ac.ulb.infof307.g07.Models.Pokemon;

public class TestAddRemoveMarkers {
	Pokedex pokedex;
	Map map;
	private int size = 10;
	
	@Before
	public void setUp() throws Exception {
		this.pokedex = new Pokedex();
		this.map = new Map(this.pokedex);
	}

	@Test
	public void testAddMarker() {
		for(int i = 0; i < this.size; ++i){
			Pokemon newPokemon = new Pokemon(1, null, null, 0, 0, 0, null);
			this.map.addPokeMarker(new Coordinate(41.40338, 2.17403), newPokemon.getId(), null, null);
		}
		
		assertEquals(this.map.getNumberOfMarkers(), this.size);
	}

	@Test
	public void testRemoveMarker() {
		Coordinate coord = new Coordinate(23.44, 43.65);
		PokeMarker pokemarker = this.map.addPokeMarker(coord, 1, null, null);
		this.map.removePokeMarker(pokemarker);
		assertEquals(this.map.getNumberOfMarkers(),0);
		
	
	}


}
