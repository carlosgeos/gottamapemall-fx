package be.ac.ulb.infof307.g07.libs;

import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.Datastore;
import com.mongodb.MongoException;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 * La classe permet une fois qu'elle est instancié de pouvoir acceder 
 * globalement à depuis partout dans le programme à la base de donnée, 
 * ce qui évite de devoir établir une nouvelle connexions à celle-ci 
 * pour y acceder.
 *
 * @see org.mongodb.morphia.Datastore
 */
public class Database {
    private static Datastore datastore = null;

    /**
     * Établie une connexion à la base de donnée en lui attribuant un nom
     * par défaut et stocke le "Datastore" qui permet d'y acceder plus tard.
     *
     * @see org.mongodb.morphia.Datastore
     */
    public static void init () {
        init("gmta");
    }

    /**
     * Établie une connexion à la base de donnée et stocke le "Datastore"
     * qui permet d'y acceder plus tard.
     *
     * @param db Le nom de la base de donnée à utiliser.
     *
     * @see org.mongodb.morphia.Datastore
     */
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

    /**
     * Récupère le "Datastore" pour acceder à la base de donnée sur laquelle on
     * s'est connecté à l'initialisation.
     */
    public static Datastore get() {
        return datastore;
    }
}
