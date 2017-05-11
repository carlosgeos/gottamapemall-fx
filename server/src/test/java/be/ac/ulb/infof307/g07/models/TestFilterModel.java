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

import be.ac.ulb.infof307.g07.models.FilterModel;
import be.ac.ulb.infof307.g07.libs.Database;

import org.mongodb.morphia.query.UpdateException;
import com.google.gson.JsonSyntaxException;

public class TestFilterModel {
    private static final Gson gson = new Gson();

    @Before
    public void setup () {
        Database.init("gmta-test");
        Database.get().getDB().dropDatabase();
    }

    @Test
    public void testCorrectCreation () throws Exception {
        String json = "{\"query\": \"?search=brol\"}";

        FilterModel location = gson.fromJson(json, FilterModel.class);
        Database.get().save(location);
    }

    @Test
    public void testCreationFromNothing () throws Exception {
        String json = "";

        try {
            FilterModel location = gson.fromJson(json, FilterModel.class);
            Database.get().save(location);
            Assert.fail("Database test should throw exception");
        } catch (UpdateException e) {
        }
    }

    @Test
    public void testWrongTypeCreation () throws Exception {
        String json = "{\"query\": 50}";

        FilterModel location = gson.fromJson(json, FilterModel.class);
        Database.get().save(location);
        assertNotNull(Database.get().find(FilterModel.class).field("query").equal("50"));
    }

    @Test
    public void testNonUnique () throws Exception {
        String json1 = "{\"query\": \"?search=brol\"}";

        FilterModel location1 = gson.fromJson(json1, FilterModel.class);
        Database.get().save(location1);

        String json2 = "{\"query\": \"?search=brol\"}";

        FilterModel location2 = gson.fromJson(json2, FilterModel.class);
        Database.get().save(location2);

        List<FilterModel> l = Database.get().find(FilterModel.class).asList();

        assertEquals(l.size(), 2);
    }
}
