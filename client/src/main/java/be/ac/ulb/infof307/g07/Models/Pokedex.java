package be.ac.ulb.infof307.g07.Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Pokedex {

	private ObservableList<Pokemon> pokemonInPokedex;
	
	public Pokedex(){
		// instance the list for stocking pokemon
        this.pokemonInPokedex = FXCollections.observableArrayList();
		
		fillPokedex();
		
	}
	
	private void fillPokedex(){
    	
    	//hardcoded pokemons for TESTS while problem with database isn't solved.
		String[] types = new String[2];
		types[0] = "watah";
		types[1] = "fyia";
		
    	pokemonInPokedex.add(new Pokemon(1,"Bulbasaur","http://www.pkparaiso.com/imagenes/xy/sprites/animados/bulbasaur.gif",33,2,3,types));
    	pokemonInPokedex.add(new Pokemon(2,"Ivysaur","http://www.pkparaiso.com/imagenes/xy/sprites/animados/ivysaur.gif",33,2,3,types));
    	pokemonInPokedex.add(new Pokemon(3,"Venusaur","http://www.pkparaiso.com/imagenes/xy/sprites/animados/venusaur.gif",33,2,3,types));
    	pokemonInPokedex.add(new Pokemon(4,"Charmander","http://www.pkparaiso.com/imagenes/xy/sprites/animados/charmander.gif",33,2,3,types));
    	pokemonInPokedex.add(new Pokemon(5,"Charmeleon","http://www.pkparaiso.com/imagenes/xy/sprites/animados/charmeleon.gif",33,2,3,types));
    	pokemonInPokedex.add(new Pokemon(6,"Charizard","http://www.pkparaiso.com/imagenes/xy/sprites/animados/charizard.gif",33,2,3,types));
    	pokemonInPokedex.add(new Pokemon(7,"Squirtle","http://www.pkparaiso.com/imagenes/xy/sprites/animados/squirtle.gif",33,2,3,types));
    	    	
    	/*
        String response = Requests.get("http://127.0.0.1:4567/pokemons").send().readToText();
        Gson gson = new Gson();
        Pokemon[] pokemons = gson.fromJson(response, Pokemon[].class);

        for (int i = 0; i < pokemons.length; ++i) {
            pokemonInPokedex.add(pokemons[i]);
        }
   		*/
    }

	
	public final int getSize(){
		
		return this.pokemonInPokedex.size();
		
	}
	
	public final Pokemon getPokemon(int index){
		
		return this.pokemonInPokedex.get(index);
		
	}
	
	public final Pokemon getPokemonWithId(int id){
		
		Pokemon res;
		int index = 0;
		int size = this.pokemonInPokedex.size();
		boolean found = false;
		
		while((index<size)&&(!found)){
			
			if(this.pokemonInPokedex.get(index).getId() == id){
				
				found = true;
				
			}else{
			++index;
			}
		}
		
		res = this.pokemonInPokedex.get(index);
		return res;
	}
	
	
	
}
