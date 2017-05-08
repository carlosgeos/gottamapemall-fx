package be.ac.ulb.infof307.g07.models;

import java.util.ArrayList;
import be.ac.ulb.infof307.g07.controllers.PokemonListener;

/**
 * 
 * Cette classe contient les données (modèle) relatives à un pokemon.
 * 
 * @version 1.0
 *
 */
public class Pokemon {
	
	//TODO: TBD...?
	/**
	 * 
	 */
    private transient ArrayList<PokemonListener> listeners = new ArrayList<PokemonListener>();
    
    /**
     * le nombre de fois qu'on a ajouté le pokemon sur la carte, utilisé pour onPokemonGlobalCountChangeHandler et PokemonView
     * 
     * @see be.ac.ulb.infof307.g07.controllers.Handlers.onPokemonGlobalCountChangeHandler
     * @see be.ac.ulb.infof307.g07.views.PokemonView
     * @see be.ac.ulb.infof307.g07.views.PokemonView#globalCountLabel
     * @see be.ac.ulb.infof307.g07.views.PokemonView#refreshCount()
     */
    private transient int globalCounting = 0;
    
    /**
     * l'identifiant unique et nécessairement constant, (nombre entier) du pokemon
     */
    private final int id;
    
    /**
     * le nom unique et constant, du pokemon
     */
    private final String name;
    
    /**
     * le chemin unique et constant de l'image du pokemon
     */
    private final String imagePath;
    
    //TODO: TBD ...
    /**
     * 
     */
    private final int base_experience;
    
    /**
     * la taille unique et constante, du pokemon (nombre entier, en mètres)
     */
    private final int height;
    
    /**
     * le poids unique et constant du pokemon (nombre entier, en kilogrammes)
     */
    private final int weight;
    
    /**
     * les types (constants), du pokemon
     */
    private final String[] types;
    
    //TODO: faire base_experience !!
    /**
     * Constructeur de Pokemon
     * 
     * @param id l'identifiant du pokemon
     * @param name le nom du pokemon
     * @param imagePath le chemin vers l'image du pokemon
     * @param base_experience le niveau de base du pokemon?
     * @param height la taille du pokemon (en mètres)
     * @param weight le poids du pokemon (en kilogrammes)
     * @param types le ou les types du pokemon (feu, vol, eau, etc...)
     */
    public Pokemon(int id, String name, String imagePath, int base_experience, int height, int weight, String[] types) {
        this.id = id;
        this.name = name;
        this.imagePath = imagePath;
        this.base_experience = base_experience;
        this.height = height;
        this.weight = weight;
        this.types = types;
        
    }
    
    /**
     * Constructeur de copie d'un pokemon 
     * 
     * @param pokemon Le pokemon qu'on souhaite copier
     */
    public Pokemon(Pokemon pokemon){
        this.id = pokemon.id;
        this.name = pokemon.name;
        this.imagePath = pokemon.imagePath;
        this.base_experience = pokemon.base_experience;
        this.height = pokemon.height;
        this.weight = pokemon.weight;
        this.types = pokemon.types;
    }
    
    /**
     * Incrémente le nombre de fois que ce pokemon a été ajouté
     * 
     * @see be.ac.ulb.infof307.g07.controllers.PokemonListener
     */ 
    public void increaseGlobalCounting() {
        this.globalCounting += 1;
        for(PokemonListener listener : this.listeners){
            listener.onChangeGlobalCount();
        }
    }
    
    /**
     * Décrémente le nombre de fois que ce pokemon a été ajouté
     * 
     * @see be.ac.ulb.infof307.g07.controllers.PokemonListener
     */  
    public void decreaseGlobalCounting(){
        if (this.globalCounting > 0){
            this.globalCounting -= 1;
            for(PokemonListener listener : this.listeners){
                listener.onChangeGlobalCount();
            }
        }
    }
    
   /**
    * Renvoie le nombre de fois que ce pokemon a été ajouté sur la carte
    *  
    * @return le compteur de repérages du pokemon sur la carte (nombre de signalisations), sous forme d'une entier constant 
    */
    public final int getGlobalCounting(){
        return this.globalCounting;
    }
    
    /**
     * Ajoute le listener pour ce pokemon
     *
     * @param newListener listener utilisé pour mettre à jour le nombre de pokemons d'un certain type (= pokémons identiques) qui se trouvent sur la map
     * @see be.ac.ulb.infof307.g07.controllers.PokemonListener
     */  
    public void addListener(PokemonListener newListener) {
        this.listeners.add(newListener);
    }
    
    /**
     * Renvoie la représentation en chaîne de caractères (string) du pokemon
     * 
     * @return Une chaîne de caractères contenant les informations du pokémon (id, nom, expérience de base, taille, poids et types)
     */  
    public String toString() {
        String res = "";
        res += this.id + ":" + this.name + ":" + this.base_experience + ":" + this.height + ":" + this.weight;
        for (int i = 0 ; i<this.types.length ; ++i){
            res += ":" + this.types[i];
        }
        return res;
    }
    
    /**
     * Renvoie l'identifiant (id) du pokemon
     * 
     * @return L'identifiant unique (et constant) du pokemon, sous forme d'un nombre entier constant
     */  
    public final int getId() {
        return this.id;
    }
    
    /**
     * Renvoie le nom du pokemon
     * 
     * @return Le nom du pokemon, sous forme d'une chaîne de caractères constante
     */  
    public final String getName() {
        return this.name;
    }
    
    /**
     * Renvoie le lien vers l'icône (image) du pokemon
     * 
     * @return Le chemin vers l'image du pokemon
     */  
    public final String getImagePath() {
        return this.imagePath;
    }
    
    /**
     * Renvoie la liste des types du pokemon
     * 
     * @return La liste des types du pokemon, sous forme d'un tableau de chaînes de caractères
     */  
    public final String[] getTypes() {
        return this.types;
    }

    /**
     * Renvoie le poids du pokemon
     * 
     * @return Le poids du pokemon (en kilo), sous forme d'un nombre entier constant
     */  
    public final int getWeight () {
        return this.weight;
    }

    /**
     * Renvoie la taille du pokemon
     * 
     * @return La taille du pokemon (en mètres), sous forme d'un nombre entier constant
     */    
    public final int getHeight () {
        return this.height;
    }

    /**
     * Renvoie vrai si deux pokemon contiennent exactement les mêmes attributs (id, nom, expérience de base, taille, poids et types)
     * 
     * @param otherPokemon Le pokemon avec lequel l'objet sera comparé
     * 
     * @return Le résultat de la comparaison (true or false)
     */    
    public boolean equals (Pokemon otherPokemon) {
        boolean res;
        res = this.id == otherPokemon.id && 
            this.name == otherPokemon.name && 
            this.imagePath == otherPokemon.imagePath &&
            this.base_experience == otherPokemon.base_experience &&
            this.height == otherPokemon.height &&
            this.weight == otherPokemon.weight &&
            this.types == otherPokemon.types;
        
        return res;
    }
}
