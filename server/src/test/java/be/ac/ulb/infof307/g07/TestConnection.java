package be.ac.ulb.infof307.g07;

import org.junit.Assert;
import org.junit.Test;

import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.Datastore;
import com.mongodb.MongoClient;

import be.ac.ulb.infof307.g07.lib.Database;

public class TestConnection {
    @Test
    public void testConnection () {
        new Morphia().createDatastore(new MongoClient(), "gmta");
    }

    @Test
    public void testDbConnection () {
        Database.init();
    }

    @Test
    public void testTestDbConnection () {
        Database.init("gmta-test");
        Database.get().getDB().dropDatabase();
    }
}
