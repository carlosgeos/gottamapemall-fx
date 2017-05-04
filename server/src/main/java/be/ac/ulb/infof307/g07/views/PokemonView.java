package be.ac.ulb.infof307.g07.views;

import static spark.Spark.*;
import spark.Request;

import org.mongodb.morphia.query.Query;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.lang.NumberFormatException;
import be.ac.ulb.infof307.g07.libs.CustomGson;
import be.ac.ulb.infof307.g07.models.PokemonModel;
import be.ac.ulb.infof307.g07.libs.Database;
import be.ac.ulb.infof307.g07.libs.ListView;
import java.util.List;
import java.util.Arrays;

/**
 * Vue pour voir l'ensemble des pokémons sauvegardé ainsi que leurs
 * caractéristiques.
 */
public final class PokemonView extends ListView<PokemonModel> {
    protected final String getRoute () {
        return "pokemons";
    }

    protected final Class<PokemonModel> getModel () {
        return PokemonModel.class;
    }

    /**
     * Dans la PokemonView il est possible de filtrer sur les caractéristiques:
     *  - types
     *  - base_experiece
     *  - height
     *  - weight
     */
    protected String[] getFiltersFields() {
        String[] types = {"types", "base_experience", "height", "weight"};
        return types;
    }

    /**
     * Implementation des filtres sur les champs concernés.
     */
    protected final Query<PokemonModel> filter(Query<PokemonModel> current, String param, String query) {
        if (param == "types") {
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
        } else {
            try {
                int value = Integer.parseInt(query);
                current = current.field(param).equal(value);
            } catch (NumberFormatException e) {
                // Les erreurs n'ont pas d'importance le programme 
                // ne vas juste pas filtrer.
            }
        }

        return current;
    }

    /**
     * Do not implement delete route.
     */
    @Override
    protected final void deleteRoute () {}

    public PokemonView () {
        super();
    }
}
