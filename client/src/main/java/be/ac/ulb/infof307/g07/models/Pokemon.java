package be.ac.ulb.infof307.g07.models;

import java.util.ArrayList;

public class Pokemon {
    // private transient ArrayList<PokemonListener> listeners = new ArrayList<PokemonListener>();
    private transient int globalCounting = 0;
    private final int id;
    private final String name;
    private final int base_experience;
    private final int height;
    private final int weight;
    private final String[] types;

    /**
     * Constructeur
     */
    public Pokemon(int id, String name, int base_experience, int height, int weight, String[] types) {
        this.id = id;
        this.name = name;
        this.base_experience = base_experience;
        this.height = height;
        this.weight = weight;
        this.types = types;
    }

    /**
     * constructeur de copie
     */
    public Pokemon(Pokemon pokemon){
        this.id = pokemon.id;
        this.name = pokemon.name;
        this.base_experience = pokemon.base_experience;
        this.height = pokemon.height;
        this.weight = pokemon.weight;
        this.types = pokemon.types;
    }

    /**
     * Incremente le nombre d efois que ce pokemon a ete ajoute
     */
    // public void increaseGlobalCounting() {
    //     this.globalCounting += 1;
    //     for(PokemonListener listener : this.listeners){
    //         listener.onChangeGlobalCount();
    //     }
    // }

    /**
     * Decremente le nombre d efois que ce pokemon a ete ajoute
     */
    // public void decreaseGlobalCounting(){
    //     if (this.globalCounting > 0){
    //         this.globalCounting -= 1;
    //         for(PokemonListener listener : this.listeners){
    //             listener.onChangeGlobalCount();
    //         }
    //     }
    // }

    /**
     * Renvoie le numero de fois que ce pokemon a ete ajoute
     */
    public final int getGlobalCounting(){
        return this.globalCounting;
    }

    /**
     * Ajoute le listener pour ce pokemon
     *
     * @param newListener listener utilise pour mettre a jour le nombre de pokemons egaux qui se trouvent sur la map
     */
    // public void addListener(PokemonListener newListener) {
    //     this.listeners.add(newListener);
    // }

    /**
     * Renvoie la representation en string du pokemon
     *
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
     * Renvoie l'id du pokemon
     */
    public final int getId() {
        return this.id;
    }

    /**
     * Revoie l'id comme une chaine de charactère.
     *
     * @return L'id sous forme de String.
     */
    public final String getIdAsString() {
        return Integer.toString(this.id);
    }

    /**
     * Renvoie le nom du pokemon
     */
    public final String getName() {
        return this.name;
    }

    /**
     * Renvoie la liste de types du pokemon
     *
     */
    public final String[] getTypes() {
        return this.types;
    }

    /**
     * Renvoie les types sous forme de chaine de charactère
     */
    public String getTypesAsString() {
        String result = "";
        for (int i = 0; i < this.types.length; ++i) {
            result += this.types[i];
            result += ",";
        }

        return result;
    }

    /**
     * Renvoie le chemin de l'image du pokémon.
     */
    public String getImagePath() {
        return new String("pokemon_gifs/" + this.getIdAsString() + ".gif");
    }

    /**
     * Renvoie la largeur du pokemon
     *
     */
    public final int getWeight() {
        return this.weight;
    }

    /**
     * Revoie le weight comme une chaine de charactère.
     *
     * @return Le weight sous forme de String.
     */
    public final String getWeightAsString() {
        return Integer.toString(this.weight);
    }

    /**
     * Renvoie la hauteur du pokemon
     *
     */
    public final int getHeight() {
        return this.height;
    }

    /**
     * Revoie la height comme une chaine de charactère.
     *
     * @return La height sous forme de String.
     */
    public final String getHeightAsString() {
        return Integer.toString(this.height);
    }

    /**
     * Renvoie vrai si deux pokemon contiennent exactement les mêmes attributs
     * @param otherPokemon Le pokemon avec lequel l'objet sera comparé
     */
    public boolean equals (Pokemon otherPokemon) {
        boolean res;
        res = this.id == otherPokemon.id &&
            this.name == otherPokemon.name &&
            this.base_experience == otherPokemon.base_experience &&
            this.height == otherPokemon.height &&
            this.weight == otherPokemon.weight &&
            this.types == otherPokemon.types;

        return res;
    }
}
