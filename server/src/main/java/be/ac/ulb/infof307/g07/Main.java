package be.ac.ulb.infof307.g07;

import static spark.Spark.*;

import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.Datastore;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;
import java.util.Arrays;

import be.ac.ulb.infof307.g07.views.PokemonView;

public class Main {
    public static void main(final String[] args) throws UnknownHostException {
        final Morphia morphia = new Morphia();

        morphia.mapPackage("be.ac.ulb.infof307.g07");

        Datastore datastore = null;
        try {
            // connect to the database running on localhost with the default port
            datastore = morphia.createDatastore(new MongoClient(), "gmta");
            datastore.ensureIndexes();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        PokemonView.init(datastore);

        //notFound((req, res) -> {
        //    res.type("application/json");
        //    return "{\"message\":\"404 not found\"}";
        //});

        //internalServerError((req, res) -> {
        //    res.type("application/json");
        //    return "{\"message\":\"500 server error\"}";
        //});
    }
}
