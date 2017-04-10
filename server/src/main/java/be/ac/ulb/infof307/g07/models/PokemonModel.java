package be.ac.ulb.infof307.g07.models;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;

@Entity("pokemon")
public class PokemonModel {
    @Id
    private ObjectId _id;

    @Indexed(unique=true)
    private int id;

    @Indexed(unique=true)
    private String name;

    private int weight;
    private int height;

    public PokemonModel () {}

    public PokemonModel (final int id, final String name) {
        this.id = id;
        this.name = name;
        this.weight = 0;
        this.height = 0;
    }

    public PokemonModel (final int id,
                         final String name,
                         final int weight,
                         final int height) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.height = height;
    }

    public int getId () {
        return this.id;
    }

    public String getName () {
        return this.name;
    }
}
