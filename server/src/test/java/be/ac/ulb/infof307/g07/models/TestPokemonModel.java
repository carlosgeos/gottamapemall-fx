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

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import be.ac.ulb.infof307.g07.models.PokemonModel;
import be.ac.ulb.infof307.g07.lib.Database;
import be.ac.ulb.infof307.g07.lib.errors.RequiredFieldException;
import be.ac.ulb.infof307.g07.lib.errors.WrongTypeFieldException;

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
    public void testBlankCreation () throws Exception {
        PokemonModel model = new PokemonModel();

        Map<String, String[]> map = new HashMap();

        try {
            model.set(map);
            Assert.fail("Database test failed: It did not raised an exception");
        } catch (Exception e) {
        }
    }

    @Test
    public void testWrongTypeCreation () throws Exception {
        PokemonModel model = new PokemonModel();

        Map<String, String[]> map = new HashMap();

        map.put("id", new String[]{"foo"});
        map.put("name", new String[]{"test"});

        try {
            model.set(map);
            Assert.fail("Database test failed: It did not raised an exception");
        } catch (WrongTypeFieldException e) {
        } catch (Exception e) {
            Assert.fail("Database test failed: It did raised an exception for the wrong reason");
        }
    }

    @Test
    public void testMissingRequiredCreation () throws Exception {
        PokemonModel model = new PokemonModel();

        Map<String, String[]> map = new HashMap();

        map.put("name", new String[]{"test"});

        try {
            model.set(map);
            Assert.fail("Database test failed: It did not raised an exception");
        } catch (RequiredFieldException e) {
        } catch (Exception e) {
            Assert.fail("Database test failed: It did raised an exception for the wrong reason");
        }
    }

    @Test
    public void testNameNonUnique () throws Exception {
        PokemonModel model1 = new PokemonModel();
        Map<String, String[]> map1 = new HashMap();
        map1.put("id", new String[]{"1"});
        map1.put("name", new String[]{"test"});
        model1.set(map1);
        Database.get().save(model1);

        PokemonModel model2 = new PokemonModel();
        Map<String, String[]> map2 = new HashMap();
        map2.put("id", new String[]{"2"});
        map2.put("name", new String[]{"test"});
        model1.set(map2);
        Database.get().save(model2);

        List<PokemonModel> l = Database.get().find(PokemonModel.class).field("id").equal(1).asList();

        assertEquals(l.size(), 1);
    }

    @Test
    public void testIdNonUnique () throws Exception {
        PokemonModel model1 = new PokemonModel();
        Map<String, String[]> map1 = new HashMap();
        map1.put("id", new String[]{"1"});
        map1.put("name", new String[]{"foo"});
        model1.set(map1);
        Database.get().save(model1);

        PokemonModel model2 = new PokemonModel();
        Map<String, String[]> map2 = new HashMap();
        map2.put("id", new String[]{"1"});
        map2.put("name", new String[]{"bar"});
        model1.set(map2);
        Database.get().save(model2);

        List<PokemonModel> l = Database.get().find(PokemonModel.class).field("id").equal(1).asList();

        assertEquals(l.size(), 1);
    }
}
