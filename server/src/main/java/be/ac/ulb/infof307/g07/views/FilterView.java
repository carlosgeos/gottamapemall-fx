package be.ac.ulb.infof307.g07.views;

import static spark.Spark.*;
import spark.Request;
import java.lang.IllegalArgumentException;

import org.bson.types.ObjectId;

import be.ac.ulb.infof307.g07.models.FilterModel;
import be.ac.ulb.infof307.g07.libs.Database;
import be.ac.ulb.infof307.g07.libs.ListView;
import be.ac.ulb.infof307.g07.libs.Error;

import java.util.List;

/**
 * Vue pour voir les filtres sauvegardé par l'utilisateur.
 */
public final class FilterView extends ListView<FilterModel> {
    protected final String getRoute () {
        return "filters";
    }

    protected final Class<FilterModel> getModel () {
        return FilterModel.class;
    }

    /**
     * Un object est accedé en utilisant la forme hexadecimal d'un ObjectId.
     */
    @Override
    protected final Object getDetail (Request req) throws IllegalArgumentException {
         return getParam(req, ":detail", (val) -> {
            if (!ObjectId.isValid(val)) {
                throw new IllegalArgumentException("Invalid id.");
            }
            return new ObjectId(val);
        });
    }

    public FilterView () {
        super();
    }
}
