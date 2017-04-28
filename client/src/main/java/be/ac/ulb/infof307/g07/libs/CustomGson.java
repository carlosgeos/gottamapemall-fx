package be.ac.ulb.infof307.g07.libs;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.bson.types.ObjectId;
import be.ac.ulb.infof307.g07.Models.Pokemon;

import be.ac.ulb.infof307.g07.libs.serializers.ObjectIdSerializer;
import be.ac.ulb.infof307.g07.libs.serializers.PokemonSerializer;

/**
 * Gère la création d'une instance `gson` de manière globale.
 */
public class CustomGson {
    static private Gson gson = null;

    /**
     * Crée l'instance `gson` avec des serializers particuliés.
     */
    static public void create () {
        GsonBuilder gsonBuild = new GsonBuilder();
        gsonBuild.registerTypeAdapter(ObjectId.class, new ObjectIdSerializer());
        gsonBuild.registerTypeAdapter(Pokemon.class, new PokemonSerializer());
        gson = gsonBuild.create();
    }

    /**
     * Récupère l'instance `gson`.
     */
    static public Gson get () {
        return gson;
    }
}

