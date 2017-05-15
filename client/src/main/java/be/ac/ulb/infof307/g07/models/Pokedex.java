package be.ac.ulb.infof307.g07.models;

import java.util.HashMap;

import com.google.gson.Gson;

import net.dongliu.requests.Requests;

public class Pokedex {

	private HashMap<Integer, Pokemon> pokemons = new HashMap<Integer, Pokemon>();
	private static Pokedex instance = null;
	private int selectedPokemon = 0;
	
	public Pokedex(){
		System.out.println("Creating Pokedex....");
		init();
		System.out.println("Finish loading all pokemon....");
	}
	
	public static Pokedex getInstance (){
		if (instance == null){
			instance = new Pokedex();
		}
		return instance;
	} 
	
	public void init(){
		/*
		String response = Requests.get("http://127.0.0.1:4567/pokemons").send().readToText();
		System.out.println(response);
		Gson gson = new Gson();
		Pokemon[] pokemonsFromServer = gson.fromJson(response, Pokemon[].class);

		for (int i = 0; i < pokemonsFromServer.length; ++i) {
			Pokemon pokemon = pokemonsFromServer[i];
			pokemons.put(pokemon.getId(), pokemon);
		}
		*/
		
		String[] types = {"Grass"};
		pokemons.put(1, new Pokemon(1, "Bulbasaur", "path", 60, 60, 60, types));
		pokemons.put(2, new Pokemon(2, "Bulbasaur", "path", 60, 60, 60, types));
		pokemons.put(3, new Pokemon(3, "Bulbasaur", "path", 60, 60, 60, types));
		pokemons.put(4, new Pokemon(4, "Bulbasaur", "path", 60, 60, 60, types));
		
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
	
	public Pokemon getSelectedPokemon(){
		return getPokemon(selectedPokemon);
	}
	
	public final HashMap<Integer, Pokemon> getPokemons(){
		return pokemons;
	}
}
