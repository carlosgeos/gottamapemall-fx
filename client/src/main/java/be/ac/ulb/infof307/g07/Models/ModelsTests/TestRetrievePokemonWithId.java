package be.ac.ulb.infof307.g07.Models.ModelsTests;

import static org.junit.Assert.*;

import org.junit.Test;

import be.ac.ulb.infof307.g07.Models.Pokedex;
import be.ac.ulb.infof307.g07.Models.Pokemon;

public class TestRetrievePokemonWithId {
	Pokedex pokedex = new Pokedex();
	

	@Test
	public void testIsPokemonRetrievedWithId() {
		int pokemonId = 1;
		Pokemon pokemon = this.pokedex.getPokemonWithId(pokemonId);
		System.out.println(pokemon.getId());
		assertEquals(pokemon.getId(),pokemonId);
		
	}

}
