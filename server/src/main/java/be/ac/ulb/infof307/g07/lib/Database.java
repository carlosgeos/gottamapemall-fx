package be.ac.ulb.infof307.g07.lib;

import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.Datastore;
import com.mongodb.MongoException;
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
	final String prod_db = "mongodb://gmta:bonjourmdp@ds163010.mlab.com:63010/gmta";
	final String test_db = "mongodb://gmta:bonjourmdp@ds115131.mlab.com:15131/gmta-test";
        morphia.mapPackage("be.ac.ulb.infof307.g07");

        try {
            // connect to the database on mLab
	    String db_uri = (db.equals("gmta-test")) ? test_db : prod_db;
            datastore = morphia.createDatastore(new MongoClient(new MongoClientURI(db_uri)), db);
            datastore.ensureIndexes();
        } catch (MongoException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(1);
        }
    }

    public static Datastore get() {
        return datastore;
    }
}
