package be.ac.ulb.infof307.g07.Models;

import java.util.List;

public class Pokemon {
    private final int id;
    private final String name;
    private final String imagePath;
    private final int base_experience;
    private final int height;
    private final int weight;
    private final String[] types;
    
    public Pokemon(int id, String name, String imagePath, int base_experience, int height, int weight, String[] types) {
        this.id = id;
        this.name = name;
        this.imagePath = imagePath;
        this.base_experience = base_experience;
        this.height = height;
        this.weight = weight;
        this.types = types;
    }
    
    public String toString(){
        
        String res = "";
        
        res += this.id +" : "+ this.name;
        
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
}
