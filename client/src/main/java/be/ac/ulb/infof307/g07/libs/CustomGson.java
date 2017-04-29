package be.ac.ulb.infof307.g07.libss;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.bson.types.ObjectId;
import be.ac.ulb.infof307.g07.models.Pokemon;

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
        gson = gsonBuild.create();
    }

    /**
     * Récupère l'instance `gson`.
     *
     * @return L'instance `gson` partagée.
     */
    static public Gson get () {
        return gson;
    }
}
