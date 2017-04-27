package be.ac.ulb.infof307.g07.lib;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.bson.types.ObjectId;

import be.ac.ulb.infof307.g07.lib.serializers.ObjectIdSerializer;

/**
 * Handle the gson creation globally with custom serializers for each objects.
 */
public class CustomGson {
    static private Gson gson = null;

    /**
     * Create a custom gson instance.
     */
    static public void create () {
        GsonBuilder gsonBuild = new GsonBuilder();
        gsonBuild.registerTypeAdapter(ObjectId.class, new ObjectIdSerializer());
        gson = gsonBuild.create();
    }

    /**
     * Get the custom gson instance with custom serializers.
     */
    static public Gson get () {
        return gson;
    }
}
