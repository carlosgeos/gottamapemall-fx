package be.ac.ulb.infof307.g07.models;

import java.util.HashMap;

public class Pokedex {

	
	private HashMap<Integer, Pokemon> pokemons = new HashMap<Integer, Pokemon>();
	
	public void init(){
		
		// to to ask server to load all pokemon
		
	}
	
	public String toString(){
		
		String output = "";
		
		for( Integer pokemonId : pokemons.keySet()){
			
			output += pokemons.get(pokemonId).toString();
			output +="\n";
		}
		
		return output;
		
	}
	
	public final Pokemon getPokemon( int pokemonId ){
		
		Pokemon res = null;
		
		try {

			res = pokemons.get(pokemonId);
			
		} catch (IndexOutOfBoundsException error) {

			throw error;
		}
		
		return res;
		
	}
	
	
	
}
