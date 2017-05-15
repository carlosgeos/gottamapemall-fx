package be.ac.ulb.infof307.g07.models;

import java.util.ArrayList;

import be.ac.ulb.infof307.g07.PokemonListener;

/**
 * La classe pokemon stocke l information d'un pokemon. Par exemple le nom, le poids, la taille etc. 
 * Chaque Pokemon sera cree et stocke dans la classe Pokedex. 
 * 
 *@see Pokedex
 */
public class Pokemon {

	public transient final static String imageType = ".png";
	private transient int numberOfSignalisation = 0;
	private int id;
	private String name;
	private int base_experience;
	private double weight;
	private double height;
	private String[] types;
	private transient ArrayList<PokemonListener> listener = new ArrayList<PokemonListener>();
	
	/**
	 * Le constructeur de la classe Pokemon.
	 * 
	 * @param newId 
	 * @param newName 
	 * @param newWeight 
	 * @param newHeight 
	 * @param newTypes 
	 */
	public Pokemon(int id, String name, String imagePath, int base_experience, int height, int weight, String[] types){
		id = id;
		name = name;
		base_experience=base_experience;
		weight = weight;
		height = height;
		types = types;
	}
	
	/**
	 * Cette methode sert a tester si deux pokemons sont egaux.
	 * 
	 * @param otherPokemon le pokemon a comparer
	 * @return si c est egaux
	 */
	public boolean equals( Pokemon otherPokemon){
		return id==otherPokemon.id && name == otherPokemon.name && weight == otherPokemon.weight && height == otherPokemon.height;
	}
	
	/**
	 * Cette methode prepare un output pour pouvoir imprimer les attributs.
	 * 
	 * @return un output de type String
	 */
	public String toString(){
		String output = "";
		output += Integer.toString(id);
		output += " : "+name;
		output += ", "+Double.toString(weight);
		output += ", " + Double.toString(height);
		return output;
	}
	/**
	 * Retourne l unique id du pokemon
	 * 
	 * @return un id unique constante
	 */
	public final int getId(){
		return id;
	}
	
	/**
	 * Retourne le nom du Pokemon
	 * 
	 * @return le nom du Pokemon
	 */
	public final String getName(){
		return name;
	}
	
	/**
	 * Retourne le poids du Pokemon
	 * 
	 * @return le poids du Pokemon
	 */
	public final double getWeight(){
		return weight;
	}
	
	/**
	 * Retourne la taille du Pokemon
	 * 
	 * @return la taille du Pokemon
	 */
	public final double getHeight(){
		return height;
	}
	
	/**
	 * Retourne un Array de type du Pokemon
	 * 
	 * @return un Array de type
	 */
	public final String[] getType(){
		return types;
	}
	
	/**
	 * Increment le compteur de Signalisation du Pokemon sur le Map.
	 * Cest un compteur globale qui compte le nombre de fois que le pokemon a ete signaler.
	 * 
	 */
	public void incSignalCount(){
		System.out.println("Incrementing.....Old value : "+Integer.toString(numberOfSignalisation));
		++numberOfSignalisation;
		System.out.println("Incrementing.....new value : "+Integer.toString(numberOfSignalisation));
		callListener();
	}
	
	/**
	 * 
	 * Decrement le compteur de Signalisation du Pokemon sur le Map.
	 * Cest un compteur global qui compte le nombre de fois que le pokemon a ete signaler.
	 * 
	 */
	public void decSignalCount(){
		--numberOfSignalisation;
		callListener();
	}
	/**
	 * Retourne le chemin de l image du Pokemon.
	 * 
	 * @return le chemin
	 */
	public final String getImagePath(){
		return Integer.toString(id)+imageType;
	}
	
	public final int getSignalisationCount(){
		return numberOfSignalisation;
	}
	
	public void addListener( PokemonListener newListener ){
		listener.add(newListener);
	}
	
	private void callListener(){
		System.out.println("Listener called...");
		for( PokemonListener l:listener ){
			l.onChangeSignalisation();
		}
	}
}
