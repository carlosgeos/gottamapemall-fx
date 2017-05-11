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

import be.ac.ulb.infof307.g07.models.LocationModel;
import be.ac.ulb.infof307.g07.libs.Database;

import org.mongodb.morphia.query.UpdateException;
import com.google.gson.JsonSyntaxException;


public class TestLocationModel {
    private static final Gson gson = new Gson();

    @Before
    public void setup () {
        Database.init("gmta-test");
        Database.get().getDB().dropDatabase();
    }

    @Test
    public void testCorrectCreation () throws Exception {
        String json = "{\"lat\": 50.0, \"lon\": 50.0, \"pokemon\":{\"id\": 3, \"name\": \"test\"}}";

        LocationModel location = gson.fromJson(json, LocationModel.class);
        Database.get().save(location);
    }

    @Test
    public void testCreationFromNothing () throws Exception {
        String json = "";

        try {
            LocationModel location = gson.fromJson(json, LocationModel.class);
            Database.get().save(location);
            Assert.fail("Database test should throw exception");
        } catch (UpdateException e) {
        }
    }

    @Test
    public void testWrongFloatTypeCreation () throws Exception {
        String json = "{\"lat\": \"feowijfew\", \"lon\": 50.0, \"pokemon\":{\"id\": 3, \"name\": \"test\"}}";

        try {
            LocationModel location = gson.fromJson(json, LocationModel.class);
            Database.get().save(location);
            Assert.fail("Database test failed: It did not raised an exception");
        } catch (NumberFormatException e) {
        }
    }

    @Test
    public void testWrongTypeCreation () throws Exception {
        String json = "{\"lat\": 50.0, \"lon\": 50.0, \"pokemon\":\"fjeiwofijew\"}";

        try {
            LocationModel location = gson.fromJson(json, LocationModel.class);
            Database.get().save(location);
            Assert.fail("Database test failed: It did not raised an exception");
        } catch (JsonSyntaxException e) {
        }
    }



    @Test
    public void testNonUnique () throws Exception {
        String json1 = "{\"lat\": 50.0, \"lon\": 50.0, \"pokemon\":{\"id\": 3, \"name\": \"test\"}}";

        LocationModel location1 = gson.fromJson(json1, LocationModel.class);
        Database.get().save(location1);

        String json2 = "{\"lat\": 50.0, \"lon\": 50.0, \"pokemon\":{\"id\": 3, \"name\": \"test\"}}";

        LocationModel location2 = gson.fromJson(json2, LocationModel.class);
        Database.get().save(location2);

        List<LocationModel> l = Database.get().find(LocationModel.class).asList();

        assertEquals(l.size(), 2);
    }
}
