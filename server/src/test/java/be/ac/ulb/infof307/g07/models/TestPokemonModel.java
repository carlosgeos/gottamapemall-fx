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

import com.google.gson.Gson;
import java.util.List;

import be.ac.ulb.infof307.g07.models.PokemonModel;
import be.ac.ulb.infof307.g07.libs.Database;
import be.ac.ulb.infof307.g07.libs.errors.RequiredFieldException;
import be.ac.ulb.infof307.g07.libs.errors.WrongTypeFieldException;

public class TestPokemonModel {
    private static final Gson gson = new Gson();

    @Before
    public void setup () {
        Database.init("gmta-test");
        Database.get().getDB().dropDatabase();
    }

    @Test
    public void testCorrectCreation () throws Exception {
        String json = "{\"id\": 3, \"name\": \"test\"}";

        try {
            PokemonModel pokemon = gson.fromJson(json, PokemonModel.class);
            Database.get().save(pokemon);
        } catch (Exception e) {
            Assert.fail("Database test failed: " + e.getMessage());
        }
    }

    @Test
    public void testWrongTypeCreation () throws Exception {
        String json = "{\"id\": \"foo\", \"name\": \"test\"}";

        try {
            PokemonModel pokemon = gson.fromJson(json, PokemonModel.class);
            Database.get().save(pokemon);
            Assert.fail("Database test failed: It did not raised an exception");
        } catch (Exception e) {
        }
    }

    @Test
    public void testNameNonUnique () throws Exception {
        String json1 = "{\"id\": 1, \"name\": \"test\"}";

        PokemonModel pokemon1 = gson.fromJson(json1, PokemonModel.class);
        Database.get().save(pokemon1);

        String json2 = "{\"id\": 2, \"name\": \"test\"}";

        PokemonModel pokemon2 = gson.fromJson(json2, PokemonModel.class);
        Database.get().save(pokemon2);

        List<PokemonModel> l = Database.get().find(PokemonModel.class).field("id").equal(1).asList();

        assertEquals(l.size(), 1);
    }
}
