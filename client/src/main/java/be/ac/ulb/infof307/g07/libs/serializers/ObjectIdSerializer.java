package be.ac.ulb.infof307.g07.libs.serializers;

import org.bson.types.ObjectId;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonDeserializationContext;
import java.lang.reflect.Type;
import com.google.gson.JsonSerializationContext;

public class ObjectIdSerializer implements JsonSerializer<ObjectId> {
    public JsonElement serialize(ObjectId src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.toHexString());
    }

    public ObjectId deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        System.out.println("Deserializing object id");
        return new ObjectId(json.getAsJsonPrimitive().getAsString());
    }
}
