package be.ac.ulb.infof307.g07.Models.ModelsTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import be.ac.ulb.infof307.g07.Models.Coordinate;
import be.ac.ulb.infof307.g07.Models.GeoLocaLisation;
import be.ac.ulb.infof307.g07.Models.PokeMarker;

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
		position1 = new Coordinate(41.40338, 2.17403);
		position2 = new Coordinate(41.40345, 2.17402);
		position3 = new Coordinate(51.40344, 2.17402);
		marker1 = new PokeMarker(position1, null, null, null) ;// my position 
		marker2 = new PokeMarker(position2, null, null, null) ;
		marker3 = new PokeMarker(position3, null, null, null) ;
		
		
		listPokeMarker.put(3, marker3);
	}

	@Test
	public void test() {
		listPokeMarker.put(2, marker2);
		PokemonsAroundMe = GeoLocaLisation.pokemonsAroundMe(listPokeMarker, 100, position1);
		assertEquals(PokemonsAroundMe.size(), 1);
		// ajouter un marker mais il est plus loin aue le rayon de recherche   
		listPokeMarker.put(3, marker3);
		PokemonsAroundMe = GeoLocaLisation.pokemonsAroundMe(listPokeMarker, 100, position1);
		assertEquals(PokemonsAroundMe.size(), 1);
	}

}
