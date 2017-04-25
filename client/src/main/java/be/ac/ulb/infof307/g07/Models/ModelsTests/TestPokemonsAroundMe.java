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
	private ArrayList<Integer> PokemonsAroundMe;
	@Before
	public void setUp() throws Exception {
		listPokeMarker = new HashMap<Integer, PokeMarker> ();
		marker1 = new PokeMarker(new Coordinate(41.40338, 2.17403), null, null, null) ;
		marker2 = new PokeMarker(new Coordinate(41.40398, 2.17403), null, null, null) ;
		//listPokeMarker.put(1, marker1);
		listPokeMarker.put(2, marker2);
	}

	@Test
	public void test() {
		PokemonsAroundMe = GeoLocaLisation.PokemonsAroundMe(listPokeMarker, 0.0009, marker1);
		assertEquals(PokemonsAroundMe.size(), 1);
	}

}
