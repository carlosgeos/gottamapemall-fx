package be.ac.ulb.infof307.g07.views;

import static spark.Spark.*;
import spark.Request;

import org.bson.types.ObjectId;
import java.lang.IllegalArgumentException;

import be.ac.ulb.infof307.g07.models.LocationModel;
import be.ac.ulb.infof307.g07.libs.Database;
import be.ac.ulb.infof307.g07.libs.ListView;
import be.ac.ulb.infof307.g07.libs.Error;

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
     * Défini la manière de récupérer un ObjectId.
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

    public LocationView () {
        super();
    }
}
