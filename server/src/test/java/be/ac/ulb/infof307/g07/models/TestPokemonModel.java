package be.ac.ulb.infof307.g07.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Map;
import java.util.HashMap;

import be.ac.ulb.infof307.g07.models.PokemonModel;
import be.ac.ulb.infof307.g07.lib.Database;

public class TestPokemonModel {
    @Before
    public void setup () {
        Database.init("gmta-test");
        Database.get().getDB().dropDatabase();
    }

    @Test
    public void testCorrectCreation () throws Exception {
        PokemonModel model = new PokemonModel();

        Map<String, String[]> map = new HashMap();

        map.put("id", new String[]{"3"});
        map.put("name", new String[]{"test"});

        try {
            model.set(map);
        } catch (Exception e) {
            Assert.fail("Database test failed: " + e.getMessage());
        }
    }

    @Test
    public void testFailingCreation () throws Exception {
        PokemonModel model = new PokemonModel();

        Map<String, String[]> map = new HashMap();

        map.put("id", new String[]{"foo"});
        map.put("name", new String[]{"test"});

        try {
            model.set(map);
            Assert.fail("Database test failed: It did not raised an exception");
        } catch (Exception e) {
        }
    }
}
