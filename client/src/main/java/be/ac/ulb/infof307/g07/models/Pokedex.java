package be.ac.ulb.infof307.g07.models;

import java.util.HashMap;

public class Pokedex {

	private HashMap<Integer, Pokemon> pokemons = new HashMap<Integer, Pokemon>();
	private static Pokedex instance = null;
	private int selectedPokemon = 0;
	
	public Pokedex(){
		
		init();
	}
	
	public static Pokedex getInstance (){
		if (instance == null){
			instance = new Pokedex();
		}
		return instance;
	} 
	
	public void init(){
		
		// todo ask server to load all pokemon
		
		String[] type = {"Grass"};
		pokemons.put(1, new Pokemon(1, "Bulbasaur", 0.2, 0.2, type));
		
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
	
	public final Integer[] getPokemonsId(){
		
		Integer[] res = new Integer[pokemons.size()];
		int index = 0;
		
		for( int id:pokemons.keySet()){
			res[index] = id;
			++index;
		}
		return res;
	}
	
	public void setSelectedPokemon(int pokemonId){
		selectedPokemon = pokemonId;
	}
	
	public Pokemon getSelectedPokemon(){
		return getPokemon(selectedPokemon);
	}
	
	public final HashMap<Integer, Pokemon> getPokemons(){
		return pokemons;
	}
}
