package be.ac.ulb.infof307.g07.models;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;
import org.mongodb.morphia.annotations.IndexOptions;

import java.util.Map;
import java.util.List;

import be.ac.ulb.infof307.g07.libs.errors.RequiredFieldException;
import be.ac.ulb.infof307.g07.libs.errors.WrongTypeFieldException;

/**
 * Model pour sauvegarder les pokémons et leurs caractéristiques.
 */
@Entity("pokemon")
public class PokemonModel {
    @Id
    private ObjectId _id;
    @Indexed(options=@IndexOptions(unique=true))
    private int id;
    @Indexed(options=@IndexOptions(unique=true))
    private String name;
    private String imagePath;
    private int base_experience;
    private int height;
    private int weight;
    private List<String> types;
}
