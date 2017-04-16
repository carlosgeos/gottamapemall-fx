package be.ac.ulb.infof307.g07.lib;

import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.Datastore;
import com.mongodb.MongoClient;

public class Database {
    private static Datastore datastore = null;

    Database () {}

    public static void init () {
        init("gmta");
    }

    public static void init (String db) {
        final Morphia morphia = new Morphia();
        morphia.mapPackage("be.ac.ulb.infof307.g07");

        try {
            // connect to the database running on localhost with the default port
            datastore = morphia.createDatastore(new MongoClient(), db);
            datastore.ensureIndexes();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public static Datastore get() {
        return datastore;
    }
}
