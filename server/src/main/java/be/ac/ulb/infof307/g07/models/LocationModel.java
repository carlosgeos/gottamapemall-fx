package be.ac.ulb.infof307.g07.models;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;
import org.mongodb.morphia.annotations.IndexOptions;

import be.ac.ulb.infof307.g07.models.PokemonModel;

/**
 * Model pour sauvegarder les markers leurs position 
 * et le pokemon associé.
 * Ce model n'a pas vocation à être instancié à la main il est là pour décrire 
 * la forme à la base de donnée ou être instancié par la librairie Gson qui n'a pas
 * besoin de constructeur.
 */
@Entity("location")
public class LocationModel {
    @Id
    private ObjectId id;
    // @Indexed(options=@IndexOptions(unique=true))
    // private int id;
    private float lat;
    private float lon;
    private PokemonModel pokemon;
    private String date;
    private String time;
}
