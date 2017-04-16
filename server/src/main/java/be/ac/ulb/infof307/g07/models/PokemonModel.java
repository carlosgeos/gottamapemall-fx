package be.ac.ulb.infof307.g07.models;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;

import java.util.Map;

import be.ac.ulb.infof307.g07.lib.models.GenericModel;

@Entity("pokemon")
public class PokemonModel implements GenericModel {
    @Id
    private ObjectId _id;

    @Indexed(unique=true)
    private int id;

    @Indexed(unique=true)
    private String name;

    private int weight;
    private int height;

    public PokemonModel () {}

    public void set(final Map<String, String[]> map) throws Exception {
        if (map.containsKey("id")) {
            this.id = Integer.parseInt(map.get("id")[0]);
        } else {
            throw new Exception("Wrong id");
        }

        if (map.containsKey("name")) {
            this.name = map.get("name")[0];
        } else {
            throw new Exception("Wrong name");
        }

        if (map.containsKey("weight")) {
            this.weight = Integer.parseInt(map.get("weight")[0]);
        }

        if (map.containsKey("height")) {
            this.height = Integer.parseInt(map.get("height")[0]);
        }
    }

    public int getId () {
        return this.id;
    }

    public String getName () {
        return this.name;
    }
}