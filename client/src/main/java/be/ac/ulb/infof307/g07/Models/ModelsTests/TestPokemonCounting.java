package be.ac.ulb.infof307.g07.Models.ModelsTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.ac.ulb.infof307.g07.Models.Pokemon;

public class TestPokemonCounting {


	@Test
	public void testIncreaseCounting() {
		Pokemon pokemon = new Pokemon(25,"Bulbasaur","http://www.pkparaiso.com/imagenes/xy/sprites/animados/bulbasaur.gif",33,2,3,null);
		pokemon.increaseGlobalCounting();
		assertEquals(pokemon.getGlobalCounting(),1);
	}

	@Test
	public void testDecreaseCounting() {
		Pokemon pokemon = new Pokemon(25,"Bulbasaur","http://www.pkparaiso.com/imagenes/xy/sprites/animados/bulbasaur.gif",33,2,3,null);
		pokemon.increaseGlobalCounting();
		pokemon.decreaseGlobalCounting();
		assertEquals(pokemon.getGlobalCounting(),0);
	}
	
}
