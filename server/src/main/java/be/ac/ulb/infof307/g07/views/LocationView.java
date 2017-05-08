package be.ac.ulb.infof307.g07.views;

import static spark.Spark.*;
import spark.Request;

import org.mongodb.morphia.query.Query;
import org.bson.types.ObjectId;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import be.ac.ulb.infof307.g07.lib.serializers.LocationDeserializer;
import com.google.gson.JsonSyntaxException;
import be.ac.ulb.infof307.g07.models.LocationModel;
import be.ac.ulb.infof307.g07.models.PokemonModel;
import be.ac.ulb.infof307.g07.libs.Database;
import be.ac.ulb.infof307.g07.libs.ListView;
import be.ac.ulb.infof307.g07.libs.Error;
import java.util.Arrays;
import java.util.List;

/**
 * Vue pour voir les markers sauvegardé par l'utilisateur ainsi
 * que leur positiion et leur pokémon associé.
 */
public final class LocationView extends ListView<LocationModel> {
    protected final String getRoute () {
        return "locations";
    }

    protected final Class<LocationModel> getModel () {
        return LocationModel.class;
    }

    /**
     * Il est possible de filtrer sur les caractéristiques du pokémon:
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
    protected final Query<LocationModel> filter(Query<LocationModel> current, String param, String query) {
        if (param == "types") {
            try {
                String[] queries = this.gson.fromJson(query, String[].class);
                List qlist = Arrays.asList(queries);
                current = current.field("pokemon.types").hasAllOf(qlist);
            } catch (JsonSyntaxException e) {
                String[] qarray = {query};
                List qlist = Arrays.asList(qarray);
                current = current.field("pokemon.types").hasAllOf(qlist);
            }
        } else {
            try {
                int value = Integer.parseInt(query);
                current = current.field("pokemon." + param).equal(value);
            } catch (NumberFormatException e) {
                // Les erreurs n'ont pas d'importance le programme 
                // ne vas juste pas filtrer.
            }
        }

        return current;
    }

    /**
     * Défini la manière de récupérer un ObjectId.
     */
    @Override
    protected final Object getDetail (Request req) throws Exception {
         return getParam(req, ":detail", (val) -> {
            if (!ObjectId.isValid(val)) {
                throw new Exception("Invalid id");
            }
            return new ObjectId(val);
        });
    }

    public LocationView () {
        super();
    }
}
