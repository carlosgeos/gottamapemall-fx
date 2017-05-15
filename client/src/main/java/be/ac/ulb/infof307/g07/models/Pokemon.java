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

	public final static String imagePathLink ="https://www.pkparaiso.com/imagenes/shuffle/sprites/";
	private final String imageLink;
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
	 * @param newId id du pokemon
	 * @param newName nom du pokemon
   * @param imagePath path vers l icon
	 * @param newBase_experience experience du pokemon
	 * @param newWeight poids du pokemon
	 * @param newHeight taille du pokemon
	 * @param newTypes types du pokemon
	 */
	public Pokemon(int newId, String newName, String imagePath, int newBase_experience, int newWeight, int newHeight, String[] newTypes){
		id = newId;
		name = newName;
		base_experience=newBase_experience;
		weight = newWeight;
		height = newHeight;
		types = newTypes;
		imageLink = imagePathLink + String.format("%03d",id)+".png";
	}
	
	/**
	 * Cette methode sert a tester si deux pokemons sont egaux.
	 * 
	 * @param otherPokemon le pokemon a comparer
	 * @return si ils sont egaux
	 */
	public boolean equals(Pokemon otherPokemon){
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
	 * Renvoie l id unique du pokemon
	 * 
	 * @return un id unique constante
	 */
	public final int getId(){
		return id;
	}
	
	/**
	 * Renvoie le nom du Pokemon
	 * 
	 * @return le nom du Pokemon
	 */
	public final String getName(){
		return name;
	}
	
	/**
	 * Renvoie le poids du Pokemon
	 * 
	 * @return le poids du Pokemon
	 */
	public final double getWeight(){
		return weight;
	}
	
	/**
	 * Renvoie la taille du Pokemon
	 * 
	 * @return la taille du Pokemon
	 */
	public final double getHeight(){
		return height;
	}
	
	/**
	 * Renvoie un Array de type du Pokemon
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
	 * Renvoie le chemin de l image du Pokemon.
	 * 
	 * @return le chemin
	 */
	public final String getImagePath(){
		return Integer.toString(id)+imageType;
	}
	
	/**
	 * Renvoie le nombre de fois qu un pokemon ait etet signale.
	 * 
	 * @return nombre de signalisations
	 */
	public final int getSignalisationCount(){
		return numberOfSignalisation;
	}
	
	/**
	 * Assigne un listener de type PokemonListener a un pokemon
	 * 
	 */
	public void addListener(PokemonListener newListener){
		listener.add(newListener);
	}
	

	/**
	 * Apelle l ensemble de listeners stockes dans la liste listener.
	 * 
	 */
	private void callListener(){
		System.out.println("Listener called...");
		for(PokemonListener l:listener){
			l.onChangeSignalisation();
		}
	}
	
	public String getImageLink(){
		
		return imageLink;
	}
}
