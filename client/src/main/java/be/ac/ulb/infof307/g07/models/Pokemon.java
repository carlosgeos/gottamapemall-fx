package be.ac.ulb.infof307.g07.models;

public class Pokemon {

	private int id;
	private String name;
	private double weight;
	private double height;
	
	public Pokemon( int newId, String newName, double newWeight, double newHeight ){
		
		id = newId;
		name = newName;
		weight = newWeight;
		height = newHeight;
		
	}
	
	public boolean equals( Pokemon otherPokemon){
		
		return id==otherPokemon.id && name == otherPokemon.name && weight == otherPokemon.weight && height == otherPokemon.height;
		
	}
	
	public String toString(){
		
		String output = "";
		
		output += Integer.toString(id);
		output += " : "+name;
		output += ", "+Double.toString(weight);
		output += ", " + Double.toString(height);
		
		return output;
	}
	
	public final int getId(){
		
		return id;
		
	}
	
	public final String getName(){
		
		return name;
		
	}
	
	public final double getWeight(){
		
		return weight;
	}
	
	public final double getHeight(){
		
		return height;
	}
	
}
