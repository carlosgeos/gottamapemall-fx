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
	private PokeMarker marker1;
	private PokeMarker marker2;
	private PokeMarker marker3;
	private ArrayList<Integer> PokemonsAroundMe;
	@Before
	public void setUp() throws Exception {
		listPokeMarker = new HashMap<Integer, PokeMarker> ();
		marker1 = new PokeMarker(new Coordinate(41.40338, 2.17403), null, null, null) ;// my position 
		marker2 = new PokeMarker(new Coordinate(41.40345, 2.17402), null, null, null) ;
		marker3 = new PokeMarker(new Coordinate(51.40344, 2.17402), null, null, null) ;
		
		
		listPokeMarker.put(3, marker3);
	}

	@Test
	public void test() {
		listPokeMarker.put(2, marker2);
		PokemonsAroundMe = GeoLocaLisation.PokemonsAroundMe(listPokeMarker, 100, marker1);
		assertEquals(PokemonsAroundMe.size(), 1);
		// ajouter un marker mais il est plus loin aue le rayon de recherche   
		listPokeMarker.put(3, marker3);
		PokemonsAroundMe = GeoLocaLisation.PokemonsAroundMe(listPokeMarker, 100, marker1);
		assertEquals(PokemonsAroundMe.size(), 1);
	}

}
