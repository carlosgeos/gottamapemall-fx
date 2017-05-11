package be.ac.ulb.infof307.g07.models;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * Model ayant pour but de sauvegarder les filtres que les utilisateurs
 * vont utiliser. 
 * Ce model n'a pas vocation à être instancié à la main il est là pour décrire 
 * la forme à la base de donnée ou être instancié par la librairie Gson qui n'a pas
 * besoin de constructeur.
 */
@Entity("filter")
public class FilterModel {
    @Id
    private ObjectId id;
    private String query;
}
