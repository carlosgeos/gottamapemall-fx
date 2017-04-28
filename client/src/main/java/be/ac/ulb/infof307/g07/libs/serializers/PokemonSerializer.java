package be.ac.ulb.infof307.g07.libs.serializers;

import be.ac.ulb.infof307.g07.Models.Pokemon;
import net.dongliu.requests.Requests;
import com.google.gson.Gson;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonDeserializationContext;
import java.lang.reflect.Type;
import com.google.gson.JsonSerializationContext;

public class PokemonSerializer implements JsonSerializer<Pokemon> {
    public JsonElement serialize(Pokemon src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.getId());
    }

    public Pokemon deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        System.out.println("Deserializing pokemon");
        String pid = json.getAsJsonPrimitive().getAsString();
        String response = Requests.get("http://127.0.0.1:4567/pokemons/" + pid).send().readToText();
        Gson gson = new Gson();
        Pokemon pokemon = gson.fromJson(response, Pokemon.class);
        return pokemon;
    }
}
