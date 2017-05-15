package be.ac.ulb.infof307.g07.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestPokemonCounting {
    @Test
    public void testIncreaseCounting() {
        Pokemon pokemon = new Pokemon(25,"Bulbasaur","http://www.pkparaiso.com/imagenes/xy/sprites/animados/bulbasaur.gif",33,2,3,null);
        pokemon.incSignalCount();
        assertEquals(pokemon.getSignalisationCount(),1);
    }

    @Test
    public void testDecreaseCounting() {
        Pokemon pokemon = new Pokemon(25,"Bulbasaur","http://www.pkparaiso.com/imagenes/xy/sprites/animados/bulbasaur.gif",33,2,3,null);
        pokemon.incSignalCount();
        pokemon.decSignalCount();
        assertEquals(pokemon.getSignalisationCount(),0);
    }
}
