package be.ac.ulb.infof307.g07.Models;

import java.util.ArrayList;
import java.util.List;

import be.ac.ulb.infof307.g07.Controllers.ChoosePokemonViewListener;
import be.ac.ulb.infof307.g07.Controllers.PokemonListener;

public class Pokemon {
	
	private ArrayList<PokemonListener> listeners = new ArrayList<PokemonListener>();
	
    private final int id;
    private final String name;
    private final String imagePath;
    private final int base_experience;
    private final int height;
    private final int weight;
    private final String[] types;
    private int globalCounting = 0;
    
    public Pokemon(int id, String name, String imagePath, int base_experience, int height, int weight, String[] types) {
        this.id = id;
        this.name = name;
        this.imagePath = imagePath;
        this.base_experience = base_experience;
        this.height = height;
        this.weight = weight;
        this.types = types;
        System.out.println(this.toString());
        
    }
    
    public void increaseGlobalCounting(){
    	
    	this.globalCounting += 1;
    	for(PokemonListener listener : this.listeners){

    		listener.onChangeGlobalCount();

    	}
    	
    }
    
    public void decreaseGlobalCounting(){
    	if (this.globalCounting > 0){
    		this.globalCounting -= 1;
	    	for(PokemonListener listener : this.listeners){
	
	    		listener.onChangeGlobalCount();
	
	    	}
    	}
    }
    
    public final int getGlobalCounting(){
    	return this.globalCounting;
    }
    
    public void addListener( PokemonListener newListener){
    	
    	this.listeners.add(newListener);
    	
    }
    
    
    
    public String toString(){
        
        String res = "";
        res += this.id + ":" + this.name + ":" + this.base_experience + ":" + this.height + ":" + this.weight;
        for (int i = 0 ; i<this.types.length ; ++i){
        	res += ":" + this.types[i];
        }
        return res;
        
    }
    
    public final int getId(){
        
        return this.id;
        
    }
    
    public final String getName(){
        
        return this.name;
        
    }
    
    public final String getImagePath(){
        
        return this.imagePath;

    }
    
    public final String[] getTypes(){

        return this.types;

    }

    public final int getWeight () {

        return this.weight;
    
    }

    public final int getHeight () {

        return this.height;
    
    }

    public boolean equals (Pokemon otherPokemon) {
    	return this.id == otherPokemon.id;
    }
}
