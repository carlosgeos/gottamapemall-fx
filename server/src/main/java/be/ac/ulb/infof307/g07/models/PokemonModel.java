package be.ac.ulb.infof307.g07.models;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;
import org.mongodb.morphia.annotations.IndexOptions;

import java.util.List;

/**
 * Model pour sauvegarder les pokémons et leurs caractéristiques.
 * Ce model n'a pas vocation à être instancié à la main il est là pour décrire 
 * la forme à la base de donnée ou être instancié par la librairie Gson qui n'a pas
 * besoin de constructeur.
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
