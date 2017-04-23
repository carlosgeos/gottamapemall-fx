package be.ac.ulb.infof307.g07.lib;

import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.Datastore;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

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
            // connect to the database on mLab
            datastore = morphia.createDatastore(new MongoClient(new MongoClientURI("mongodb://gmta:bonjourmdp@ds163010.mlab.com:63010/gmta")), "gmta");
            datastore.ensureIndexes();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public static Datastore get() {
        return datastore;
    }
}
