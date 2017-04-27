package be.ac.ulb.infof307.g07.lib.serializers;

import org.bson.types.ObjectId;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import com.google.gson.JsonSerializationContext;

public class ObjectIdSerializer implements JsonSerializer<ObjectId> {
    public JsonElement serialize(ObjectId src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.toHexString());
    }
}
