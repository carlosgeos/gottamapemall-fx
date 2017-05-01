package be.ac.ulb.infof307.g07.models;

import com.google.gson.Gson;
import net.dongliu.requests.Requests;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Pokedex {
    private ObservableList<Pokemon> pokemonInPokedex;
    
    public Pokedex(){
        // instance the list for stocking pokemon
        this.pokemonInPokedex = FXCollections.observableArrayList();
        fillPokedex();
    }
    
    private void fillPokedex() {
        String response = Requests.get("http://127.0.0.1:4567/pokemons").send().readToText();
        Gson gson = new Gson();
        Pokemon[] pokemons = gson.fromJson(response, Pokemon[].class);

        for (int i = 0; i < pokemons.length; ++i) {
            pokemonInPokedex.add(new Pokemon(pokemons[i]));
        }
    }
    
    public final int getSize(){
        return this.pokemonInPokedex.size();
    }
    
    public final Pokemon getPokemon(int index) {
        return this.pokemonInPokedex.get(index);
    }

    public final Pokemon getPokemonWithId(int id) {
        Pokemon res;
        int index = 0;
        int size = this.pokemonInPokedex.size();
        boolean found = false;
        
        while ((index < size) && (!found)) {
            if(this.pokemonInPokedex.get(index).getId() == id){
                found = true;
                
            } else {
                ++index;
            }
        }
            
        res = this.pokemonInPokedex.get(index);
        return res;
    }
}
