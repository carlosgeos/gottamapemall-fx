package be.ac.ulb.infof307.g07.views;

import static spark.Spark.*;
import spark.Request;

import org.mongodb.morphia.query.Query;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import be.ac.ulb.infof307.g07.libs.CustomGson;
import be.ac.ulb.infof307.g07.models.PokemonModel;
import be.ac.ulb.infof307.g07.libs.Database;
import be.ac.ulb.infof307.g07.libs.ListView;
import java.util.List;
import java.util.Arrays;

public final class PokemonView extends ListView<PokemonModel> {
    protected final String getRoute () {
        return "pokemons";
    }

    protected final Class<PokemonModel> getModel () {
        return PokemonModel.class;
    }

    protected String[] getFiltersFields() {
        String[] types = {"types"};
        return types;
    }

    protected final Query<PokemonModel> filter(Query<PokemonModel> current, String param, String query) {
        if (param != "types") {
            return current; 
        }

        Gson gson = CustomGson.get();
        try {
            String[] queries = gson.fromJson(query, String[].class);
            List qlist = Arrays.asList(queries);
            current = current.field(param).hasAllOf(qlist);
        } catch (JsonSyntaxException e) {
            String[] qarray = {query};
            List qlist = Arrays.asList(qarray);
            current = current.field(param).hasAllOf(qlist);
        }

        return current;
    }

    /**
     * Do not implement update route.
     */
    @Override
    protected final void updateRoute () {}

    /**
     * Do not implement delete route.
     */
    @Override
    protected final void deleteRoute () {}

    public PokemonView () {
        super();
    }
}
