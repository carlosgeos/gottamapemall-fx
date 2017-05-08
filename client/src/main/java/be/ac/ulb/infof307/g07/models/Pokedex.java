package be.ac.ulb.infof307.g07.models;

import com.google.gson.Gson;
import net.dongliu.requests.Requests;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * 
 * Cette classe contient les données (modèle) relatives au pokedex.
 * 
 * @version 1.0
 * @see be.ac.ulb.infof307.g07.models.Pokemon
 */
public class Pokedex {
	
	/**
	 * Un objet ObservableList de javaFx pour pouvoir observer les changements subis par le pokedex
	 */
    private ObservableList<Pokemon> pokemonInPokedex;
    
    /**
     * Constructeur de Pokedex, instancie la liste pokemonInPokedex (objet observableArrayList) et appelle la méthode fillPokedex.
     * @see Pokedex#fillPokedex()
     */
    public Pokedex(){
        // instance the list for stocking pokemon
        this.pokemonInPokedex = FXCollections.observableArrayList();
        fillPokedex();
    }
    
    /**
     * Remplit la liste pokemonInPokedex avec tous les pokemons récupérés du serveur
     * 
     * @see be.ac.ulb.infof307.g07.models.Pokemon
     */
    private void fillPokedex() {
        String response = Requests.get("http://127.0.0.1:4567/pokemons").send().readToText();
        Gson gson = new Gson();
        Pokemon[] pokemons = gson.fromJson(response, Pokemon[].class);

        for (int i = 0; i < pokemons.length; ++i) {
            pokemonInPokedex.add(new Pokemon(pokemons[i]));
        }
    }
    /**
     * Renvoie la taille de du pokedex, sous forme d'un nombre entier (nombre de pokemon)
     * 
     * @return la taille de la liste pokemonInPokedex, sous forme d'un entier constant
     */
    public final int getSize(){
        return this.pokemonInPokedex.size();
    }
    
    /**
     * Renvoie un pokemon de la liste en fonction de sa position 
     * 
     * @param index la position dans la liste d'un pokemon donné
     * @return	le pokemon à la position demandée dans la liste
     */
    public final Pokemon getPokemon(int index) {
        return this.pokemonInPokedex.get(index);
    }

    /**
     * Renvoie un pokemon de la liste en fonction de son identifiant (id)
     * 
     * @param id l'identifiant du pokemon recherché
     * @return le pokemon avec l'id demandé
     * @see be.ac.ulb.infof307.g07.models.Pokemon
     */
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
