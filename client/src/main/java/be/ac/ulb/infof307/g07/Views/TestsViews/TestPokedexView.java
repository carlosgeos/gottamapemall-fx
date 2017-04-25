package be.ac.ulb.infof307.g07.Views.TestsViews;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import be.ac.ulb.infof307.g07.Views.PokedexView;

public class TestPokedexView {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIncreasePokemonCounting() {
		PokedexView pokedexView = new PokedexView();
		PokedexView.increasePokemonCounting(25);
		assertEquals(PokedexView.markedPokemonCounting.size(),1);
		
		PokedexView.increasePokemonCounting(33);
		assertEquals(PokedexView.markedPokemonCounting.size(),2);
		
		PokedexView.increasePokemonCounting(25);
		assertEquals(PokedexView.markedPokemonCounting.size(),2);
		
		int currentValue25 = PokedexView.markedPokemonCounting.get(25);
		assertEquals(currentValue25, 2);
		
		int currentValue33 = PokedexView.markedPokemonCounting.get(33);
		assertEquals(currentValue33, 1);


		


		
		
		
		
	}

}
