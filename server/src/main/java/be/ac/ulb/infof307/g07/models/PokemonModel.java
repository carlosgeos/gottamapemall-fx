package be.ac.ulb.infof307.g07.models;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("pokemon")
public class PokemonModel {
    @Id
    private ObjectId id;
    private String name;

    public PokemonModel (final String name) {
        this.name = name;
    }

    public ObjectId getId () {
        return id;
    }

    public String getName () {
        return name;
    }
}
