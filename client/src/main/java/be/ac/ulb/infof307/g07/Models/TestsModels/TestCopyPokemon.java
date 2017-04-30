package be.ac.ulb.infof307.g07.Models.TestsModels;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.ac.ulb.infof307.g07.Models.Pokemon;

public class TestCopyPokemon {
	Pokemon pokemon; 
	Pokemon pokemon2;
	@Before
	public void setUp() throws Exception {
		this.pokemon = new Pokemon(25,"Bulbasaur","http://www.pkparaiso.com/imagenes/xy/sprites/animados/bulbasaur.gif",33,2,3,null);
		this.pokemon2 = new Pokemon(this.pokemon);

	}
	
	@Test
	public void testIsDeepCopy() {
		assert(this.pokemon != this.pokemon2);
	}
	
	@Test
	public void testIsSamePokemon() {
		assert(this.pokemon.equals(this.pokemon2));
		
	}

}
