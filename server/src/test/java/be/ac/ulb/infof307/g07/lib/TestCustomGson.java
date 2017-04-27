package be.ac.ulb.infof307.g07.lib;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import org.bson.types.ObjectId;
import com.google.gson.Gson;
import be.ac.ulb.infof307.g07.lib.CustomGson;

public class TestCustomGson {
    @Test
    public void testGet () {
        assertNull(CustomGson.get(), null);
    }

    @Test
    public void testCreation () {
        CustomGson.create();
        assertNotEquals(CustomGson.get(), null);
    }
}
